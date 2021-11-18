package machine;

import java.util.Scanner;

public class CoffeeMachine {

    /**
     * class variables
     */
    private static final Scanner SC = new Scanner(System.in);
    private static final int WATER_CUP = 200;
    private static final int MILK_CUP = 50;
    private static final int COFFEE_BEANS_CUP = 15;

    /**
     * instance variables
     */
    private final int[] arrCoffee = new int[4];
    final int water;
    final int milk;
    final int coffeeBeans;
    private final int needCoffee;
    private int canCups = Integer.MAX_VALUE;

    /**
     * constructor class CoffeeMachine
     * @param water inc water value
     * @param milk int milk value
     * @param coffeeBeans inc coffeeBeans value
     * @param needCoffee int needCoffee value
     */
    public CoffeeMachine(int water, int milk, int coffeeBeans, int needCoffee) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.needCoffee = needCoffee;
    }

    /**
     * main method
     * @param args ....
     */
    public static void main(String[] args) {

        System.out.println("Write how many ml of water the coffee machine has:");
        int w = SC.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int m = SC.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int cb = SC.nextInt();

        System.out.println("Write how many cups of coffee you will need: ");
        int nC = SC.nextInt();

        CoffeeMachine coffeeMachine = new CoffeeMachine(w, m, cb, nC);
        coffeeMachine.takesNumberIngridients(w, m, cb, nC);
        coffeeMachine.minIngridients();
        coffeeMachine.outputMakeCoffee();

    }

    /**
     * instance method
     * output variant make coffee
     */
    void outputMakeCoffee() {
        if (canCups == needCoffee) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (canCups > needCoffee) {
            System.out.println("Yes, I can make that amount of coffee (ancups even " + (canCups - needCoffee)+ " more than that)");
        } else {
            System.out.println("No, I can make only " + canCups + " cup(s) of coffee");
        }
    }

    /**
     * instance method
     * counting minimum ingridients
     */

    void minIngridients() {
        canCups = arrCoffee[0];
        canCups = canCups < arrCoffee[1] ? (Math.min(canCups, arrCoffee[2])) : (Math.min(arrCoffee[1], arrCoffee[2]));
    }

    /**
     * instance method
     * @param a takes the number of water
     * @param b takes the number of milk
     * @param c takes the number of coffee beans
     * @param cups how many cups of coffee
     */

    void takesNumberIngridients(int a, int b, int c, int cups) {
        arrCoffee[0] = a / WATER_CUP;
        arrCoffee[1] = b / MILK_CUP;
        arrCoffee[2] = c / COFFEE_BEANS_CUP;
        arrCoffee[3] = cups;
    }

}
