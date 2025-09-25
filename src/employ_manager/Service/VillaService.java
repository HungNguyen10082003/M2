package employ_manager.Service;

import employ_manager.Entity.VillaEntity;
import employ_manager.Repository.IFacilityRepository;
import java.util.List;

public class VillaService implements IFacilityService<VillaEntity> {
    private final IFacilityRepository<VillaEntity> repo;
    public VillaService(IFacilityRepository<VillaEntity> repo) { this.repo = repo; }

    @Override public List<VillaEntity> getAll() { return repo.findAll(); }

    @Override public void add(VillaEntity v) {
        if (!FacilityRule.codeVilla(v.getCode())) throw new IllegalArgumentException("Mã Villa phải dạng V-xxx");
        if (!FacilityRule.area(v.getArea())) throw new IllegalArgumentException("Diện tích >= 30");
        if (!FacilityRule.cost(v.getCost())) throw new IllegalArgumentException("Chi phí > 0");
        if (!FacilityRule.maxPeople(v.getMaxPeople())) throw new IllegalArgumentException("Số người 1-20");
        if (!FacilityRule.rental(v.getRental())) throw new IllegalArgumentException("Kiểu thuê: year|month|day|hour");
        if (repo.existsCode(v.getCode())) throw new IllegalArgumentException("Mã đã tồn tại");
        repo.add(v);
    }

    @Override public boolean removeByCode(String code) { return repo.deleteByCode(code); }
    @Override public boolean exists(String code) { return repo.existsCode(code); }
}
