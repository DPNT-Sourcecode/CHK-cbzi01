package befaster.solutions.SUM;

@SuppressWarnings("unused")
public class SumSolution {

    public int compute(int x, int y) {
        if (!validateNumberRangeBetweenZeroAndOneHundred(x) && !validateNumberRangeBetweenZeroAndOneHundred(y)) {
            throw new IllegalArgumentException("Invalid number range");
        }
        return x + y;
    }

    private boolean validateNumberRangeBetweenZeroAndOneHundred(int number) {
        return number >= 0 && number <= 100;
    }

}
