import java.util.Scanner;

public class Player {
    private char tokken;
    private int[] coordinates = new int[2];
    private boolean validCoordinates = false;

    public Player(char tokken) {
        this.tokken = tokken;
    }

    public char getTokken() {
        return this.tokken;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public boolean isValidCoordinates() {
        return validCoordinates;
    }

    public void playerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your desired x position:");
        int x = scanner.nextInt() - 1;

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter your desired y position:");
        int y = scanner2.nextInt() - 1;
        if (x < 3 && y < 3) {
            int[] coordinates = new int[2];
            coordinates[0] = x;
            coordinates[1] = y;
            this.coordinates[0] = x;
            this.coordinates[1] = y;
            this.validCoordinates = true;
        } else {
            System.out.println("Invalid coordinates! Please repeat your input");
        }
    }


}
