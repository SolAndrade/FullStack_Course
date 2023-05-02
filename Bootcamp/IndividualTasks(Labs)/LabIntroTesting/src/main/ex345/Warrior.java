package main.ex345;

public class Warrior extends Player {
    public Warrior(String name, int health, int strength, int lives) {
        super(name, health, strength, lives);
    }

    public void shieldBlock() {
        setHealth(getHealth() + 10);
    }
}
