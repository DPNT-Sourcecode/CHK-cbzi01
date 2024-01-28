package befaster.solutions.CHK;

public enum StockKeepingUnits {
    A(50),
    B(30),
    C(20),
    D(15);

    private final int price;

    StockKeepingUnits(final int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}

