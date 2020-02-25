package MatrixPatterns.Patterns;

public class MatrixPatternSword extends MatrixPatternBase {
    public MatrixPatternSword() {
        super(4, 3);
    }

    @Override
    protected byte[][] CreateMatrixPattern(int linesLength, int columnsLength) {
        byte[][] matrix = { {0,1,0},{0,1,0},{1,1,1}, {0,1,0} };
        return matrix;
    }
}
