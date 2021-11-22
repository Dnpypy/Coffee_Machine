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
    static String strIngridient = "";

    /**
     * main method
     * @param args ....
     */

    public static void main(String[] args) {

        boolean t = true;
        while (t) {
            menuBarCoffee();

            switch (menu) {
                case ("buy"):
                    barDrinks();
                    checkIngridients();
                    break;
                case ("fill"):
                    addStocksBarCoffee();
                    break;
                case ("take"):
                    takeIncomeMoney();
                    break;
                case ("remaining"):
                    barCoffeeStatus();
                    break;
                case ("exit"):
                    t = false;
            }

        }
    }

    /**
     * checking the number of ingredients in the warehouse
     * return strIngridient String
     */
    static String checkIngridients() {
        if (water < 400) {
            strIngridient = "Sorry, not enough water!";
        } else if (milk < 540) {
            strIngridient = "Sorry, not enough milk!";
        } else if (coffeeBeans < 120) {
            strIngridient = "Sorry, not enough coffeeBeans!";
        } else if (disposableCups < 9) {
            strIngridient = "Sorry, not enough disposableCups!" ;
        }
        return strIngridient;
    }

    /**
     * take money
     * @value money = 0
     */
    static void takeIncomeMoney() {
        System.out.println("\nI gave you " + money + "$");
        money = 0;
    }

    /**
     * adding ingredients to the stock
     * @value water, milk, coffeeBeans, coffeeBeans
     */
    static void addStocksBarCoffee() {
        System.out.println("\nWrite how many ml of water you want to add:");
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
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        menu = SC.next();
    }

    /**
     * menu drinks
     * ingridients, moneys, add or subtract
     * @value drink takes a number drink
     */
    static void barDrinks() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, , back - to main menu:");

        var drink = SC.next();
        switch(drink){
            case ("1"):
                if (strIngridient != "") {
                    System.out.println(strIngridient);
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                }
                break;
            case ("2"):
                if (strIngridient != "") {
                    System.out.println(strIngridient);
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                }
                break;
            case ("3"):
                if (strIngridient != "") {
                    System.out.println(strIngridient);
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                }
                break;
            case ("back"):
                break;
            default :
                break;
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
        System.out.println(money + "$ of money");
    }


}
