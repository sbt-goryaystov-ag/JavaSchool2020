package collections;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String mark;
    private String model;
    private int year;

    public Car(String mark, String model, int year) {
        this.mark = mark;
        this.model = model;
        this.year = year;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("\n{ mark = '%s',\n model = '%s',\n year = '%s' }\n", mark, model, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getYear() == car.getYear() &&
                getMark().equals(car.getMark()) &&
                getModel().equals(car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMark(), getModel(), getYear());
    }

    @Override
    // Сортируем сперва по марке, затем по модели и на последок по году
    public int compareTo(Car car) {
        if (car == null) {
            return 1;
        }
        int result = this.mark.compareTo(car.mark);
        if(result != 0){
            return result;
        }
        result = this.model.compareTo(car.model);
        if(result != 0){
            return result;
        }
        result = car.year - this.year;
        return result;
    }
}
