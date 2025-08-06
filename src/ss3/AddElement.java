package ss3;
import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];


        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }


        System.out.print("Nhập phần tử mới cần thêm: ");
        int newValue = sc.nextInt();


        int[] newArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }

        newArr[n] = newValue;
        System.out.println("Mảng sau khi thêm phần tử:");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
}
