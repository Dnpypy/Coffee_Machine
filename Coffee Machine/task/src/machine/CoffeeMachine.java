package machine;

import java.util.Scanner;

public class CoffeeMachine {
    /**
     * class variables
     */
    static final Scanner SC = new Scanner(System.in);
    static String menu;
    static int money = 550;
    static int water = 400;
    static int milk  = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;

    /**
     * main method
     * @param args ....
     */
    public static void main(String[] args) {
        barCoffeeStatus();
        menuBarCoffee();
        switch (menu) {
            case ("buy"):
                barDrinks();
                break;
            case ("fill"):
                addStocksBarCoffee();
                break;
            case ("take"):
                takeIncomeMoney();
        }
        barCoffeeStatus();
    }

    /**
     * take money
     * @value money = 0
     */
    static void takeIncomeMoney() {
        System.out.println("I gave you " + money + "$");
        money = 0;
    }

    /**
     * adding ingredients to the stock
     * @value water, milk, coffeeBeans, coffeeBeans
     */
    static void addStocksBarCoffee() {
        System.out.println("Write how many ml of water you want to add:");
        water += SC.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += SC.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += SC.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += SC.nextInt();
    }

    /**
     * menu bar
     * @value menu takes a string
     */
    static void menuBarCoffee() {
        System.out.println("Write action (buy, fill, take):");
        menu = SC.next();
    }

    /**
     * menu drinks
     * ingridients, moneys, add or subtract
     * @value drink takes a number drink
     */
    static void barDrinks() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        var drink = SC.nextInt();
        switch(drink){
            case (1):
                water -= 250;
                coffeeBeans -= 16;
                money += 4;
                break;
            case (2):
                water -= 350;
                milk -= 75;
                coffeeBeans -= 20;
                money += 7;
                break;
            case (3):
                water -= 200;
                milk -= 100;
                coffeeBeans -= 12;
                money += 6;
                break;
            default :
        }
        disposableCups--;
    }

    /**
     * output status bar
     */
    static void barCoffeeStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println(money + "$ of money\n");
    }


}
