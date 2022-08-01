import java.util.Random;
import java.util.Scanner;

public class ComboLock {
    private int firstDigit_generated;
    private int secondDigit_generated;
    private int thirdDigit_generated;
    Scanner user_choice = new Scanner(System.in);

    private int firstDigit;
    private int secondDigit;
    private int thirdDigit;

    // !! Constructers ..........
    public ComboLock() {
        generator();

        this.firstDigit = 0;
        this.secondDigit = 0;
        this.thirdDigit = 0;

    }

    public ComboLock(int secret1, int secret2, int secret3) {
        this();
        this.firstDigit = secret1;
        this.secondDigit = secret2;
        this.thirdDigit = secret3;
    }

    // !! Methods below ..........
    public void setFirstDigit(int firstDigit) {
        this.firstDigit = firstDigit;
    }

    public void setSecondDigit(int secondDigit) {
        this.secondDigit = secondDigit;
    }

    public void setThirdDigit(int thirdDigit) {
        this.thirdDigit = thirdDigit;
    }

    public int getFirstDigit() {
        return firstDigit;
    }

    public int getSecondDigit() {
        return secondDigit;
    }

    public int getThirdDigit() {
        return thirdDigit;
    }

    public void turnLeft(int ticks) {
        System.out.println(
                "Which digit you want to edit .. ? \n For example in  X Y Z \n (1)Enter one to edit X place \n(2)Enter two to edit Y place \n(3)Enter three to edit Z place ");
        int integer = user_choice.nextInt();
        if (integer == 1) {
            if ((this.firstDigit - ticks) >= 0 && (this.firstDigit - ticks) <= 39) {
                this.firstDigit = this.firstDigit - ticks;
            } else {
                System.out.println("Number out of range the range (0-39).. !! ");
            }
        } else if (integer == 2) {
            if ((this.secondDigit - ticks) >= 0 && (this.secondDigit - ticks) <= 39) {
                this.secondDigit = this.secondDigit - ticks;
            } else {
                System.out.println("Number out of range the range (0-39).. !! ");
            }
        } else if (integer == 3) {
            if ((this.thirdDigit - ticks) >= 0 && (this.thirdDigit - ticks) <= 39) {
                this.thirdDigit = this.thirdDigit - ticks;
            } else {
                System.out.println("Number out of range the range (0-39).. !! ");
            }
        } else {
            System.out.println("Enter a valid choice .. ! ");
        }

        currentEntries();
    }

    public void turnRight(int ticks) {
        System.out.println(
                "Which digit you want to edit .. ? \n For example in  X Y Z \n (1)Enter one to edit X place \n(2)Enter two to edit Y place \n(3)Enter three to edit Z place ");
        int integer = user_choice.nextInt();
        if (integer == 1) {
            if ((this.firstDigit + ticks) >= 0 && (this.firstDigit + ticks) <= 39) {
                this.firstDigit = this.firstDigit + ticks;
            } else {
                System.out.println("Number out of range the range (0-39).. !! ");
            }
        } else if (integer == 2) {
            if ((this.secondDigit + ticks) >= 0 && (this.secondDigit + ticks) <= 39) {
                this.secondDigit = this.secondDigit + ticks;
            } else {
                System.out.println("Number out of range the range (0-39).. !! ");
            }
        } else if (integer == 3) {
            if ((this.thirdDigit + ticks) >= 0 && (this.thirdDigit + ticks) <= 39) {
                this.thirdDigit = this.thirdDigit + ticks;
            } else {
                System.out.println("Number out of range the range (0-39).. !! ");
            }
        } else {
            System.out.println("Enter a valid choice .. ! ");
        }

        currentEntries();

    }

    public void generator() {
        Random generatoRandom = new Random();
        this.firstDigit_generated = generatoRandom.nextInt(38) + 1;
        this.secondDigit_generated = generatoRandom.nextInt(38) + 1;
        this.thirdDigit_generated = generatoRandom.nextInt(38) + 1;
        System.out.println(" New combination of pin created... !");

        // System.out.println("First" + this.firstDigit_generated + " second " +
        // this.secondDigit_generated + " third"
        // + this.thirdDigit_generated);

    }

    public void menu() {
        System.out.println("________________________Menu_________________________");
        System.out.println("******(1)Enter 1 to Turn left  from a digit*********");
        System.out.println("******(2)Enter 2 to Turn right from a digit*********");
        System.out.println("******(3)Enter 3 to attempt for opening the lock****");
        System.out.println("******(4)Enter 4 to reset the entries to 0 0 0 *****");
        System.out.println("******(5)Enter 5 to see current digits in lock *****");
        System.out.println("******(6)Enter 6 to enter the entries again********");
        System.out.println("******(7)Enter 7 to exit the lock  ****************");

    }

    public boolean open() {

        if (this.firstDigit == (this.firstDigit_generated + 1) && this.secondDigit == (this.secondDigit_generated - 1)
                && this.thirdDigit == (this.thirdDigit_generated + 1)) {
            // System.out.println("Succesfully opened the lock .......");
            return true;
        } else {
            // System.out.println("Wrong password... Try again. ! !");
            return false;
        }

    }

    public void reset() {
        this.firstDigit = 0;
        this.secondDigit = 0;
        this.thirdDigit = 0;
    }

    public void currentEntries() {
        System.out.println(this.firstDigit + "-" + this.secondDigit + "-" + this.thirdDigit);
    }
}