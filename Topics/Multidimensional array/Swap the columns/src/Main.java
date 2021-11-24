import java.util.Scanner;

class Main {

    private static final Scanner SC = new Scanner(System.in);
    private static int[][] swapMatrix;
    private static int row;
    private static int col;

    public static void main(String[] args) {
        // put your code here
        row = SC.nextInt();
        col = SC.nextInt();
        swapMatrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                swapMatrix[i][j] = SC.nextInt();
            }
        }

        int a = SC.nextInt();
        int b = SC.nextInt();

        swapColumn(a, b, swapMatrix);
        outputMatrix();
    }

    public static void swapColumn(int c1, int c2, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][c1];
            arr[i][c1] = arr[i][c2];
            arr[i][c2] = temp;
        }
    }

    public static void outputMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(swapMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
