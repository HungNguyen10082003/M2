package ss5;

import java.util.ArrayList;

public class ProductManager {
    private static ArrayList<Product> productList = new ArrayList<>();


    static {
        productList.add(new Product(1, "Áo thun", 150000));
        productList.add(new Product(2, "Quần jeans", 300000));
        productList.add(new Product(1, "Áo sơ mi", 200000)); // ID trùng để test
    }


    public void add(Product product) {
        for (Product p : productList) {
            if (p.getId() == product.getId()) {
                System.out.println(" ID sản phẩm đã tồn tại!");
                return;
            }
        }
        productList.add(product);
        System.out.println(" Thêm sản phẩm thành công!");
    }


    public void getAll() {
        if (productList.isEmpty()) {
            System.out.println(" Danh sách sản phẩm trống.");
        } else {
            System.out.println(" Danh sách sản phẩm:");
            for (Product p : productList) {
                System.out.println(p);
            }
        }
    }


    public void update(int id, String newName, double newPrice) {
        for (Product p : productList) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println(" Cập nhật thành công!");
                return;
            }
        }
        System.out.println(" Không tìm thấy sản phẩm với ID: " + id);
    }


    public void delete(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                productList.remove(p);
                System.out.println("🗑 Xóa thành công!");
                return;
            }
        }
        System.out.println(" Không tìm thấy sản phẩm với ID: " + id);
    }


    public void findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                System.out.println("🔍 Tìm thấy: " + p);
                return;
            }
        }
        System.out.println(" Không tìm thấy sản phẩm với ID: " + id);
    }
}
