package employ_manager.Entity;

public abstract class FacilityEntity {
    protected String code;
    protected String name;
    protected double area;
    protected double cost;
    protected int maxPeople;
    protected String rental;

    public FacilityEntity() {}
    public FacilityEntity(String code, String name, double area, double cost, int maxPeople, String rental) {
        this.code = code; this.name = name; this.area = area; this.cost = cost; this.maxPeople = maxPeople; this.rental = rental;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getArea() { return area; }
    public double getCost() { return cost; }
    public int getMaxPeople() { return maxPeople; }
    public String getRental() { return rental; }

    public abstract String toCsv();
}
