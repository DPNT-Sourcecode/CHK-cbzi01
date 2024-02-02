package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
    private final GroupDiscountOffer groupDiscountOffer = new GroupDiscountOffer(List.of(
            StockKeepingUnits.S,
            StockKeepingUnits.T,
            StockKeepingUnits.X,
            StockKeepingUnits.Y,
            StockKeepingUnits.Z
    ), 3, 45);

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
            StringBuilder skusWithoutDiscountOffer = new StringBuilder();
            int totalValueOfItemsWithGroupDiscountOffer = getTotalValueOfItemsWithGroupDiscountOffer(skus, skusWithoutDiscountOffer);

            Map<StockKeepingUnits, Integer> cart = getCart(skusWithoutDiscountOffer.toString());
            List<SpecialOffer> specialOffers = SpecialOffers.getAllOffersToBeAppliedInCart(cart);

            int totalValueOfItemsWithDiscount = specialOffers.stream()
                    .mapToInt(specialOffer -> applyDiscountsAndUpdateCart(specialOffer, cart))
                    .reduce(0, Integer::sum);

            int totalValueOfItemsWithoutDiscount = cart.entrySet().stream()
                    .mapToInt(entry -> PriceTable.getPriceBySku(entry.getKey()) * entry.getValue())
                    .reduce(0, Integer::sum);

            return totalValueOfItemsWithGroupDiscountOffer + totalValueOfItemsWithDiscount + totalValueOfItemsWithoutDiscount;

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

    private List<StockKeepingUnits> getStockKeepingUnitsWithGroupDiscountOffer(final String skus) {
        return skus.chars()
                .mapToObj(c -> StockKeepingUnits.valueOf(String.valueOf((char) c)))
                .filter(groupDiscountOffer.skus()::contains)
                .toList();
    }

    private int getTotalValueOfItemsWithGroupDiscountOffer(final String skus, StringBuilder skusWithoutDiscountOffer) {
        List<StockKeepingUnits> stockKeepingUnitsList = new ArrayList<>(getStockKeepingUnitsWithGroupDiscountOffer(skus));
        int totalValueOfItemsWithGroupDiscountOffer = 0;
        if(stockKeepingUnitsList.size() >= groupDiscountOffer.numberOfItems()) {
            if (stockKeepingUnitsList.size() % groupDiscountOffer.numberOfItems() == 0) {
                //Can have more than one discount group
                int eligibleOffers = stockKeepingUnitsList.size() / groupDiscountOffer.numberOfItems();
                totalValueOfItemsWithGroupDiscountOffer = groupDiscountOffer.finalSellingPrice() * eligibleOffers;
            } else {
                //Get the number of items defined in group discount offer with higher unit price
                stockKeepingUnitsList.sort(Comparator.comparing(PriceTable::getPriceBySku).reversed());
                StockKeepingUnits skuWithLowestUnitPrice = stockKeepingUnitsList.get(stockKeepingUnitsList.size() - 1);
                skusWithoutDiscountOffer.append(skuWithLowestUnitPrice);
                totalValueOfItemsWithGroupDiscountOffer = groupDiscountOffer.finalSellingPrice();
            }
        } else{
            skusWithoutDiscountOffer.append(skus);
        }
        return totalValueOfItemsWithGroupDiscountOffer;
    }
}


