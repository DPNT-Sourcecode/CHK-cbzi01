package befaster.solutions.CHK;

public enum SpecialOffers {
    A('A', 3, 130),
    B('B', 2, 45);

    private final char sku;
    private final int numberOfItems;
    private final int specialPrice;

    SpecialOffers(final char sku, final int numberOfItems, final int specialPrice) {
        this.sku = sku;
        this.numberOfItems = numberOfItems;
        this.specialPrice = specialPrice;
    }

    public char getSku() {
        return sku;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }

    public static int getnumberOfSpecialOffer(final char sku, final int count) {
        int numberOfSpecialOffers = 0;
        for (SpecialOffers specialOffer : SpecialOffers.values()) {
            if (specialOffer.getSku() != sku) {
                continue;
            }
            if (count % specialOffer.getNumberOfItems() == 0) {
                numberOfSpecialOffers = count / specialOffer.getNumberOfItems();
            } else {
                numberOfSpecialOffers = specialOffer.getNumberOfItems();
            }
        }
        return numberOfSpecialOffers;
    }

    public static boolean hasSpecialOffer(final char sku, final int count) {
        for (SpecialOffers specialOffer : SpecialOffers.values()) {
            if (specialOffer.getSku() == sku && count >= specialOffer.getNumberOfItems()) {
                return true;
            }
        }
        return false;
    }

}
