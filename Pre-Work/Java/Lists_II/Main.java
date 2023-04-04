import java.util.List;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    List<Car> carList = new ArrayList<>();
    carList.add(new Car("Ford", "000001"));
    carList.add(new Car("Citroen", "000002"));
    carList.add(new Car("Mercedes", "000003"));
    
    for(int i = 0; i < carList.size(); i++) {
        System.out.println(carList.get(i).getName());
    }

  }
  
}