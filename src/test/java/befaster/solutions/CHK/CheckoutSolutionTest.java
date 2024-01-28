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
//        assertEquals(180, checkoutSolution.checkout("AAAA"));
//        assertEquals(230, checkoutSolution.checkout("AAAAA"));
//        assertEquals(260, checkoutSolution.checkout("AAAAAA"));
//        assertEquals(160, checkoutSolution.checkout("AAAB"));
//        assertEquals(175, checkoutSolution.checkout("AAABB"));
//        assertEquals(190, checkoutSolution.checkout("AAABBD"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(-1, checkoutSolution.checkout("E"));
    }

    @Test
    void testIfWhenCheckoutWithFourEqualItensItgetsTheSpecialPricePlusTheOriginalPrice() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AAAA");
        int expectedResult = 180;

        assertEquals(expectedResult, result);
//        assertEquals(180, checkoutSolution.checkout("AAAA"));
//        assertEquals(230, checkoutSolution.checkout("AAAAA"));
//        assertEquals(260, checkoutSolution.checkout("AAAAAA"));
//        assertEquals(160, checkoutSolution.checkout("AAAB"));
//        assertEquals(175, checkoutSolution.checkout("AAABB"));
//        assertEquals(190, checkoutSolution.checkout("AAABBD"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(-1, checkoutSolution.checkout("E"));
    }
}


