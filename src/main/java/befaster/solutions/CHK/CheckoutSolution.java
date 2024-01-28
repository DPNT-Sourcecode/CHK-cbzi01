package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int totalSum = 0;
        //List<Character> skusCount =

        Map<Character, Integer> skusCount = groupAndCountNumberOfSameSkus(skus);

        skusCount.forEach((

        for (char sku : skus.toCharArray()) {
            if (StockKeepingUnits.getStockKeepingPrice(sku) == -1) {
                return -1;
            }

            totalSum += StockKeepingUnits.getStockKeepingPrice(sku);
        }

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
}

