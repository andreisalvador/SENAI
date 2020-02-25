import MatrixPatterns.Interfaces.IMatrixPattern;
import javafx.animation.ParallelTransition;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class MatrixPatternFinder {
    private IMatrixPattern pattern;

    public MatrixPatternFinder(IMatrixPattern pattern) {
        this.pattern = pattern;
    }

    public MatrixPatternFinderLoggerCollector FindPatternInMatrix(byte[][] matrix) {

        List<byte[][]> partitionedMatrixes = new MatrixPatitioner(pattern).GetPartitionedMatrixes(matrix);

        MatrixPatternFinderLoggerCollector loggerCollector = new MatrixPatternFinderLoggerCollector(pattern);

        partitionedMatrixes.parallelStream().forEach(partitionedMatrix -> FindPatterns(partitionedMatrix, loggerCollector));

        return loggerCollector;
    }

    private void FindPatterns(byte[][] matrix, MatrixPatternFinderLoggerCollector loggerCollector) {
        byte currentLineOrColumn = 1;
        int incrementToVerifyMatrixLinesEnd = pattern.getMatrixLinesLength() - currentLineOrColumn;
        int lastLineIndex = 0;
        int linesLength = pattern.getMatrixLinesLength();
        int lastColumnIndex = 0;
        int columnsLength = pattern.getMatrixColumnsLength();

        while (lastLineIndex + incrementToVerifyMatrixLinesEnd < matrix.length) {

            byte[][] matrixToVerifyPattern = new byte[pattern.getMatrixLinesLength()][pattern.getMatrixColumnsLength()];

            int matrixToVerifyLineIndex = 0;

            for (int line = lastLineIndex; line < linesLength; line++) {

                int matrixToVerifyColumnIndex = 0;

                for (int column = lastColumnIndex; column < columnsLength; column++)
                    matrixToVerifyPattern[matrixToVerifyLineIndex][matrixToVerifyColumnIndex++] = matrix[line][column];

                matrixToVerifyLineIndex++;
            }

            ValidateMatrix(matrixToVerifyPattern, loggerCollector, matrix);

            if (columnsLength >= matrix[0].length) {
                lastLineIndex++;
                linesLength = lastLineIndex + pattern.getMatrixLinesLength();

                lastColumnIndex = 0;
            } else
                lastColumnIndex++;

            columnsLength = lastColumnIndex + pattern.getMatrixColumnsLength();
        }
    }

    private void ValidateMatrix(byte[][] matrix, MatrixPatternFinderLoggerCollector loggerCollector, byte[][] matrixParent) {
        if (pattern.equals(matrix)) {
            loggerCollector.IncrementPatternFound();
            loggerCollector.AddMatrixWithPatternFound(matrixParent);
        }
    }
}
