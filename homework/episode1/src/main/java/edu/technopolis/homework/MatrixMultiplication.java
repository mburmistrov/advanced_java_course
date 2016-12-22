package edu.technopolis.homework;

import java.util.Scanner;

/**
 * Created by mmb on 22.12.16.
 */
class MatrixMultiplication
{
    public static void main(String args[])
    {
        int m, n, p, q, i, j;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество строк и столбцов первой матрицы");

        try {
            m = in.nextInt();
            n = in.nextInt();
        }catch(java.util.InputMismatchException ex){
            System.out.println("Ошибка ввода");
            return;
        }

        if(m <= 0 || n <= 0){
            System.out.println("Размерности должны быть положительными, окончание работы");
            return;
        }

        double matrixA[][] = new double[m][n];

        System.out.println("Введите элементы первой матрицы (заполнение происходит построчно)");

        for (i = 0; i < m; i++){
            for (j = 0; j < n; j++) {
                try {
                    matrixA[i][j] = in.nextDouble();
                }catch(java.util.InputMismatchException ex){
                    System.out.println("Ошибка ввода, окончание работы");
                    return;
                }
            }
        }

        System.out.println("Введите количество строк и столбцов второй матрицы (заполнение происходит построчно)");
        try {
            p = in.nextInt();
            q = in.nextInt();
        }catch(java.util.InputMismatchException ex){
            System.out.println("Ошибка ввода, окончание работы");
            return;
        }

        if(p <= 0 || q <= 0){
            System.out.println("Размерности должны быть положительными, окончание работы");
            return;
        }

        if (n != p) {
            System.out.println("Кол-во столбцов 1-ой матрицы должно совпадать с кол-вом строк 2-ой матрицы, окончание работы");
            return;
        }

        double matrixB[][] = new double[p][q];

        System.out.println("Введите элементы второй матрицы");

        for (i = 0; i < p; i++) {
            for (j = 0; j < q; j++) {
                try {
                    matrixB[i][j] = in.nextDouble();
                }catch(java.util.InputMismatchException ex){
                    System.out.println("Ошибка ввода, окончание работы");
                    return;
                }
            }
        }

        System.out.println("Результат");

        double matrixResult[][] = performMatrixMultiplication(matrixA, matrixB);

        for (i = 0; i < m; i++ ) {
            for (j = 0; j < q; j++) {
                System.out.print(matrixResult[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    public static double[][] performMatrixMultiplication(double[][] matrixA, double[][] matrixB){
        double[][] res = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int r = 0; r < matrixA[0].length; r++) {
                    res[i][j] += matrixA[i][r] * matrixB[r][j];
                }
            }
        }
        return res;
    }
}