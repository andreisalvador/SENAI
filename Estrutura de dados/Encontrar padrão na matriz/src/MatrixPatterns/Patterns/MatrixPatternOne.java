package MatrixPatterns.Patterns;

public class MatrixPatternOne extends MatrixPatternBase {
    public MatrixPatternOne() {
        super(3, 3);
    }

    @Override
    protected byte[][] CreateMatrixPattern(int linesLength, int columnsLength) {
        byte[][] matrix = { {0,1,0},{1,1,1},{0,1,0} };
        return matrix;
    }
}
