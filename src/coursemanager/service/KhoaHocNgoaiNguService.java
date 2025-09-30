package coursemanager.service;

import coursemanager.entity.KhoaHocNgoaiNguEntity;
import coursemanager.repository.IKhoaHocRepository;

import java.util.List;

public class KhoaHocNgoaiNguService implements IKhoaHocService<KhoaHocNgoaiNguEntity> {
    private final IKhoaHocRepository<KhoaHocNgoaiNguEntity> repo;
    public KhoaHocNgoaiNguService(IKhoaHocRepository<KhoaHocNgoaiNguEntity> repo) { this.repo = repo; }

    @Override public void add(KhoaHocNgoaiNguEntity t) {
        if (!KhoaHocRule.ma(t.getMa())) throw new IllegalArgumentException("Mã dạng AA-xxx");
        if (!KhoaHocRule.hocPhi(t.getHocPhi())) throw new IllegalArgumentException("Học phí >= 0");
        if (repo.existsMa(t.getMa())) throw new IllegalArgumentException("Mã đã tồn tại");
        repo.add(t);
    }
    @Override public List<KhoaHocNgoaiNguEntity> getAll() { return repo.findAll(); }
    @Override public boolean removeByMa(String ma) { return repo.deleteByMa(ma); }
    @Override public boolean existsMa(String ma) { return repo.existsMa(ma); }
    @Override public List<KhoaHocNgoaiNguEntity> searchByTenLike(String keyword) { return repo.searchByTenLike(keyword); }
}