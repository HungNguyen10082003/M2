package ss5;
import java.util.Scanner;

public class RunProduct {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner sc = new Scanner(System.in);
        System.out.println(" Danh sách sản phẩm mặc định:");
        manager.getAll();

        while (true) {
            System.out.println("\n====== MENU QUẢN LÝ SẢN PHẨM ======");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm sản phẩm theo ID");
            System.out.println("0. Thoát");
            System.out.print("➡ Chọn chức năng: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = sc.nextDouble();
                    manager.add(new Product(id, name, price));
                    break;

                case 2:
                    manager.getAll();
                    break;

                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập tên mới: ");
                    String newName = sc.nextLine();
                    System.out.print("Nhập giá mới: ");
                    double newPrice = sc.nextDouble();
                    manager.update(updateId, newName, newPrice);
                    break;

                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    int deleteId = sc.nextInt();
                    manager.delete(deleteId);
                    break;

                case 5:
                    System.out.print("Nhập ID cần tìm: ");
                    int findId = sc.nextInt();
                    manager.findById(findId);
                    break;

                case 0:
                    System.out.println(" Thoát chương trình.");
                    sc.close();
                    return;

                default:
                    System.out.println(" Lựa chọn không hợp lệ!");

            }
        }
    }
}
