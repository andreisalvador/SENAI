package MatrixPatterns.Patterns;

public class MatrixPatternTwo extends MatrixPatternBase  {

    public MatrixPatternTwo() {
        super(3, 3);
    }

    @Override
    protected byte[][] CreateMatrixPattern(int linesLength, int columnsLength) {
        byte[][] matrix = { {1,1,1},{0,1,0},{0,1,0} };
        return matrix;
    }
}
