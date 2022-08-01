import java.util.Scanner;

public class ComboLockTester {
    public static void main(String[] args) {
        ComboLock g1 = new ComboLock();
        Scanner userEntry = new Scanner(System.in);

        int menuentry;

        boolean first_doWhile = true;
        do {
            System.out.println("Enter the first digit");
            int secret1 = userEntry.nextInt();
            System.out.println("Enter the second digit");
            int secret2 = userEntry.nextInt();
            System.out.println("Enter the third digit");
            int secret3 = userEntry.nextInt();
            if (secret1 == 0 && secret2 == 0 && secret3 == 0) {
                break; // !! Exit when user enters 0 0 0
            }

            else {
                g1.setThirdDigit(secret3);
                g1.setSecondDigit(secret2);
                g1.setFirstDigit(secret1);
                do {
                    g1.menu(); // !! try making a different scanner

                    menuentry = userEntry.nextInt();

                    if (menuentry == 1) {
                        System.out.println("How many tick you want to move in a digit ?");
                        int user_choice_for_ticks = userEntry.nextInt();
                        g1.turnLeft(user_choice_for_ticks);
                    } else if (menuentry == 2) {
                        System.out.println("How many tick you want to move in a digit ?");
                        int user_choice_for_ticks = userEntry.nextInt();

                        g1.turnRight(user_choice_for_ticks);
                    } else if (menuentry == 3) {
                        System.out.println("Trying to open...............");

                        if (g1.open()) {
                            System.out.println("Succesfully opened the lock .......");
                            g1.generator();
                            System.out.println("New lock with different values created .");

                        } else {
                            System.out.println("Wrong password... Try again. ! !");

                        }
                        // g1.open();
                    } else if (menuentry == 4) {
                        System.out.println("Reseting the entries to 0 0 0");
                        g1.reset();
                    } else if (menuentry == 5) {
                        g1.currentEntries();
                    } else if (menuentry == 6) {
                        System.out.println("Enter the first digit");
                        secret1 = userEntry.nextInt();
                        System.out.println("Enter the second digit");
                        secret2 = userEntry.nextInt();
                        System.out.println("Enter the third digit");
                        secret3 = userEntry.nextInt();
                        if (secret1 == 0 && secret2 == 0 && secret3 == 0) {
                            break; // !! Exit when user enters 0 0 0
                        }
                        g1.setThirdDigit(secret3);
                        g1.setSecondDigit(secret2);
                        g1.setFirstDigit(secret1);

                    } else if (menuentry == 7) {
                        System.out.println("BYE ..");
                        first_doWhile = false;
                        break;
                    } else {

                        System.out.println("**Enter a valid choice **");
                    }
                } while (true);
            }

        } while (first_doWhile);

        userEntry.close();
    }
}
