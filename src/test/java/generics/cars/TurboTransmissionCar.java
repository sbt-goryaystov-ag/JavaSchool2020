package generics.cars;

public class TurboTransmissionCar extends Car {

    boolean turbo;
    Transmission transmission;

    public TurboTransmissionCar(String name, String model, int year, boolean turbo, Transmission transmission) {
        super(name, model, year);
        this.transmission = transmission == null ? Transmission.MANUAL : transmission;
        this.turbo = turbo;
    }

    boolean getTurbo() {
        return turbo;
    }

    String getTransmission() {
        return transmission.name();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\n{ turbo = '%s',\n transmission = '%s' }\n", getTurbo(), getTransmission());
    }

    public enum Transmission {
        MANUAL,
        AUTO
    }
}
