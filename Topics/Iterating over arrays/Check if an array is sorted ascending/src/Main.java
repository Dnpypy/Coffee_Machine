import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 1;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                count++;
            }
        }

        System.out.println(count == size);
    }
}