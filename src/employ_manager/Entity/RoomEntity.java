package employ_manager.Entity;

public class RoomEntity extends FacilityEntity {
    private String freeService;

    public RoomEntity() {}
    public RoomEntity(String code, String name, double area, double cost, int maxPeople, String rental, String freeService) {
        super(code, name, area, cost, maxPeople, rental);
        this.freeService = freeService;
    }

    @Override public String toCsv() {
        return String.join(",", "ROOM", code, name, String.valueOf(area), String.valueOf(cost),
                String.valueOf(maxPeople), rental, freeService);
    }

    @Override public String toString() {
        return "RoomEntity{" +
                "code='" + code + '\'' + ", name='" + name + '\'' +
                ", area=" + area + ", cost=" + cost +
                ", maxPeople=" + maxPeople + ", rental='" + rental + '\'' +
                ", freeService='" + freeService + '\'' + '}';
    }
}
