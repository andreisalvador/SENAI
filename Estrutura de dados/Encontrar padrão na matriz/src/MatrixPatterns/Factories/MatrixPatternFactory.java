package MatrixPatterns.Factories;

import MatrixPatterns.Interfaces.IMatrixPattern;
import MatrixPatterns.Patterns.*;

public class MatrixPatternFactory {
    public static IMatrixPattern Create(int patternIndex){

        IMatrixPattern pattern = null;

        switch (patternIndex){
            case 1:
            default:
                pattern = new MatrixPatternOne();
                break;
            case 2:
                pattern = new MatrixPatternTwo();
                break;
            case 3:
                pattern = new MatrixPatternThree();
                break;
            case 4:
                pattern = new MatrixPatternSword();
                break;
        }
        return pattern;
    }
}
