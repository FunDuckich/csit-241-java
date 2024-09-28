package org.knit.lab3;

public abstract class Player {
    final private String name;
    private int maxHealth;
    private int health;
    private boolean isAlive = true;
    private float posX;
    private float posY;
    private int damage;
    private int attackRange;

    public Player(String name, float posX, float posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
    }

    public void moveTo(int x, int y) {
        posX = x;
        posY = y;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public void increaseHealth(int value) {
        health += value;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public void decreaseHealth(int value) {
        health -= value;
        if (health < 0) {
            health = 0;
            isAlive = false;
        }
    }

    public boolean checkIsAlive() {
        return isAlive;
    }

    public String getName() {
        return name;
    }

    protected int getDamageValue() {
        return damage;
    }

    protected void setDamageValue(int value) {
        this.damage = value;
    }

    protected int getAttackRange() {
        return attackRange;
    }

    protected void setAttackRange(int value) {
        this.attackRange = value;
    }

    protected int calculateDistance(float posX, float posY) {
        return (int) Math.sqrt(Math.pow(posX - this.posX, 2) + Math.pow(posY - this.posY, 2));
    }

    protected void setMaxHealth(int value) {
        this.maxHealth = value;
        health = value;
    }
}
