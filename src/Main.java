import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserRegistry registry = new UserRegistry();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- User Registry Menu ---");
            System.out.println("1. Register user");
            System.out.println("2. Login user");
            System.out.println("3. Logout user");
            System.out.println("4. Check if user registered");
            System.out.println("5. Remove user");
            System.out.println("6. Print total unique users");
            System.out.println("7. Display all users");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter login: ");
                    String regLogin = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();

                    registry.registerUser(regLogin, regPassword);
                    break;

                case 2:
                    System.out.print("Enter login: ");
                    String login = scanner.nextLine();

                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    registry.loginUser(login, password);
                    break;

                case 3:
                    System.out.print("Enter user id: ");
                    int logoutId = scanner.nextInt();

                    registry.logoutUser(logoutId);
                    break;

                case 4:
                    System.out.print("Enter login: ");
                    String checkLogin = scanner.nextLine();

                    if (registry.isUserRegistered(checkLogin)) {
                        System.out.println("Користувач зареєстрований");
                    } else {
                        System.out.println("Користувач не зареєстрований");
                    }
                    break;

                case 5:
                    System.out.print("Enter user id: ");
                    int removeId = scanner.nextInt();

                    registry.removeUser(removeId);
                    break;

                case 6:
                    registry.printTotalUniqueUsers();
                    break;

                case 7:
                    registry.displayAllUsers();
                    break;

                case 0:
                    System.out.println("Program finished");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (choice != 0);

        scanner.close();
    }
}
