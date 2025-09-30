package library.service;

import library.entity.SachEntity;
import library.repository.ITaiLieuRepository;

import java.util.List;

public class SachService implements ITaiLieuService<SachEntity> {
    private final ITaiLieuRepository<SachEntity> repo;
    public SachService(ITaiLieuRepository<SachEntity> repo) { this.repo = repo; }

    @Override public void add(SachEntity s) {
        if (!TaiLieuRule.ma(s.getMa())) throw new IllegalArgumentException("Mã dạng SA-xxx");
        if (!TaiLieuRule.nam(s.getNam())) throw new IllegalArgumentException("Năm 1800..2100");
        if (!TaiLieuRule.soDuong(s.getSoTrang())) throw new IllegalArgumentException("Số trang > 0");
        if (repo.existsMa(s.getMa())) throw new IllegalArgumentException("Mã đã tồn tại");
        repo.add(s);
    }
    @Override public List<SachEntity> getAll() { return repo.findAll(); }
    @Override public boolean removeByMa(String ma) { return repo.deleteByMa(ma); }
    @Override public boolean existsMa(String ma) { return repo.existsMa(ma); }
    @Override public List<SachEntity> searchByTenLike(String keyword) { return repo.searchByTenLike(keyword); }
}
