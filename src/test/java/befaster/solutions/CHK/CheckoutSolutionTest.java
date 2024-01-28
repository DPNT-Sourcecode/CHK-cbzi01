package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {

    @Test
    void checkout() {
        CheckoutSolution checkoutSolution = new CheckoutSolution();
//        assertEquals(50, checkoutSolution.checkout("A"));
//        assertEquals(80, checkoutSolution.checkout("AB"));
//        assertEquals(115, checkoutSolution.checkout("CDBA"));
//        assertEquals(100, checkoutSolution.checkout("AA"));
//        assertEquals(130, checkoutSolution.checkout("AAA"));
        assertEquals(180, checkoutSolution.checkout("AAAA"));
        assertEquals(230, checkoutSolution.checkout("AAAAA"));
        assertEquals(260, checkoutSolution.checkout("AAAAAA"));
//        assertEquals(160, checkoutSolution.checkout("AAAB"));
//        assertEquals(175, checkoutSolution.checkout("AAABB"));
//        assertEquals(190, checkoutSolution.checkout("AAABBD"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(190, checkoutSolution.checkout("DABABA"));
//        assertEquals(-1, checkoutSolution.checkout("E"));
    }
}

