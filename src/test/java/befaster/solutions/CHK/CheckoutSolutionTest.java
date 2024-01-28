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
//        assertEquals(80, checkoutSolution.checkout("AB"));
//        assertEquals(115, checkoutSolution.checkout("CDBA"));
//        assertEquals(100, checkoutSolution.checkout("AA"));
//        assertEquals(130, checkoutSolution.checkout("AAA"));
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
    void testIfWhenCheckoutWithTwoDifferentItensItgetsTheCorrectValue() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
        int result = checkoutSolution.checkout("AB");
        int expectedResult = 80;

        assertEquals(expectedResult, result);
//        assertEquals(115, checkoutSolution.checkout("CDBA"));
//        assertEquals(100, checkoutSolution.checkout("AA"));
//        assertEquals(130, checkoutSolution.checkout("AAA"));
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

