package ss10;
import java.util.Scanner;
import java.util.Stack;

public class ThapPhanSangNhiPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên hệ thập phân: ");
        int n = sc.nextInt();


        String nhiPhan = doiSangNhiPhan(n);

        System.out.println("Số nhị phân tương ứng: " + nhiPhan);
    }

    public static String doiSangNhiPhan(int n) {
        if (n == 0) return "0";

        Stack<Integer> stack = new Stack<>();


        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }


        StringBuilder nhiPhan = new StringBuilder();
        while (!stack.isEmpty()) {
            nhiPhan.append(stack.pop());
        }

        return nhiPhan.toString();
    }
}
