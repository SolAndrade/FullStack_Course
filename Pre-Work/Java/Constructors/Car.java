class Car{
    private String make; 
    private boolean forSale; 
    private int vin;
    
    public Car(int vin){
      setVin(vin);
      this.make = "Volkswagen";
      this.forSale = true;
    }
    
    public Car(int vin, String make){
      setVin(vin);
      setMake(make);
      this.forSale = true;
    }
    
    public Car(int vin, String make, boolean forSale){
      setVin(vin);
      setMake(make);
      isForSale(forSale);
    }
    
    // Getters & setters omitted for brevity
    
  }
