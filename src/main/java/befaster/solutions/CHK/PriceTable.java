package befaster.solutions.CHK;

import java.util.EnumMap;
import java.util.Map;

public class PriceTable {
    private static final Map<StockKeepingUnits, Integer> PRICE_TABLE = new EnumMap<>(StockKeepingUnits.class);

    static {
        PRICE_TABLE.put(StockKeepingUnits.A, 50);
        PRICE_TABLE.put(StockKeepingUnits.B, 30);
        PRICE_TABLE.put(StockKeepingUnits.C, 20);
        PRICE_TABLE.put(StockKeepingUnits.D, 15);
        PRICE_TABLE.put(StockKeepingUnits.E, 40);
    }

    public static int getPriceBySku(String sku) {
        try {
            StockKeepingUnits stockKeepingUnits = StockKeepingUnits.valueOf(sku);
            int result = -1;
            if (PRICE_TABLE.containsKey(stockKeepingUnits)) {
                result = PRICE_TABLE.get(StockKeepingUnits.valueOf(sku));
            }
            return result;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    public static int getPriceBySku(StockKeepingUnits sku) {
        if (PRICE_TABLE.containsKey(sku)) {
            return PRICE_TABLE.get(sku);
        }
        return -1;
    }
}
