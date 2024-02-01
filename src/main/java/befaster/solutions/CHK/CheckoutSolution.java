package befaster.solutions.CHK;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        return calculateTotal(skus);
    }

    private Map<StockKeepingUnits, Integer> getCart(final String skus) throws IllegalArgumentException {
        Map<StockKeepingUnits, Integer> cart = new EnumMap<>(StockKeepingUnits.class);
        skus.chars()
                .mapToObj(c -> StockKeepingUnits.valueOf(String.valueOf((char) c)))
                .forEach(sku -> cart.merge(sku, 1, Integer::sum));

        return cart;
    }

    private int calculateTotal(final String skus) {
        try {
            Map<StockKeepingUnits, Integer> cart = getCart(skus);
            List<SpecialOffer> specialOffers = SpecialOffers.getAllOffersToBeAppliedInCart(cart);

            int totalValueOfItemsWithDiscount = specialOffers.stream()
                    .mapToInt(specialOffer -> applyDiscountsAndUpdateCart(specialOffer, cart))
                    .reduce(0, Integer::sum);

            int totalValueOfItemsWithoutDiscount = cart.entrySet().stream()
                    .mapToInt(entry -> PriceTable.getPriceBySku(entry.getKey()) * entry.getValue())
                    .reduce(0, Integer::sum);

            return totalValueOfItemsWithDiscount + totalValueOfItemsWithoutDiscount;

        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    private int applyDiscountsAndUpdateCart(final SpecialOffer offer, final Map<StockKeepingUnits, Integer> cart) {
        int totalPriceWithDiscount = 0;
        StockKeepingUnits sku = offer.getSku();
        int cartItemCount = cart.getOrDefault(sku, 0);
        int offerItemCount = offer.getNumberOfItems();

        if (cartItemCount >= offerItemCount) {
            totalPriceWithDiscount = offer.getFinalSellingPrice();
            cartItemCount -= offerItemCount;
            cart.put(sku, cartItemCount);
        }
        return totalPriceWithDiscount;
    }
}
