package ss8_qlptgt.controller;

import ss8_qlptgt.entity.*;
import ss8_qlptgt.service.IPhuongTienService;
import ss8_qlptgt.view.ConsoleView;

import java.util.List;

public class PhuongTienController {
    private final IPhuongTienService service;
    private final ConsoleView view;

    public PhuongTienController(IPhuongTienService service, ConsoleView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        while (true) {
            int c = view.menuChinh();
            switch (c) {
                case 1: themMoi(); break;
                case 2: hienThi(); break;
                case 3: xoa(); break;
                case 4: timKiem(); break;
                case 5: themCapNhatHang(); break;
                case 6: System.out.println("Tạm biệt!"); return;
                default: System.out.println("Chọn 1-6!");
            }
        }
    }

    private void themMoi() {
        int c = view.menuThem();
        String bks = view.input("Biển kiểm soát");

        List<HangSanXuat> hangs = service.getHangSanXuatList();
        view.chonHang(hangs);
        int idx = view.readInt() - 1;
        HangSanXuat hang = service.getHangByIndex(idx);
        if (hang == null) {
            System.out.println("Chọn hãng không hợp lệ!"); return;
        }

        int nam = Integer.parseInt(view.input("Năm sản xuất"));
        String chu = view.input("Chủ sở hữu");

        try {
            switch (c) {
                case 1: {
                    System.out.print("Trọng tải (tấn): ");
                    double tt = view.readDouble();
                    service.themXeTai(new XeTai(bks, hang, nam, chu, tt));
                    service.save();
                    System.out.println("Đã thêm xe tải & lưu file!");
                    break;
                }
                case 2: {
                    int cho = Integer.parseInt(view.input("Số chỗ ngồi"));
                    String kieu = view.input("Kiểu xe (du lịch/xe khách/...)");
                    service.themOTo(new OTo(bks, hang, nam, chu, cho, kieu));
                    service.save();
                    System.out.println("Đã thêm ô tô & lưu file!");
                    break;
                }
                case 3: {
                    int cs = Integer.parseInt(view.input("Công suất (cc/HP)"));
                    service.themXeMay(new XeMay(bks, hang, nam, chu, cs));
                    service.save();
                    System.out.println("Đã thêm xe máy & lưu file!");
                    break;
                }
                default: System.out.println("Chọn 1-3!");
            }
        } catch (Exception e) {
            System.err.println("Lỗi lưu dữ liệu: " + e.getMessage());
        }
    }

    private void hienThi() {
        int c = view.menuHienThi();
        switch (c) {
            case 1: view.inDanhSach(service.hienThiXeTai()); break;
            case 2: view.inDanhSach(service.hienThiOTo()); break;
            case 3: view.inDanhSach(service.hienThiXeMay()); break;
            default: System.out.println("Chọn 1-3!");
        }
    }

    private void xoa() {
        String bks = view.input("Nhập BKS cần xoá");
        String confirm = view.input("Xác nhận xoá (Yes/No)");
        if (confirm.equalsIgnoreCase("Yes") || confirm.equalsIgnoreCase("Y")) {
            boolean ok = service.xoaTheoBks(bks);
            if (ok) {
                try {
                    service.save();
                    System.out.println("Đã xoá & lưu file!");
                } catch (Exception e) {
                    System.err.println("Lỗi lưu dữ liệu: " + e.getMessage());
                }
            } else System.out.println("Không tìm thấy BKS trong hệ thống.");
        } else {
            System.out.println("Đã huỷ xoá.");
        }
    }

    private void timKiem() {
        String kw = view.input("Nhập BKS cần tìm (gần đúng)");
        List<PhuongTienEntity> rs = service.timGanDungTheoBks(kw);
        if (rs.isEmpty()) System.out.println("Không có phương tiện nào được tìm thấy");
        else rs.forEach(System.out::println);
    }

    private void themCapNhatHang() {
        String ma = view.input("Mã hãng");
        String ten = view.input("Tên hãng");
        String qg  = view.input("Quốc gia");
        service.upsertHang(new HangSanXuat(ma, ten, qg));
        try {
            service.save();
            System.out.println("Đã thêm/cập nhật hãng & lưu file!");
        } catch (Exception e) {
            System.err.println("Lỗi lưu dữ liệu: " + e.getMessage());
        }
    }
}
