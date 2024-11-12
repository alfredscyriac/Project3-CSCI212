public class Dishwasher extends Appliance {
    private boolean undercounterInstallation;
    private double price;

    public Dishwasher(String serialNumber, double price, boolean undercounterInstallation) {
        super(serialNumber);
        this.price = price;
        this.undercounterInstallation = undercounterInstallation;
    }

    @Override
    public String toString() {
        return "Serial=" + getSerialNumber() + ". Price=$" + price + 
               ", Undercounter Installation=" + (undercounterInstallation ? "Yes" : "No") + ".";
    }
}
