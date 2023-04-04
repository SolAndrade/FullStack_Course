class Pet {
    private String name;
    private int age;
   
    // constructor, getters, & setters omitted for brevity
  }
   
  import java.util.List;
  import java.util.ArrayList;
  import java.util.HashMap;
   
  class Main {
    public static void main(String[] args) {
   
      // Add Maria's pets
      List<Pet> mariasPets = new ArrayList<>();
      mariasPets.add(new Pet("Rex", 15));
      mariasPets.add(new Pet("Fluffy", 2));
      
      // Adds Juan's pets
      List<Pet> juansPets = new ArrayList<>();
      juansPets.add(new Pet("Coco", 5));
      
      // Create a Pet Owner's structure
      HashMap<String, List<Pet>> petsOwners = new HashMap<>();
      
      petsOwners.put("mrodriguez@mail.com", mariasPets);
      petsOwners.put("jdominguez@mail.com", juansPets);
      
    }
  }
   
