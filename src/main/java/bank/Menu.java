package bank;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public static void main(String[] args){
        System.out.println("Welcome to Java Bank");

        Menu menu = new Menu();
        menu.scanner = new Scanner(System.in);
        Customer customer = menu.authenticateUser();

        if(customer != null){
            Account account = DataSource.getAccount(customer.getAccountId());
            menu.showMenu(customer, account);
        }

        menu.scanner.close();
    }

    private Customer authenticateUser(){
        System.out.println("Please enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();

        Customer customer = null;
        try{
            customer = Authenticator.login(username, password);
        } catch (LoginException e) {
            System.out.println("Error"+ e.getMessage());
            throw new RuntimeException(e);
        }
        return customer;
    }

    private void showMenu(Customer customer, Account account){
        int selection = 0;
        while(selection != 4 && customer.isAuthenticated()){
            System.out.println("======================");
            System.out.println("Please select an option");
            System.out.println("1: Deposit");
            System.out.println("2: Withdraw");
            System.out.println("3: Check Balance");
            System.out.println("4: Exit");
            System.out.println("========================");

            selection = scanner.nextInt();
            double amount =0;
            switch(selection){
                case 1:
                    System.out.println("Enter amount to Deposit");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;


                case 2:
                    System.out.println("Enter amount to Withdraw");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                    break;

                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;

                case 4:
                    Authenticator.logout(customer);
                    System.out.println("Thanks for banking with Java");
                    break;

                default:
                    System.out.println("Invalid selection");
                    break;
            }

        }
    }
}
