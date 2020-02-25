import MatrixPatterns.Interfaces.IMatrixPattern;
import java.util.*;

public class MatrixPatitioner {

    private final IMatrixPattern pattern;

    public MatrixPatitioner(IMatrixPattern pattern){
        this.pattern = pattern;
    }

    public List<byte[][]> GetPartitionedMatrixes(byte[][] matrix) {
        List<byte[][]> result = new ArrayList<byte[][]>();

        Queue<byte[][]> partitionedMatrixes = CreatePatitions(matrix);
        result.addAll(partitionedMatrixes);
        result.addAll(CreateEdges(partitionedMatrixes));

        return result;
    }

    private Queue<byte[][]> CreatePatitions(byte[][] matrix) {
        Queue<byte[][]> partitionedMatrixes = new LinkedList<>();

        int columnsLength = matrix[0].length;
        int lastIndexFirstPartition = (int) Math.round(columnsLength / 2.0d) - 1;
        int lastIndexSecondPartition = columnsLength - 1;

        if (columnsLength > (pattern.getMatrixColumnsLength() * 2) && matrix.length >= pattern.getMatrixLinesLength()) {

            byte[][] firstPartition = ExtractMatrix(matrix, 0, lastIndexFirstPartition);
            byte[][] secondPartition = ExtractMatrix(matrix, lastIndexFirstPartition + 1, lastIndexSecondPartition);

            partitionedMatrixes.addAll(CreatePatitions(firstPartition));
            partitionedMatrixes.addAll(CreatePatitions(secondPartition));
        } else
            partitionedMatrixes.add(matrix);

        return partitionedMatrixes;
    }

    private List<byte[][]> CreateEdges(Queue<byte[][]> patitionedMatrixes) {
        List<byte[][]> matrixEdges = new ArrayList<byte[][]>();
        byte[][] patitionLeft;
        byte[][] patitionRight;

        while ((patitionLeft = patitionedMatrixes.poll()) != null && (patitionRight = patitionedMatrixes.peek()) != null) {
            byte[][] edgeMatrixLeft = new byte[patitionLeft.length][pattern.getMatrixColumnsLength()];
            byte[][] edgeMatrixRight = new byte[patitionLeft.length][pattern.getMatrixColumnsLength()];

            FillEdgeMatrix(edgeMatrixLeft, patitionLeft, patitionRight, 0); // left to right
            FillEdgeMatrix(edgeMatrixRight, patitionLeft, patitionRight, patitionLeft[0].length - 1); // right to left

            matrixEdges.add(edgeMatrixLeft);
            matrixEdges.add(edgeMatrixRight);
        }

        return matrixEdges;
    }

    private void FillEdgeMatrix(byte[][] edgeMatrix, byte[][] partitionLeft, byte[][] partitionRight, int fixedIndex) {

        boolean leftToRight = fixedIndex == 0;
        int columnsLength = leftToRight ? partitionLeft[0].length : (pattern.getMatrixColumnsLength() - 1);
        int startColumnIndex = leftToRight ? columnsLength - (pattern.getMatrixColumnsLength() - 1) : 0;
        int edgeMatrixFixedIndex = leftToRight ? pattern.getMatrixColumnsLength() - 1 : 0;

        for (int line = 0; line < partitionLeft.length; line++) {
            int indexColumnEdgeMatrix = leftToRight ? 0 : 1;
            for (int column = startColumnIndex; column < columnsLength; column++) {
                edgeMatrix[line][indexColumnEdgeMatrix++] = leftToRight ? partitionLeft[line][column] : partitionRight[line][column];
            }
            edgeMatrix[line][edgeMatrixFixedIndex] = !leftToRight ? partitionLeft[line][fixedIndex] : partitionRight[line][fixedIndex];
        }
    }

    private byte[][] ExtractMatrix(byte[][] matrix, int fromIndex, int toIndex) {

        int columnLength = toIndex - fromIndex + 1;

        byte[][] extractedMatrix = new byte[matrix.length][columnLength];

        for (int line = 0; line < matrix.length; line++) {
            int indexExtractedMatrix = 0;

            for (int column = fromIndex; column <= toIndex; column++) {
                extractedMatrix[line][indexExtractedMatrix++] = matrix[line][column];
            }
        }

        return extractedMatrix;
    }
}
