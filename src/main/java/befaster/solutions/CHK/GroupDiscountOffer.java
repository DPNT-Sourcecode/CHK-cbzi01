package befaster.solutions.CHK;

import java.util.List;

public record GroupDiscountOffer(List<StockKeepingUnits> skus, int numberOfItems, int finalSellingPrice) {
}

