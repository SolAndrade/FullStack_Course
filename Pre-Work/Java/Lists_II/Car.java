public class Car {
    private String name;
    private String phone;

    public Car(String name, String phone){
        setName(name);
        setPhone(phone);
    }

    public void setName(String name){
        this.name = name;
    }
     
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getName(){
        return this.name;
    }

    public String getPhone(){
        return this.phone;
    }
}
