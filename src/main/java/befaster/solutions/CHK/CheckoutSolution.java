package befaster.solutions.CHK;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
            totalSum += calculatePrice(sku, count);
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

    private int calculatePrice(char sku, int count) {
        if(!SpecialOffers.hasSpecialOffer(sku, count)) {
            return StockKeepingUnits.getStockKeepingPrice(sku) * count;
        }

        int totalPrice = 0;/
        for (SpecialOffers specialOffer : SpecialOffers.values()) {
            if (specialOffer.getSku() != sku) {
                continue;
            }
            if (count % specialOffer.getNumberOfItems() == 0) {
                int numberOfSpecialOffers = count / specialOffer.getNumberOfItems();
                totalPrice = specialOffer.getSpecialPrice() * numberOfSpecialOffers;
                break;
            } else {
                int numberOfNonSpecialOffers = count - specialOffer.getNumberOfItems();
                totalPrice = specialOffer.getSpecialPrice()
                        + StockKeepingUnits.getStockKeepingPrice(sku) * numberOfNonSpecialOffers;
                break;
            }
        }
        return totalPrice;
    }




}


