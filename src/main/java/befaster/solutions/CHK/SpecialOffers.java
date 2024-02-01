package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
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

    private static List<SpecialOffer> getAllAvailableOffersBySkuAndNumberOfItems(StockKeepingUnits sku, int numberOfItems) {
        return SPECIAL_OFFERS.stream()
                .filter(specialOffer -> specialOffer.getSku().equals(sku) && specialOffer.getNumberOfItems() <= numberOfItems)
                .toList();
    }

    public static List<SpecialOffer> getAllAvailableOffersInCart(final Map<StockKeepingUnits, Integer> cart) {
        return cart.entrySet().stream()
                .map(entry -> getAllAvailableOffersBySkuAndNumberOfItems(entry.getKey(), entry.getValue()))
                .flatMap(List::stream)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public static List<SpecialOffer> getAllOffersToBeAppliedInCart(final Map<StockKeepingUnits, Integer> cart) {
        List<SpecialOffer> specialOffersAvailable = getAllAvailableOffersInCart(cart);
        Map<StockKeepingUnits, Integer> remainingItemsInCart = new EnumMap<>(cart);
        List<SpecialOffer> specialOffersToBeApplied = new ArrayList<>();

        specialOffersAvailable.forEach(offer -> {
            StockKeepingUnits sku = offer.getSku();
            int cartItemCount = remainingItemsInCart.getOrDefault(sku, 0);
            int offerItemCount = offer.getNumberOfItems();
            int eligibleOffers = cartItemCount / offerItemCount;
            if (eligibleOffers > 0) {
                SpecialOffer appliedOffer = offer.hasNewOffer() ? offer.getNewOffer() : offer;
                specialOffersToBeApplied.addAll(Collections.nCopies(eligibleOffers, appliedOffer));
                remainingItemsInCart.put(offer.getSku(), cartItemCount % offerItemCount);
            }
        });
        specialOffersToBeApplied.sort(Comparator.reverseOrder());
        return specialOffersToBeApplied;
    }
}
