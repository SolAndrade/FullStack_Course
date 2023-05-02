package main.ex345;

public class Elf extends Player{
    public Elf(String name, int health, int strength, int lives) {
        super(name, health, strength, lives);
    }

    public void dodge() {
        setHealth(getHealth() + 5);
    }
}
