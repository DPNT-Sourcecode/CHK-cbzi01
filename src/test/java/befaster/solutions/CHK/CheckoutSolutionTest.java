package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {

    @Test
    void testIfWhenCheckoutWithOneItemItgetsTheCorrectPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("A");
        int expectedResult = 50;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithTwoDifferentItensItgetsTheCorrectPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AB");
        int expectedResult = 80;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithFourDifferentItensItgetsTheCorrectPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("CDBA");
        int expectedResult = 115;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithTwoEqualItensItgetsTheCorrectPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AA");
        int expectedResult = 100;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithThreeEqualItensItgetsTheSpecialPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAA");
        int expectedResult = 130;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithFourEqualItensItgetsTheSpecialPricePlusTheOriginalPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAAA");
        int expectedResult = 180;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithFiveEqualItensItgetsTheSpecialPricePlusTheOriginalPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAAAA");
        int expectedResult = 200;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithSixEqualItensItgetsTheSpecialPricePlusTheOriginalPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAAAAA");
        int expectedResult = 250;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithThreeEqualItensAndOneDifferentItemItGetsTheSpecialPricePlusTheOriginalPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAAB");
        int expectedResult = 160;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithThreeEqualItensAndTwoDifferentItemItGetsTheSpecialPricePlusTheOriginalPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAABB");
        int expectedResult = 175;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithThreeEqualItensAndThreeDifferentItemItGetsTheSpecialPricePlusTheOriginalPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAABBD");
        int expectedResult = 190;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithMultipleItensItGetsTheCorrectPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("DABABA");
        int expectedResult = 190;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithInvalidItenItGetsNegativeOne() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("F");
        int expectedResult = -1;

        assertEquals(expectedResult, result);
    }


    @Test
    void testIfWhenCheckoutWithMultipleItemsDiscountItensItGetsCorrectPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("EEB");
        int expectedResult = 80;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithMultipleItemsDiscountItensItGetstheBestPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("EEBBB");
        int expectedResult = 125;

        assertEquals(expectedResult, result);
    }

    @Test
    void testWhenReceiveEmptyInputItMustReturnNegativeOne() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("");
        int expectedResult = 0;

        assertEquals(expectedResult, result);
    }
    @Test
    void testWhenReceiveLowerLetterInputItMustReturnNegativeOne() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("ABCa");
        int expectedResult = -1;

        assertEquals(expectedResult, result);
    }

    @Test
    void testWhenReceiveLowerLetterThatNotExistsInputItMustReturnNegativeOne() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AxA");
        int expectedResult = -1;

        assertEquals(expectedResult, result);
    }

    @Test
    void test() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        List<String> skus = List.of("ABCDE", "AAAAAAAAAA", "EEEEBB");
        List<Integer> expectedResults = List.of(155, 400, 160);
        skus.forEach(sku -> {
            int result = checkoutSolution.checkout(sku);
            int expectedResult = expectedResults.get(skus.indexOf(sku));
            assertEquals(expectedResult, result);
        });
    }

    @ParameterizedTest
    @ValueSource(String = "ABCDE", "AAAAAAAAAA", "EEEEBB" )
    void test() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        List<String> skus = List.of("ABCDE", "AAAAAAAAAA", "EEEEBB");
        List<Integer> expectedResults = List.of(155, 400, 160);
        skus.forEach(sku -> {
            int result = checkoutSolution.checkout(sku);
            int expectedResult = expectedResults.get(skus.indexOf(sku));
            assertEquals(expectedResult, result);
        });
    }



}

