package employ_manager.Service;

import employ_manager.Entity.HouseEntity;
import employ_manager.Repository.IFacilityRepository;
import java.util.List;

public class HouseService implements IFacilityService<HouseEntity> {
    private final IFacilityRepository<HouseEntity> repo;
    public HouseService(IFacilityRepository<HouseEntity> repo) { this.repo = repo; }

    @Override public List<HouseEntity> getAll() { return repo.findAll(); }

    @Override public void add(HouseEntity h) {
        if (!FacilityRule.codeHouse(h.getCode())) throw new IllegalArgumentException("Mã House phải dạng H-xxx");
        if (!FacilityRule.area(h.getArea())) throw new IllegalArgumentException("Diện tích >= 30");
        if (!FacilityRule.cost(h.getCost())) throw new IllegalArgumentException("Chi phí > 0");
        if (!FacilityRule.maxPeople(h.getMaxPeople())) throw new IllegalArgumentException("Số người 1-20");
        if (!FacilityRule.rental(h.getRental())) throw new IllegalArgumentException("Kiểu thuê theo ngày");
        if (repo.existsCode(h.getCode())) throw new IllegalArgumentException("Mã đã tồn tại");
        repo.add(h);
    }

    @Override public boolean removeByCode(String code) { return repo.deleteByCode(code); }
    @Override public boolean exists(String code) { return repo.existsCode(code); }
}
