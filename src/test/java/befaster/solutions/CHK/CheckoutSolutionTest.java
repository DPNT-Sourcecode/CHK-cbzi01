package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;

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
        int expectedResult = 230;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithSixEqualItensItgetsTheSpecialPricePlusTheOriginalPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAAAAA");
        int expectedResult = 260;

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
        int result = checkoutSolution.checkout("E");
        int expectedResult = -1;

        assertEquals(expectedResult, result);
    }
    @Test
    void testIfWhenCheckoutWithMultipleDifferentsItensItGetsCorrectPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("ABCDCBAABCABBAAA");
        int expectedResult = 505;

        assertEquals(expectedResult, result);
    }


}
