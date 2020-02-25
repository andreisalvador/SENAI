import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixFileReader {

    public byte[][] GetMatrix(String fileLocation) throws Exception {
        return CreateMatriz(ReadMatrixFromFile(fileLocation));
    }

    private void ValidateMatrixFileLine(String fileLine, List<char[]> lines) throws Exception {
        char[] lineData = fileLine.toCharArray();

        if (!lines.isEmpty()) {
            char[] firstLine = lines.get(0);

            if (lineData.length != firstLine.length)
                throw new Exception("A linha '" + fileLine + "' está fora dos padrões da matriz.");
        }

        for (char data : lineData) {
            if (!(data == '0' || data == '1')) {
                throw new Exception("Apenas são permitidos os valores '0' e '1'.");
            }
        }
    }

    private byte[][] CreateMatriz(List<char[]> lines) throws Exception {

        if(lines.isEmpty())
            throw new Exception("Não é possível criar a matriz pois a lista de retorno do arquivo esta vazia.");

        int matrixLinesLength = lines.size();
        int matrixColumnsLength = lines.get(0).length;

        byte[][] matrix = new byte[matrixLinesLength][matrixColumnsLength];

        for (int line = 0; line < matrixLinesLength; line++) {

            char[] currentLine = lines.get(line);

            for (int column = 0; column < matrixColumnsLength; column++) {
                matrix[line][column] = Byte.valueOf(String.valueOf(currentLine[column]));
            }
        }
        return matrix;
    }

    private List<char[]> ReadMatrixFromFile(String fileLocation) {
        try {

            String line = "";

            BufferedReader buffer = new BufferedReader(new FileReader(fileLocation));

            ArrayList<char[]> linesData = new ArrayList<char[]>();

            while ((line = buffer.readLine()) != null) {

                ValidateMatrixFileLine(line, linesData);

                linesData.add(line.toCharArray());
            }

            return linesData;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}