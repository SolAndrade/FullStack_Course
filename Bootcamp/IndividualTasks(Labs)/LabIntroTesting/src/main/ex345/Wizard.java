package main.ex345;

public class Wizard extends Player{
    public Wizard(String name, int health, int strength, int lives) {
        super(name, health, strength, lives);
    }

    public void castSpell(Player otherPlayer) {
        int damage = 20;
        otherPlayer.takeDamage(damage);
    }
}
