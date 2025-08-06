package ss3;

import java.util.Scanner;

public class MaxArrays{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Nhập số dòng: ");
        int m = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int n = sc.nextInt();

        int[][] arr = new int[m][n];


        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("arr[" + i + "][" + j + "] = ");
                arr[i][j] = sc.nextInt();
            }
        }

        // Tìm phần tử lớn nhất và vị trí của nó
        int max = arr[0][0];
        int row = 0, col = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        // In kết quả
        System.out.println("Phần tử lớn nhất là: " + max);
        System.out.println("Vị trí: dòng " + row + ", cột " + col);
    }
}

