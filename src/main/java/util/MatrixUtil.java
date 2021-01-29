package util;

public class MatrixUtil {
    public static int[][] addMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length && firstMatrix[0].length != secondMatrix[0].length) {
            throw new IllegalArgumentException("Matrices must be same of value");
        }

        final int[][] matrix = new int[firstMatrix.length][secondMatrix[0].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                matrix[i][j] =  firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        return matrix;
    }

    public static int[][] subtractMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length && firstMatrix[0].length != secondMatrix[0].length) {
            throw new IllegalArgumentException("Matrices must be same of value");
        }

        final int[][] matrix = new int[firstMatrix.length][secondMatrix[0].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                matrix[i][j] =  firstMatrix[i][j] - secondMatrix[i][j];
            }
        }

        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix[0].length != secondMatrix.length) {
            throw new IllegalArgumentException("Cols and Rows of the matrices must be same of value");
        }

        final int column = secondMatrix[0].length;
        final int row =  firstMatrix.length;

        final int[][] matrix = new int[row][column];

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                int temp = 0;

                for (int k = 0; k < firstMatrix[0].length; k++) {
                    temp += firstMatrix[j][k] * secondMatrix[k][i];
                }

                matrix[j][i] =  temp;
            }
        }

        return matrix;
    }

    public static int[][] inverseMatrix(int[][] matrix) {
        int[][] tempMatrix = new int[matrix.length][matrix[0].length];

        int[][] identityMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            identityMatrix[i][i] = 1;
        }

        System.out.println(toString(identityMatrix));


        return tempMatrix;
    }

    public static String toString(int[][] matrix) {
        final StringBuilder string = new StringBuilder();

        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                string.append(anAMatrix).append("\t");
            }
            string.append("\n");
        }

        return string.toString();
    }
}
