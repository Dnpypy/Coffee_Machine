package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need:");
        var cups = new Scanner(System.in).nextInt();
        cupsCoffee(cups);
    }

    public static void cupsCoffee(int cup) {
        var water = 200;
        var milk = 50;
        var coffeeBeans = 15;
        System.out.println(water * cup + " ml of water");
        System.out.println(milk * cup + " ml of milk");
        System.out.println(coffeeBeans * cup + " g of coffee beans");
    }

//    public static void menuCoffee() {
//        System.out.println(
//                "Starting to make a coffee\n" +
//                        "Grinding coffee beans\n" +
//                        "Boiling water\n" +
//                        "Mixing boiled water with crushed coffee beans\n" +
//                        "Pouring coffee into the cup\n" +
//                        "Pouring some milk into the cup\n" +
//                        "Coffee is ready!\n");
//    }
}
