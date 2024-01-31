package befaster.solutions.CHK;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        return getTotal(groupAndCountNumberOfSameSkus(skus));
    }

    private Map<String, Integer> groupAndCountNumberOfSameSkus(final String skus) {
        Map<String, Integer> skusCount = new HashMap<>();
        Arrays.stream(skus.split(""))
                .forEach(sku -> {
                    if (skusCount.containsKey(sku)) {
                        skusCount.put(sku, skusCount.get(sku) + 1);
                    } else {
                        skusCount.put(sku, 1);
                    }
                });

        return skusCount;
    }

    private int getTotal(final Map<String, Integer> cart) {
        List<SpecialOffer> specialOffers = SpecialOffers.getValidOffersFromCart(cart);
        Map<String, Integer> cartCopy = new HashMap<>(cart);
        int totalValueOfItemsWithDiscount = specialOffers.stream()
                .mapToInt(specialOffer -> applyDiscounts(specialOffer, cartCopy))
                .reduce(0, Integer::sum);

        int totalValueOfItemsWithoutDiscount = cartCopy.entrySet().stream()
                .mapToInt(entry -> PriceTable.getPriceBySku(entry.getKey()) * entry.getValue())
                .reduce(0, Integer::sum);

        return totalValueOfItemsWithDiscount + totalValueOfItemsWithoutDiscount;
    }

    private int applyDiscounts(final SpecialOffer specialOffer, final Map<String, Integer> cart) {
        String sku = specialOffer.getSku().name();
        int totalPriceWithDiscount = 0;
        int numberOfItemsMissingVerification = cart.get(sku);
        int maximumNumberOfItemsWithDiscountAvailable = specialOffer.getNumberOfItems();
        if (numberOfItemsMissingVerification >= maximumNumberOfItemsWithDiscountAvailable) {
            totalPriceWithDiscount = specialOffer.getFinalSellingPrice();
            numberOfItemsMissingVerification -= specialOffer.getNumberOfItems();
            cart.put(sku, numberOfItemsMissingVerification);
        }
        return totalPriceWithDiscount;
    }

}

