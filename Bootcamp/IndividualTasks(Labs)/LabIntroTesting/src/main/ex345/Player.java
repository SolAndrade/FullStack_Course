package main.ex345;

public class Player {
    private String name;
    private int health;
    private int strength;
    private int lives;
    private int originalHealth;

    public Player(String name, int health, int strength, int lives) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.lives = lives;
        this.originalHealth = originalHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public void attack(Player otherPlayer) {
        int damage = this.strength;
        otherPlayer.health -= damage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            loseLife();
        }
    }

    public void loseLife() {
        this.lives--;
        if(this.lives <= 0) {
            die();
        } else {
            this.health = 100;
        }
    }

    public void die() {
        System.out.println(this.name + " has died.");
    }

    public void decrementLives() {
        this.lives--;
        this.health = this.originalHealth;
    }

}
