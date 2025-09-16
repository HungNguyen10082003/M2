package ss8_qlptgt.view;

import ss8_qlptgt.controller.PhuongTienController;
import ss8_qlptgt.repository.PhuongTienRepository;
import ss8_qlptgt.service.PhuongTienService;

public class Main {
    public static void main(String[] args) {
        PhuongTienRepository repo = new PhuongTienRepository();
        PhuongTienService service = new PhuongTienService(repo);
        ConsoleView view = new ConsoleView();
        try { service.load(); } catch (Exception ignored) {}
        new PhuongTienController(service, view).run();
        try { service.save(); } catch (Exception ignored) {}
    }
}
