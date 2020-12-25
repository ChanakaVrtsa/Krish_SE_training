public abstract class SmartPhone implements Cloneable {

    private String manufacturer;
    private String operatingSystem;

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    //creates a clone of SmartPhone sub class by invoking clone method of cloneable interface
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}
