import java.util.List;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    List<String> carBrands = new ArrayList<>();
    carBrands.add("Ford");
    carBrands.add("Citroen");
    carBrands.add("Mercedes");
    carBrands.add("Ferrari");
    
    for(int i = 0; i < carBrands.size(); i++) {
        System.out.println(carBrands.get(i));
    }

    carBrands.remove(2);
    
    for(int i = 0; i < carBrands.size(); i++) {
        System.out.println(carBrands.get(i));
    }

  }
  
}
