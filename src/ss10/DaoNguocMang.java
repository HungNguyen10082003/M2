package ss10;

import java.util.Stack;

public class DaoNguocMang {
    public static void main(String[] args) {
        int[] mang = {1, 2, 3, 4, 5};

        System.out.println("Mảng ban đầu:");
        inMang(mang);


        Stack<Integer> stack = new Stack<>();

        for (int so : mang) {
            stack.push(so);
        }

        for (int i = 0; i < mang.length; i++) {
            mang[i] = stack.pop(); // Stack là cấu trúc LIFO
        }

        System.out.println("Mảng sau khi đảo ngược:");
        inMang(mang);
    }

    public static void inMang(int[] arr) {
        for (int so : arr) {
            System.out.print(so + " ");
        }
        System.out.println();
    }
}

