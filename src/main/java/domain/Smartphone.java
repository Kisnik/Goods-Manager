package domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(String name, String manufacturer) {
        super(name);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
