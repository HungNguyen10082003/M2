package employ_manager.Controller;

import java.util.Scanner;

public class EmployManagerController {
    private final Scanner sc = new Scanner(System.in);
    private final VillaController villaController = new VillaController();
    private final HouseController houseController = new HouseController();
    private final RoomController roomController = new RoomController();
    private final EmployController employController = new EmployController();
    public void mainMenu() {
        while (true) {
            System.out.println("\n===== EMPLOY MANAGER =====");
            System.out.println("1. Quản lý Villa");
            System.out.println("2. Quản lý House");
            System.out.println("3. Quản lý Room");
            System.out.println("4. Quản lý Nhân viên"); // <= thêm
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            String c = sc.nextLine();
            switch (c) {
                case "1": villaController.menuVilla(); break;
                case "2": houseController.menuHouse(); break;
                case "3": roomController.menuRoom(); break;
                case "4": employController.menuEmployee(); ; break;
                case "0": System.out.println("Tạm biệt!"); return;
                default: System.out.println(">> Sai lựa chọn!");
            }
        }
    }
        }


