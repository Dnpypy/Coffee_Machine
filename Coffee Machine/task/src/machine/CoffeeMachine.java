package machine;

import java.util.Scanner;

/**
 * @author User 143077307
 * @since 09.12.2021 20:10
 */


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

    enum Status {
        CHOOSING, BUYING, FILLING, TAKING, REMAINING, EXITING
    }

    static Status currentStatus = Status.CHOOSING;

    /**
     * main method
     * @param args ....
     */

    public static void main(String[] args) {
        do {
             menuBarCoffee();
             switch (menu) {
                case ("buy"):
                    changeStatus(Status.BUYING);
                    barDrinks();
                    break;
                case ("fill"):
                    changeStatus(Status.FILLING);
                    addStocksBarCoffee();
                    break;
                case ("take"):
                    changeStatus(Status.TAKING);
                    takeIncomeMoney();
                    break;
                case ("remaining"):
                    changeStatus(Status.REMAINING);
                    barCoffeeStatus();
                    break;
                case ("exit"):
                    exit();
             }
        } while (currentStatus != Status.EXITING);
    }

    /**
     * @param value takes the current value - the status at the moment
     */
    static void changeStatus(Status value) {
        currentStatus = value;
    }

    /**
     * the exit method allows you to exit the main loop
     */
    static void exit() {
        changeStatus(Status.EXITING);
    }

    /**
     * output status bar
     */
    static void barCoffeeStatus () {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println(money + "$ of money");
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
     * comparison of ingredients that are needed with which in stock
     */
    static boolean canMakeCoffee(int waterNeed, int milkNeed, int beansNeed) {
        if (water >= waterNeed) {
            if (milk >= milkNeed) {
                if (coffeeBeans >= beansNeed) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    return true;
                } else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }

            } else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    /**
     * menu drinks
     * ingridients, moneys, add, subtract or back menu
     * @value drink takes a number drink
     */
    static void barDrinks() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, , back - to main menu:");
        var drink = SC.next();
        switch (drink) {
            case "1": {
                if (canMakeCoffee(250, 0, 16)) {
                    water -= 250;
                    coffeeBeans -= 16;
                    disposableCups--;
                    money += 4;
                    break;
                }
            }
            case "2": {
                if (canMakeCoffee(350, 75, 20)) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    disposableCups--;
                    money += 7;
                    break;
                }
            }
            case "3": {
                if (canMakeCoffee(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    disposableCups--;
                    money += 6;
                    break;

                }
            }
            case "back": {
                break;
            }
            default: {
                break;
            }
        }

    }
}
