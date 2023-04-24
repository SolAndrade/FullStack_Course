package ex3;

public class Sedan extends Car{
    public Sedan(String vinNumber, String make, String model, int mileage) {
        super(vinNumber, make, model, mileage);
    }

    public String getType() {
        return "Ex3.Sedan";
    }
}
