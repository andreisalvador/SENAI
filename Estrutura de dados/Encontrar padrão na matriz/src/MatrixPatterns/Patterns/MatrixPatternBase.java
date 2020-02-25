package MatrixPatterns.Patterns;

import MatrixPatterns.Interfaces.IMatrixPattern;

import java.util.Arrays;

public abstract class MatrixPatternBase implements IMatrixPattern {

    private int linesLength;
    private int columnsLength;
    private byte[][] matrix;

    public MatrixPatternBase(int linesLength, int columnsLength) {
        this.linesLength = linesLength;
        this.columnsLength = columnsLength;
        this.matrix = CreateMatrixPattern(linesLength, columnsLength);
    }

    protected abstract byte[][] CreateMatrixPattern(int linesLength, int columnsLength);

    @Override
    public int getMatrixLinesLength() {
        return linesLength;
    }

    @Override
    public int getMatrixColumnsLength() {
        return columnsLength;
    }

    @Override
    public byte[][] GetMatrixPattern() {
        return matrix;
    }

    @Override
    public boolean equals(Object matrix) {
        byte[][] matrixToCompare = (byte[][]) matrix;

        for (int line = 0; line < linesLength; line++)
            if (!Arrays.equals(this.matrix[line], matrixToCompare[line]))
                return false;

        return true;
    }
}
