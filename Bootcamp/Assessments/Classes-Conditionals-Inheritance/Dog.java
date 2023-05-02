public class Dog {
    private String name;
    private int age;
    private String breed;
    private final long id;

    public Dog(long id) {
        this.id = id;
    }
    public Dog(String name, int age, String breed, long id) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public long getId() {
        return id;
    }

}