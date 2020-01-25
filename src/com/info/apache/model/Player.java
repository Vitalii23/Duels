package com.info.apache.model;

public class Player {
    private int id, damage, health, rating;
    private String name;

    public Player(int damage, int health, String name) {
        this.damage = damage;
        this.health = health;
        this.name = name;
       // this.rating = rating;
    }

    public Player() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  /*  public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
*/

    public boolean isAlive() {
        return health > 0;
    }
}
