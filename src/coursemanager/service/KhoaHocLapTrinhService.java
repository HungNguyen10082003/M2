package coursemanager.service;

import coursemanager.entity.KhoaHocLapTrinhEntity;
import coursemanager.repository.IKhoaHocRepository;

import java.util.List;

public class KhoaHocLapTrinhService implements IKhoaHocService<KhoaHocLapTrinhEntity> {
    private final IKhoaHocRepository<KhoaHocLapTrinhEntity> repo;
    public KhoaHocLapTrinhService(IKhoaHocRepository<KhoaHocLapTrinhEntity> repo) { this.repo = repo; }

    @Override public void add(KhoaHocLapTrinhEntity t) {
        if (!KhoaHocRule.ma(t.getMa())) throw new IllegalArgumentException("Mã dạng AA-xxx");
        if (!KhoaHocRule.hocPhi(t.getHocPhi())) throw new IllegalArgumentException("Học phí >= 0");
        if (repo.existsMa(t.getMa())) throw new IllegalArgumentException("Mã đã tồn tại");
        repo.add(t);
    }
    @Override public List<KhoaHocLapTrinhEntity> getAll() { return repo.findAll(); }
    @Override public boolean removeByMa(String ma) { return repo.deleteByMa(ma); }
    @Override public boolean existsMa(String ma) { return repo.existsMa(ma); }
    @Override public List<KhoaHocLapTrinhEntity> searchByTenLike(String keyword) { return repo.searchByTenLike(keyword); }
}