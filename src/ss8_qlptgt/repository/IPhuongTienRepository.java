package ss8_qlptgt.repository;

import ss8_qlptgt.entity.*;

import java.util.List;

public interface IPhuongTienRepository {
    List<HangSanXuat> getHangSanXuat();
    HangSanXuat findHangByIndex(int index);
    void upsertHang(HangSanXuat h); // thêm/cập nhật theo mã

    // Thêm
    void addXeTai(XeTai x);
    void addOTo(OTo x);
    void addXeMay(XeMay x);

    // Lấy danh sách
    List<XeTai> getXeTai();
    List<OTo> getOTo();
    List<XeMay> getXeMay();

    // Xoá
    boolean deleteByBks(String bks);

    // Tìm
    List<PhuongTienEntity> searchLikeBks(String keyword);

    // I/O
    void loadFromDisk() throws Exception;
    void saveToDisk() throws Exception;

}
