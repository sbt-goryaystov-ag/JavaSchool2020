package generics.cars;

public class CarWithPrice extends TurboTransmissionCar {

    double price;

    public CarWithPrice(String name, String model, int year, boolean turbo, Transmission transmission, double price) {
        super(name, model, year, turbo, transmission);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\n{ price = '%s' }\n", getPrice());
    }
}
