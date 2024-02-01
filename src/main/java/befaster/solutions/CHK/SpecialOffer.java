package befaster.solutions.CHK;

import java.util.Objects;

public final class SpecialOffer implements Comparable<SpecialOffer> {
    private final StockKeepingUnits sku;
    private final Integer numberOfItems;
    private final Integer finalSellingPrice;
    private final SpecialOffer newOffer;

    private Double discountPercentage;

    private SpecialOffer(final StockKeepingUnits sku,
                         final Integer numberOfItems,
                         final Integer finalSellingPrice,
                         final SpecialOffer newOffer) {
        this.sku = sku;
        this.numberOfItems = numberOfItems;
        this.finalSellingPrice = finalSellingPrice;
        this.newOffer = newOffer;
        this.discountPercentage = 0.0;
    }

    public SpecialOffer(StockKeepingUnits sku, int numberOfItems, int finalSellingPrice) {
        this(sku, numberOfItems, finalSellingPrice, null);
        this.discountPercentage = calculateDiscountPercentage(sku, numberOfItems, finalSellingPrice);
    }

    public SpecialOffer(StockKeepingUnits sku, int numberOfItems, SpecialOffer newOffer) {
        this(sku, numberOfItems, null, newOffer);
        newOffer.discountPercentage = calculateDiscountPercentage(sku, newOffer.getNumberOfItems(), newOffer.getFinalSellingPrice());
    }

    private Double calculateDiscountPercentage(StockKeepingUnits sku, int numberOfItems, int finalSellingPrice){
        double originalPrice = (PriceTable.getPriceBySku(sku) * numberOfItems);
        double discountPrice = originalPrice - finalSellingPrice;
        return (discountPrice/originalPrice) * 100;
    }

    public StockKeepingUnits getSku() {
        return sku;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public Integer getFinalSellingPrice() {
        return finalSellingPrice;
    }

    public SpecialOffer getNewOffer() {
        return newOffer;
    }

    public boolean hasNewOffer() {
        return Objects.nonNull(newOffer);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialOffer that = (SpecialOffer) o;

        if (sku != that.sku) return false;
        if (!numberOfItems.equals(that.numberOfItems)) return false;
        if (!Objects.equals(finalSellingPrice, that.finalSellingPrice))
            return false;
        if (!discountPercentage.equals(that.discountPercentage)) return false;
        return Objects.equals(newOffer, that.newOffer);
    }

    @Override
    public int hashCode() {
        int result = sku.hashCode();
        result = 31 * result + numberOfItems.hashCode();
        result = 31 * result + (finalSellingPrice != null ? finalSellingPrice.hashCode() : 0);
        result = 31 * result + discountPercentage.hashCode();
        result = 31 * result + (newOffer != null ? newOffer.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(final SpecialOffer o) {
        return Double.compare(this.discountPercentage, o.discountPercentage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SpecialOffer{");
        sb.append("sku=").append(sku);
        sb.append(", numberOfItems=").append(numberOfItems);
        sb.append(", finalSellingPrice=").append(finalSellingPrice);
        sb.append(", discountPercentage=").append(discountPercentage);
        sb.append(", specialOffer=").append(newOffer);
        sb.append('}');
        return sb.toString();
    }
}
