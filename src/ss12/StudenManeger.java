package ss12;

import java.util.ArrayList;
import java.util.Scanner;

public class StudenManeger {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Thêm HS | 2. Hiển thị | 3. Tìm | 4. Xóa | 0. Thoát");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên HS: ");
                    students.add(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Danh sách HS:");
                    for (String s : students) System.out.println("- " + s);
                    break;
                case 3:
                    System.out.print("Nhập tên cần tìm: ");
                    String find = sc.nextLine();
                    if (students.contains(find)) System.out.println("Tìm thấy!");
                    else System.out.println("Không tìm thấy.");
                    break;
                case 4:
                    System.out.print("Nhập tên cần xóa: ");
                    students.remove(sc.nextLine());
                    break;
                case 0:
                    return;
            }
        }
    }
}

