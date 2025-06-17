package bank;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankService();

        while (true) {
            System.out.println("\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.next();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    Account account = new Account(accNum, name, balance);
                    bankService.createAccount(account);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.next();
                    System.out.print("Enter Amount to Deposit: ");
                    double deposit = scanner.nextDouble();
                    bankService.deposit(accNum, deposit);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.next();
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdraw = scanner.nextDouble();
                    bankService.withdraw(accNum, withdraw);
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    accNum = scanner.next();
                    bankService.checkBalance(accNum);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice Please Don't Exist.");
            }
        }
    }
}
