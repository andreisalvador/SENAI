import MatrixPatterns.Interfaces.IMatrixPattern;

import java.util.ArrayList;
import java.util.List;

public class MatrixPatternFinderLoggerCollector {
    private int quantityOfPatternsFound = 0;
    private List<byte[][]> matrixesWithPatternFound;
    private IMatrixPattern pattern;

    public MatrixPatternFinderLoggerCollector(IMatrixPattern pattern) {
        this.matrixesWithPatternFound = new ArrayList<byte[][]>();
        this.pattern = pattern;
    }

    public int getQuantityOfPatternsFound() {
        return quantityOfPatternsFound;
    }

    public void IncrementPatternFound() {
        quantityOfPatternsFound++;
    }

    public void AddMatrixWithPatternFound(byte[][] matrixWithPattern) {
        if (!matrixesWithPatternFound.contains(matrixWithPattern))
            this.matrixesWithPatternFound.add(matrixWithPattern);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("O padrão abaixo foi encontrado " + this.quantityOfPatternsFound + " vez(es). \r\n");

        for (int i = 0; i < pattern.getMatrixLinesLength(); i++) {
            for (int j = 0; j < pattern.getMatrixColumnsLength(); j++) {
                stringBuilder.append(pattern.GetMatrixPattern()[i][j]);
            }
            stringBuilder.append("\r\n");
        }

        return stringBuilder.toString();
    }
}