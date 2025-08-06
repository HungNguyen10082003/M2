import java.util.Scanner;

public class DeleteElement {
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

        System.out.print("Nhập giá trị cần xoá: ");
        int x = sc.nextInt();

        
        int index_del = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                index_del = i;
                break; 
            }
        }
    
        if (index_del == -1) {
            System.out.println("Không tìm thấy phần tử " + x + " trong mảng.");
        } else {
            
            for (int i = index_del; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            n--;

            System.out.println("Mảng sau khi xoá phần tử " + x + ":");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
