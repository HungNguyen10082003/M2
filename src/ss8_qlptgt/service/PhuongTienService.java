package ss8_qlptgt.service;

import ss8_qlptgt.entity.*;
import ss8_qlptgt.repository.PhuongTienRepository;

import java.util.List;

public class PhuongTienService implements IPhuongTienService {
    private final PhuongTienRepository repo;

    public PhuongTienService(PhuongTienRepository repo) {
        this.repo = repo;
    }

    @Override public List<HangSanXuat> getHangSanXuatList() { return repo.getHangSanXuat(); }
    @Override public HangSanXuat getHangByIndex(int idx) { return repo.findHangByIndex(idx); }
    @Override public void upsertHang(HangSanXuat h) { repo.upsertHang(h); }

    @Override public void themXeTai(XeTai x) { repo.addXeTai(x); }
    @Override public void themOTo(OTo x) { repo.addOTo(x); }
    @Override public void themXeMay(XeMay x) { repo.addXeMay(x); }

    @Override public List<XeTai> hienThiXeTai() { return repo.getXeTai(); }
    @Override public List<OTo> hienThiOTo() { return repo.getOTo(); }
    @Override public List<XeMay> hienThiXeMay() { return repo.getXeMay(); }

    @Override public boolean xoaTheoBks(String bks) { return repo.deleteByBks(bks); }
    @Override public List<PhuongTienEntity> timGanDungTheoBks(String keyword) { return repo.searchLikeBks(keyword); }

    @Override public void load() throws Exception { repo.loadFromDisk(); }
    @Override public void save() throws Exception { repo.saveToDisk(); }
}
