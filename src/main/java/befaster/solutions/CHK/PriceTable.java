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
        PRICE_TABLE.put(StockKeepingUnits.F, 10);
        PRICE_TABLE.put(StockKeepingUnits.G, 20);
        PRICE_TABLE.put(StockKeepingUnits.H, 10);
        PRICE_TABLE.put(StockKeepingUnits.I, 35);
        PRICE_TABLE.put(StockKeepingUnits.J, 60);
        PRICE_TABLE.put(StockKeepingUnits.K, 70);
        PRICE_TABLE.put(StockKeepingUnits.L, 90);
        PRICE_TABLE.put(StockKeepingUnits.M, 15);
        PRICE_TABLE.put(StockKeepingUnits.N, 40);
        PRICE_TABLE.put(StockKeepingUnits.O, 10);
        PRICE_TABLE.put(StockKeepingUnits.P, 50);
        PRICE_TABLE.put(StockKeepingUnits.Q, 30);
        PRICE_TABLE.put(StockKeepingUnits.R, 50);
        PRICE_TABLE.put(StockKeepingUnits.S, 20);
        PRICE_TABLE.put(StockKeepingUnits.T, 20);
        PRICE_TABLE.put(StockKeepingUnits.U, 40);
        PRICE_TABLE.put(StockKeepingUnits.V, 50);
        PRICE_TABLE.put(StockKeepingUnits.W, 20);
        PRICE_TABLE.put(StockKeepingUnits.X, 17);
        PRICE_TABLE.put(StockKeepingUnits.Y, 20);
        PRICE_TABLE.put(StockKeepingUnits.Z, 21);
    }

    public static int getPriceBySku(StockKeepingUnits sku) {
        if (PRICE_TABLE.containsKey(sku)) {
            return PRICE_TABLE.get(sku);
        }
        return -1;
    }
}
