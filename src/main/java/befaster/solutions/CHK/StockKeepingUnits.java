package befaster.solutions.CHK;

public enum StockKeepingUnits {
    A('A', 50),
    B('B', 30),
    C('C', 20),
    D('D', 15);

    private final char sku;
    private final int price;

    StockKeepingUnits(final char sku, final int price) {
        this.sku = sku;
        this.price = price;
    }

    public char getSku() {
        return sku;
    }

    public int getPrice() {
        return price;
    }

    public static int getStockKeepingPrice(char sku) {
        for (StockKeepingUnits stockKeepingUnit : StockKeepingUnits.values()) {
            if(stockKeepingUnit.getSku() == sku) {
                return stockKeepingUnit.getPrice();
            }
        }
        return -1;
    }
}
