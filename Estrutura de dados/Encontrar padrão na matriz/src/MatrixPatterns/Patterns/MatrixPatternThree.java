package MatrixPatterns.Patterns;

public class MatrixPatternThree extends MatrixPatternBase  {

    public MatrixPatternThree() {
        super(3,3);
    }

    @Override
    protected byte[][] CreateMatrixPattern(int linesLength, int columnsLength) {
        byte[][] matrix = { {0,0,1},{0,1,0},{1,0,0} };
        return matrix;
    }
}
