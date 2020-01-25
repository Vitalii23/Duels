package com.info.apache.game;


import com.info.apache.model.Player;

import java.util.Random;

public class Duel {
    private int damage, health, rating;

    public void duel(Player player1, Player player2){
        do {
            attack(player1, player2);
            attack(player2, player1);
        } while (player1.isAlive() && player2.isAlive());

        if(player1.isAlive()){
            System.out.println(player1.getName() + " win");
        } else if (player2.isAlive()){
            System.out.println(player2.getName() + " win");
        } else {
            System.out.println("Draw!");
        }
    }

    public void attack(Player attacker, Player defender){
        Random rnd = new Random();
        damage = rnd.nextInt(10)+ 1;
        health = defender.getHealth() - damage;
        health = health < 0 ? 0 : health;
       // rating = defender.getRating() - rating;

        System.out.println(attacker.getName() + "'s attack does " + damage + " damage!\n");
        System.out.println(defender.getName() + "'s Health: " + health);

        defender.setHealth(health);
      //  defender.setHealth(rating);
    }


}

