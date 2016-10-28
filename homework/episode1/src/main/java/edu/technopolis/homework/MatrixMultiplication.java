package edu.technopolis.homework;
import java.util.Scanner;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int X = in.nextInt();
        int Y = in.nextInt();
        
        if (!(M != X || N == 0 || M == 0 || X == 0 || Y == 0)) {
            double[][] matrixA = new double[N][M];
            double[][] matrixB = new double[X][Y];
            double[][] matrixResult;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrixA[i][j] = in.nextDouble();
                }
            }
            for (int i = 0; i < X; i++) {
                for (int j = 0; j < Y; j++) {
                    matrixB[i][j] = in.nextDouble();
                }
            }

            matrixResult = performMatrixMultiplication(matrixA, matrixB);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < Y; j++) {
                    System.out.print(matrixResult[i][j] + "  ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Некорректные матрицы. Кол-во столбцов 1-ой матрицы должно сопвпадать с кол-вом строк 2-ой матрицы, размерности не должны содержать нули.");
        }
        return;
    }
    
    public static double[][] performMatrixMultiplication(double[][] matrixA, double[][] matrixB){
        double[][] res = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                for (int r = 0; r < matrixA[0].length; r++) {
                    res[i][j] += matrixB[i][r] * matrixB[r][j];
                }
            }
        }
        return res;
    }

    
}