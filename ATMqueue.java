import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ATMqueue {
    public static void main(String[] args) {
        Scanner inputY = new Scanner(System.in);
        int balance = 1000000;

        // Diperbarui dari: int[] transactions = new int[5];
        Queue<Integer> transactions = new LinkedList<>();

        System.out.print("Navigation \n1)Deposit \n2)Withdrawal \n3)Check Balance \n4)Amount Deposited \n5)Amount withdrawn \n6)Transactions \n7)Poll Transaction \n8)Peek Transaction \n0)Exit\n");
        do {
            System.out.print("\nSelect Menu: ");
            int menu = inputY.nextInt();

            if (menu == 0) {
                break;
            } else if (menu == 1) {
                System.out.print("Input amount: ");
                int amount = inputY.nextInt();
                balance += amount;
                transactions.offer(amount); // Queue.offer() untuk memasukkan ke antrean
            } else if (menu == 2) {
                System.out.print("Input amount: ");
                int amount = inputY.nextInt();
                if (balance < amount) {
                    System.out.print("insufficient amount, your balance is " + balance);
                    continue;
                }
                balance -= amount;
                transactions.offer(-amount); // Queue.offer() untuk memasukkan ke antrean
            } else if (menu == 3) {
                System.out.print("Balance: " + balance);
            } else if (menu == 4) {
                int totalDeposit = 0;
                for (int txn : transactions) {
                    if (txn > 0) {
                        totalDeposit += txn;
                    }
                }
                System.out.print("Total Deposit: " + totalDeposit);
            } else if (menu == 5) {
                int totalWithdrawn = 0;
                for (int txn : transactions) {
                    if (txn < 0) {
                        totalWithdrawn += -txn;
                    }
                }
                System.out.print("Total Wirthdrawn: " + totalWithdrawn);
            } else if (menu == 6) {
                int index = 1;
                for (int txn : transactions) {
                    System.out.println(index++ + " " + txn);
                }
            } else if (menu == 7) {
                // Poll: Mengambil dan MENGHAPUS transaksi terlama (FIFO)
                if (transactions.isEmpty()) {
                    System.out.print("Queue is empty");
                } else {
                    int polled = transactions.poll();
                    System.out.print("Polled oldest transaction: " + polled);
                }
            } else if (menu == 8) {
                // Peek: Mengintip transaksi terlama TANPA menghapusnya
                if (transactions.isEmpty()) {
                    System.out.print("Queue is empty");
                } else {
                    System.out.print("Oldest transaction (Peek): " + transactions.peek());
                }
            }
        } while (true);

        inputY.close();
    }
}