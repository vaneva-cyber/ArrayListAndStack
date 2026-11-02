import java.util.ArrayList;
import java.util.Scanner;

public class ATMarraylist {
    public static void main(String[] args) {
        Scanner inputY = new Scanner(System.in);
        int balance = 1000000;
        
        // Diperbarui dari: int[] transactions = new int[5];
        ArrayList<Integer> transactions = new ArrayList<>();

        System.out.print("Navigation \n1)Deposit \n2)Withdrawal \n3)Check Balance \n4)Amount Deposited \n5)Amount withdrawn \n6)Transactions \n0)Exit\n");
        do {
            System.out.print("\nSelect Menu: ");
            int menu = inputY.nextInt();

            if (menu == 0) {
                break;
            } else if (menu == 1) {
                System.out.print("Input amount: ");
                int amount = inputY.nextInt();
                balance += amount;
                transactions.add(amount); // Menggunakan ArrayList.add()
            } else if (menu == 2) {
                System.out.print("Input amount: ");
                int amount = inputY.nextInt();
                if (balance < amount) {
                    System.out.print("insufficient amount, your balance is " + balance);
                    continue;
                }
                balance -= amount;
                transactions.add(-amount); // Menggunakan ArrayList.add()
            } else if (menu == 3) {
                System.out.print("Balance: " + balance);
            } else if (menu == 4) {
                int totalDeposit = 0;
                for (int i = 0; i < transactions.size(); i++) {
                    if (transactions.get(i) > 0) {
                        totalDeposit += transactions.get(i);
                    }
                }
                System.out.print("Total Deposit: " + totalDeposit);
            } else if (menu == 5) {
                int totalWithdrawn = 0;
                for (int i = 0; i < transactions.size(); i++) {
                    if (transactions.get(i) < 0) {
                        totalWithdrawn += transactions.get(i);
                    }
                }
                System.out.print("Total Withdrawn: " + totalWithdrawn);
            } else if (menu == 6) {
                for (int i = 0; i < transactions.size(); i++) {
                    System.out.println((i + 1) + " " + transactions.get(i));
                }
            }
        } while (true);

        inputY.close();
    }
}