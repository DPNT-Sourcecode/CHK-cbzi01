package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Map<Character, Integer> skusCount = groupAndCountNumberOfSameSkus(skus);

        int totalSum = 0;
        for (Map.Entry<Character, Integer> entry : skusCount.entrySet()) {
            char sku = entry.getKey();
            int count = entry.getValue();
            if (StockKeepingUnits.getStockKeepingPrice(sku) == -1) {
                return -1;
            }
            totalSum += calculatePrice(sku, count, 0);
        }
        return totalSum;
    }

    private Map<Character, Integer> groupAndCountNumberOfSameSkus(final String skus) {
        Map<Character, Integer> skusCount = new HashMap<>();
        for (char sku : skus.toCharArray()) {
            if (skusCount.containsKey(sku)) {
                skusCount.put(sku, skusCount.get(sku) + 1);
            } else {
                skusCount.put(sku, 1);
            }
        }
        return skusCount;
    }

//    private int calculatePrice(char sku, int count, int startingPrice) {
//        int totalPrice = startingPrice;
//        for (SpecialOffers specialOffer : SpecialOffers.values()) {
//            if (specialOffer.getSku() == sku && count >= specialOffer.getNumberOfItems()) {
//                if(count % specialOffer.getNumberOfItems() != 0) {
//                    int newCount = count - specialOffer.getNumberOfItems();
//                    totalPrice += calculatePrice(sku, newCount, specialOffer.getSpecialPrice());
//                } else {
//                    totalPrice += specialOffer.getSpecialPrice();
//                }
//            } else {
//                totalPrice += StockKeepingUnits.getStockKeepingPrice(sku) * count;
//            }
//        }
//        return totalPrice;
//    }

    private int calculatePrice(char sku, int count, int startingPrice) {
        int totalPrice = 0;
        boolean foundSpecialOffer;

        for (SpecialOffers specialOffer : SpecialOffers.values()) {
            foundSpecialOffer = specialOffer.getSku() == sku && count >= specialOffer.getNumberOfItems();
            if (!foundSpecialOffer) {
                return startingPrice + StockKeepingUnits.getStockKeepingPrice(sku) * count;
            }

            if (count > specialOffer.getNumberOfItems()) {
                int newCount = count - specialOffer.getNumberOfItems();
                return startingPrice + calculatePrice(sku, newCount, specialOffer.getSpecialPrice());
            } else {
                totalPrice = specialOffer.getSpecialPrice();
            }
        }
        return totalPrice;
    }
}




