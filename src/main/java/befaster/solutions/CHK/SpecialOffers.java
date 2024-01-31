package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialOffers {
    private static final List<SpecialOffer> SPECIAL_OFFERS = new ArrayList<>();

    static {
        SPECIAL_OFFERS.add(new SpecialOffer(StockKeepingUnits.A, 3, 130));
        SPECIAL_OFFERS.add(new SpecialOffer(StockKeepingUnits.A, 5, 200));
        SPECIAL_OFFERS.add(new SpecialOffer(StockKeepingUnits.B, 2, 45));
        SPECIAL_OFFERS.add(new SpecialOffer(StockKeepingUnits.E, 2, new SpecialOffer(StockKeepingUnits.B, 1, 0)));
    }

    public static List<SpecialOffer> getAllAvailableOffersBySku(String sku) {
        try {
            StockKeepingUnits stockKeepingUnits = StockKeepingUnits.valueOf(sku);
            return SPECIAL_OFFERS.stream()
                    .filter(specialOffer -> specialOffer.getSku().equals(stockKeepingUnits))
                    .map(SpecialOffer::getSpecialOffer)
                    .sorted(Comparator.reverseOrder())
                    .toList();
        } catch (IllegalArgumentException e) {
            return Collections.emptyList();
        }
    }

    public static List<SpecialOffer> getAllAvailableOffersInCart(final Map<String, Integer> cart) {
        return cart.keySet().stream()
                .map(SpecialOffers::getAllAvailableOffersBySku)
                .flatMap(List::stream)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public static List<SpecialOffer> getValidOffersFromCart(final Map<String, Integer> cart) {
        List<SpecialOffer> specialOffers = getAllAvailableOffersInCart(cart);
        Map<String, Integer> cartCopy = new HashMap<>(cart);
        List<SpecialOffer> validOffers = new ArrayList<>();
        specialOffers.forEach(specialOffer -> {
            String sku = specialOffer.getSku().name();
            if (cartCopy.containsKey(sku)) {
                int numberOfItemsMissingVerification = cartCopy.get(sku);
                int maximumNumberOfItemsWithDiscountAvailable = specialOffer.getNumberOfItems();
                if (numberOfItemsMissingVerification >= maximumNumberOfItemsWithDiscountAvailable) {
                    validOffers.add(specialOffer);
                    numberOfItemsMissingVerification -= specialOffer.getNumberOfItems();
                    cartCopy.put(sku, numberOfItemsMissingVerification);
                }
            }
        });
        return validOffers;
    }
}
