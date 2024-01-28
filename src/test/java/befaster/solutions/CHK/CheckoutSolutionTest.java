package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {

    @Test
    void testIfWhenCheckoutWithOneItemItgetsTheCorrectValue() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("A");
        int expectedResult = 50;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithTwoDifferentItensItgetsTheCorrectValue() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AB");
        int expectedResult = 80;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithFourDifferentItensItgetsTheCorrectValue() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("CDBA");
        int expectedResult = 115;

        assertEquals(expectedResult, result);
    }

    @Test
    void testIfWhenCheckoutWithTwoEqualItensItgetsTheCorrectValue() {
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
//        assertEquals(175, checkoutSolution.checkout("AAABB"));
//        assertEquals(190, checkoutSolution.checkout("AAABBD"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(-1, checkoutSolution.checkout("E"));
    }

    @Test
    void testIfWhenCheckoutWithThreeEqualItensAndTwoDifferentItemItGetsTheSpecialPricePlusTheOriginalPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAABB");
        int expectedResult = 175;

        assertEquals(expectedResult, result);
//        assertEquals(175, checkoutSolution.checkout("AAABB"));
//        assertEquals(190, checkoutSolution.checkout("AAABBD"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(-1, checkoutSolution.checkout("E"));
    }
}



