package library.service;

import library.entity.TapChiEntity;
import library.repository.ITaiLieuRepository;

import java.util.List;

public class TapChiService implements ITaiLieuService<TapChiEntity> {
    private final ITaiLieuRepository<TapChiEntity> repo;
    public TapChiService(ITaiLieuRepository<TapChiEntity> repo) { this.repo = repo; }

    @Override public void add(TapChiEntity t) {
        if (!TaiLieuRule.ma(t.getMa())) throw new IllegalArgumentException("Mã dạng TC-xxx");
        if (!TaiLieuRule.nam(t.getNam())) throw new IllegalArgumentException("Năm 1800..2100");
        if (!TaiLieuRule.soDuong(t.getSoPhatHanh())) throw new IllegalArgumentException("Số phát hành > 0");
        if (!TaiLieuRule.thang(t.getThangPhatHanh())) throw new IllegalArgumentException("Tháng 1..12");
        if (repo.existsMa(t.getMa())) throw new IllegalArgumentException("Mã đã tồn tại");
        repo.add(t);
    }
    @Override public List<TapChiEntity> getAll() { return repo.findAll(); }
    @Override public boolean removeByMa(String ma) { return repo.deleteByMa(ma); }
    @Override public boolean existsMa(String ma) { return repo.existsMa(ma); }
    @Override public List<TapChiEntity> searchByTenLike(String keyword) { return repo.searchByTenLike(keyword); }
}