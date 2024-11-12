public class Microwave extends Appliance {
    private int watts;
    private double price;

    public Microwave(String serialNumber, double price, int watts) {
        super(serialNumber);
        this.price = price;
        this.watts = watts;
    }

    @Override
    public String toString() {
        return "Serial=" + getSerialNumber() + ". Price=$" + price + ". Watts=" + watts + ".";
    }
}
