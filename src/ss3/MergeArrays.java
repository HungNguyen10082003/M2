package ss3;

import java.util.Scanner;

public class MergeArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử mảng thứ 1: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Nhập các phần tử của mảng 1:");
        for (int i = 0; i < n1; i++) {
            System.out.print("arr1[" + i + "] = ");
            arr1[i] = sc.nextInt();
        }


        System.out.print("Nhập số phần tử mảng thứ 2: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Nhập các phần tử của mảng 2:");
        for (int i = 0; i < n2; i++) {
            System.out.print("arr2[" + i + "] = ");
            arr2[i] = sc.nextInt();
        }

        int[] merged = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            merged[i] = arr1[i];
        }
        for (int i = 0; i < n2; i++) {
            merged[n1 + i] = arr2[i];
        }


        System.out.println("Mảng sau khi gộp:");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }
    }
}
