package employ_manager.Service;


import employ_manager.Entity.RoomEntity;
import employ_manager.Repository.IFacilityRepository;

import java.util.List;

public class RoomService implements IFacilityService<RoomEntity> {
    private final IFacilityRepository<RoomEntity> repo;
    public RoomService(IFacilityRepository<RoomEntity> repo) { this.repo = repo; }

    @Override public List<RoomEntity> getAll() { return repo.findAll(); }

    @Override public void add(RoomEntity r) {
        if (!FacilityRule.codeRoom(r.getCode())) throw new IllegalArgumentException("Mã Room phải dạng R-xxx");
        if (!FacilityRule.area(r.getArea())) throw new IllegalArgumentException("Diện tích >= 30");
        if (!FacilityRule.cost(r.getCost())) throw new IllegalArgumentException("Chi phí > 0");
        if (!FacilityRule.maxPeople(r.getMaxPeople())) throw new IllegalArgumentException("Số người 1-20");
        if (!FacilityRule.rental(r.getRental())) throw new IllegalArgumentException("Kiểu thuê: year|month|day|hour");
        if (repo.existsCode(r.getCode())) throw new IllegalArgumentException("Mã đã tồn tại");
        repo.add(r);
    }

    @Override public boolean removeByCode(String code) { return repo.deleteByCode(code); }
    @Override public boolean exists(String code) { return repo.existsCode(code); }
}