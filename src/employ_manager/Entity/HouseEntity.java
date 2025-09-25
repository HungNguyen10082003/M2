package employ_manager.Entity;

public class HouseEntity extends FacilityEntity {
    private String roomStandard;
    private int floors;

    public HouseEntity() {}
    public HouseEntity(String code, String name, double area, double cost, int maxPeople, String rental,
                       String roomStandard, int floors) {
        super(code, name, area, cost, maxPeople, rental);
        this.roomStandard = roomStandard; this.floors = floors;
    }

    @Override public String toCsv() {
        return String.join(",", "HOUSE", code, name, String.valueOf(area), String.valueOf(cost),
                String.valueOf(maxPeople), rental, roomStandard, String.valueOf(floors));
    }

    @Override public String toString() {
        return "HouseEntity{" +
                "code='" + code + '\'' + ", name='" + name + '\'' +
                ", area=" + area + ", cost=" + cost +
                ", maxPeople=" + maxPeople + ", rental='" + rental + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", floors=" + floors + '}';
    }
}
