package employ_manager.Entity;

public class VillaEntity extends FacilityEntity {
    private String roomStandard;
    private double poolArea;
    private int floors;

    public VillaEntity() {}
    public VillaEntity(String code, String name, double area, double cost, int maxPeople, String rental,
                       String roomStandard, double poolArea, int floors) {
        super(code, name, area, cost, maxPeople, rental);
        this.roomStandard = roomStandard; this.poolArea = poolArea; this.floors = floors;
    }

    @Override public String toCsv() {
        return String.join(",", "VILLA", code, name, String.valueOf(area), String.valueOf(cost),
                String.valueOf(maxPeople), rental, roomStandard, String.valueOf(poolArea), String.valueOf(floors));
    }

    @Override public String toString() {
        return "VillaEntity{" +
                "code='" + code + '\'' + ", name='" + name + '\'' +
                ", area=" + area + ", cost=" + cost +
                ", maxPeople=" + maxPeople + ", rental='" + rental + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors + '}';
    }
}
