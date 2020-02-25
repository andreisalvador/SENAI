import MatrixPatterns.Factories.MatrixPatternFactory;

public class Main {

    public static void main(String[] args) {

        try {
            String fileLocation = "src/matrixToFindPattern.txt";//args[0];
            int patternIndex = 1;//Integer.parseInt(args[1]);

            MatrixFileReader reader = new MatrixFileReader();
            byte[][] matrix = reader.GetMatrix(fileLocation);

            MatrixPatternFinder patternFinder = new MatrixPatternFinder(MatrixPatternFactory.Create(patternIndex));
            MatrixPatternFinderLoggerCollector logger = patternFinder.FindPatternInMatrix(matrix);

            System.out.print(logger.toString());
        } catch (Exception except) {
            System.err.print(except.getMessage());
        }
    }
}
