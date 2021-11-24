package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Health;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public class FirstAid {
    public static int used = 0;
    public static int price;
    public static int level;
    private static int firstAid;

    private FirstAid() {
    }

    public static int get() {
        return firstAid;
    }

    /**
     * Either sets the number of first aid owned by the player to amount or adds amount to the number of first aid owned by the player
     * @param amount
     * @param add whether or not amount is set or added
     */
    public static void set(int amount, boolean add) {
        if (!add) {
            firstAid = amount;
        } else {
            firstAid += amount;
            if (firstAid < 0) firstAid = 0;
        }
    }

    /**
     * Checks whether user has a first aid kit to use, whether user can gain health, and adds the amount of health gained from a first aid kit
     */
    public static void use() {

        Ui.cls();

        if (get() <= 0) {

            Ui.println("----------------------------------------------------");
            Ui.println("You have no First-Aid kits left!");
            Ui.println("Go to the shop to buy some more.");
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else if (Health.get() == 100) {

            Ui.println("----------------------------------------------------");
            Ui.println("You already have full health!");
            Ui.println("You don't need a First-Aid kit!");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getAsString());
            Ui.println("First-Aid kits: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else {

            set(-1, true);
            Health.gain(20);
            used++;

            Ui.println("----------------------------------------------------");
            Ui.println("You have used a First-Aid kit.");
            Ui.println("You've gained 20 health.");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getAsString());
            Ui.println("First-Aid kits: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        }

    }

    /**
     * Checks if the first aid kit can be purchased and then sets the proper variables to signify purchase
     */
    public static void buy() {
        if (Xp.getLevel() < level) {
            Ui.println("You have to be at least level " + level + " to buy this!");
            Ui.pause();
        } else if (price <= Coins.get()) {
            Coins.set(-price, true);
            Stats.coinsSpentOnHealth += price;
            set(1, true);
            Ui.println("Thank you for your purchase. Come again soon! ");
            Ui.pause();
        } else {
            Ui.println("You do not have enough coins.");
            Ui.pause();
        }
    }
}
