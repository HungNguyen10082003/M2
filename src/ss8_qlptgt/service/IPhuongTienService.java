package ss8_qlptgt.service;

import ss8_qlptgt.entity.*;

import java.util.List;

public interface IPhuongTienService {
    List<HangSanXuat> getHangSanXuatList();
    HangSanXuat getHangByIndex(int idx);
    void upsertHang(HangSanXuat h);

    void themXeTai(XeTai x);
    void themOTo(OTo x);
    void themXeMay(XeMay x);

    List<XeTai> hienThiXeTai();
    List<OTo> hienThiOTo();
    List<XeMay> hienThiXeMay();

    boolean xoaTheoBks(String bks);
    List<PhuongTienEntity> timGanDungTheoBks(String keyword);

    void load() throws Exception;
    void save() throws Exception;
}
