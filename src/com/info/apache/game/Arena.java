package com.info.apache.game;

import com.info.apache.model.Player;

import java.util.HashMap;
import java.util.Map;

public class Arena extends Duel {
    private Map<String, Player> combatants;
    private int damage = 10, health = 100, rating = 0;

    public Arena() {
        combatants = new HashMap<String, Player>();
        Player player1 = new Player(damage, health, "Adolf");
        Player player2 = new Player(damage, health, "Joseph");

        combatants.put("Adolf", player1);
        combatants.put("Joseph", player2);
    }

    public Player getCombatant(String name) {
        Player combatant = combatants.get(name);
        if (combatant == null) {
            System.out.println("No combatant with name " + name + " was found!");
            return null;
        } else {
            return new Player(combatant.getDamage(), combatant.getHealth(),
                    combatant.getName());
        }
    }

    public static void main(String[] args) {
        Arena arena = new Arena();
        Player player1 = arena.getCombatant("Adolf");
        Player player2 = arena.getCombatant("Joseph");
        arena.duel(player1, player2);
    }
}
