import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Banking {
    public static String usernames[] = { "Yaswanth", "Mike", "Amar", "Vicky", "Jane", "Stark" };
    public static String passwords[] = { "9440", "6968", "3789", "8756", "6098", "5670" };
    public static int amount_in_account[] = { 6956389, 843265, 69756, 1026339, 423201, 5086145 };
    public static String Create_Username, Create_Password, Create_Amount;
    public static int j, k;
    public static String username, password;
    public static Scanner input = new Scanner(System.in);

    public static void choose() {
        System.out.println("Select an Option\n1.Login\n2.Create Account\n9.Close");
        String option = input.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        switch (option) {
            case "1":
                login();
                break;
            case "2":
                create();
                break;
            case "9":
                close();
                break;
            default:
                System.out.println("Enter Correct Option");
                choose();
                break;
        }
    }

    static void close() {
        System.out.println("Thank For Using Yash Banking.\n");
    }

    static void login() {
        System.out.println("Login\nEnter Username:");
        username = input.nextLine();
        j = -1;
        for (int i = 0; i < usernames.length; i++) {
            if ((username.toLowerCase()).equals(usernames[i].toLowerCase())) {
                j = i;
            }
        }
        if (j == -1) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Enter Correct Username!...");
            login();
        } else {
            login_password();
        }
    }

    static void login_password() {
        System.out.println("Enter Password:");
        password = input.nextLine();
        if (password.equals(passwords[j])) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Hello " + username.toUpperCase());
            menu();
        } else {
            System.out.println("Enter Correct Password!...");
            login_password();
        }
    }

    static void menu() {
        System.out.println("1.Balance\n2.Transfer\n3.Withdraw\n4.Logout");
        String Option = input.nextLine();
        switch (Option) {
            case "1":
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Availabale Amount in your Account: " + amount_in_account[j]);
                menu();
            case "2":
                System.out.print("\033[H\033[2J");
                System.out.flush();
                transfer();
            case "3":
                System.out.print("\033[H\033[2J");
                System.out.flush();
                withdraw();
            case "4":
                username = "";
                password = "";
                j = -1;
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("You have Succssfully Logout.");
                choose();
            default:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Please select Correct Option!...");
                menu();
        }
    }

    static void transfer() {
        System.out.println("Enter The Name of User you want to transfer money.");
        String Transfer_User = input.nextLine();
        k = -1;
        if ((Transfer_User == "") || ((Transfer_User.toLowerCase()).equals(username.toLowerCase()))) {
            System.out.println("Enter correct Username!..");
            transfer();
        } else {
            for (int i = 0; i < usernames.length; i++) {
                if (Transfer_User.equals(usernames[i].toLowerCase())) {
                    k = i;
                }
            }
        }
        if (k == -1) {
            System.out.println("Username Not Exists!..");
            transfer();
        } else {
            transfer_1();
        }
    }

    static void transfer_1() {
        System.out.println("Available Balance: " + amount_in_account[j] + "\nEnter Amount To Transfer:");
        String Transfer_Amount = input.nextLine();
        boolean key = Transfer_Amount.matches("[0-9]+");
        if (key) {
            if (Integer.valueOf(Transfer_Amount) < amount_in_account[j]) {
                amount_in_account[j] = amount_in_account[j] - Integer.valueOf(Transfer_Amount);
                amount_in_account[k] = amount_in_account[k] + Integer.valueOf(Transfer_Amount);
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out
                        .println("Amount Transfer Successfully.\nAvailable Amount in Account:" + amount_in_account[j]);
                menu();
            } else {
                System.out.println("Insufficient Funds. Enter lesser Amount.");
                transfer_1();
            }
        } else {
            System.out.println("Enter Correct Amount.");
            transfer_1();
        }
    }

    static void withdraw() {
        System.out.println(
                "Available Balance: " + amount_in_account[j] + "\nEnter Amount to Withdraw(Min:100, Max:20,000)");
        String Withdraw_Amount = input.nextLine();
        boolean key = Withdraw_Amount.matches("[0-9]+");
        if (key) {
            if ((Integer.valueOf(Withdraw_Amount) <= 20000) && (Integer.valueOf(Withdraw_Amount) >= 100)) {
                if (Integer.valueOf(Withdraw_Amount) <= amount_in_account[j]) {
                    amount_in_account[j] = amount_in_account[j] - Integer.valueOf(Withdraw_Amount);
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println(Integer.valueOf(Withdraw_Amount)
                            + " Withdrawn Successfully.\nAvailable Balance: " + amount_in_account[j]);
                    menu();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Insufficient Funds. Enter Less Amount.");
                    withdraw();
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter amount between 100 to 20000.");
                withdraw();
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Enter amount between 100 to 20000.");
            withdraw();
        }
    }

    public static void create() {
        System.out.println("Create Account\nEnter Your Name:");
        Create_Username = input.nextLine();
        int p = 0;
        if (Create_Username.equals("")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Username can't be empty. Please Enter Your Name!..");
            create();
        } else {
            boolean key = Create_Username.matches("[a-zA-Z]+");
            if (key) {
                for (int i = 0; i < usernames.length; i++) {
                    if ((Create_Username.toLowerCase()).equals(usernames[i].toLowerCase())) {
                        p += 1;
                    }
                }
                if (p > 0) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Username already exists. Use another name.");
                    create();
                } else {
                    password();
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Username should only be Alphabetical. Use another name.");
                create();
            }
        }
    }

    public static void password() {
        System.out.println("Choose Your 4 Digit Numerical Password:");
        Create_Password = input.nextLine();
        if ((Create_Password != "") && (Create_Password.length() == 4)) {
            boolean key = Create_Password.matches("[0-9]+");
            if (key) {
                amount();
            } else {
                System.out.println("Password should be numerical!..");
                password();
            }
        } else {
            System.out.println("Set Correct Password with 4 numerical digits.");
            password();
        }
    }

    public static void amount() {
        try {
            System.out.println("Enter amount to deposit(Min Rs.2000/-):");
            Create_Amount = input.nextLine();
            boolean key = Create_Amount.matches("[0-9]+");
            if (key) {
                if (Integer.valueOf(Create_Amount) >= 2000) {
                    confirm();
                } else {
                    System.out.println("Enter Correct Amount in Rupees.");
                    amount();
                }
            } else {
                System.out.println("Amount should be Numerical!..");
                amount();
            }
        } catch (Exception e) {
            System.out.println("Error Occured. Please Try Again!...");
        }
    }

    public static void confirm() {
        System.out.println("To Confirm type Yes else No");
        String code = input.nextLine();
        if ((code.toLowerCase()).equals("yes")) {
            int i;
            int n = usernames.length;
            String newarr[] = new String[n + 1];
            String newarr1[] = new String[n + 1];
            int newarr2[] = new int[n + 1];
            for (i = 0; i < n; i++) {
                newarr[i] = usernames[i];
                newarr1[i] = passwords[i];
                newarr2[i] = amount_in_account[i];
            }
            newarr[n] = Create_Username;
            newarr1[n] = Create_Password;
            newarr2[n] = Integer.valueOf(Create_Amount);
            usernames = newarr;
            passwords = newarr1;
            amount_in_account = newarr2;
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(
                    "Account Created Successfully.\nUser Id: " + Create_Username + "\nPassword: " + Create_Password);
            choose();
        } else if ((code.toLowerCase()).equals("no")) {
            choose();
        } else {
            System.out.println("Enter Correct Confirmation Code.");
            confirm();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Yash Banking\n");
        choose();
    }
}
