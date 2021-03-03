import java.util.Scanner;

public class ExtraCreditTest {
    public static void main(String[] args){
        LinkedBankBag bagOfBanks = new LinkedBankBag();

        Scanner keyboard = new Scanner(System.in);
        String accountType;
        String accountName;
        String createDate;
        double balance;
        Boolean loop = true;
        String YorN;

        System.out.println("Welcome!\n");

        while(loop){
            System.out.println("What kind of account do you want? Checking Account or Savings Account?");
            accountType = keyboard.nextLine();

            System.out.println("What is the Account Name?");
            accountName = keyboard.nextLine();

            System.out.println("What is the Date?");
            createDate = keyboard.nextLine();

            System.out.println("Balance:");
            balance = keyboard.nextDouble();

            if(accountType.equals("Checking Account")){
                double withdrawalCap;

                System.out.println("Withdrawal Limit: ");
                withdrawalCap = keyboard.nextDouble();

                BankAccount checking = new CheckingAccount(accountName, createDate, balance, withdrawalCap);
                bagOfBanks.add(checking);

                keyboard.nextLine();

                System.out.println("Would you like to continue? (Y/N)");
                YorN = keyboard.nextLine();
                if(YorN.equals("Y")){
                    loop = true;
                } else{
                    loop = false;
                }
            } else if(accountType.equals("Savings Account")){
                double interestRate;

                System.out.println("Interest Rate: ");
                interestRate = keyboard.nextDouble();

                BankAccount savings = new SavingsAccount(accountName, createDate, balance, interestRate);
                bagOfBanks.add(savings);

                keyboard.nextLine();

                System.out.println("Would you like to continue? (Y/N)");
                YorN = keyboard.nextLine();
                if(YorN.equals("Y")){
                    loop = true;
                } else{
                    loop = false;
                }
            } else{
                System.out.println("Please enter either \"Checking Account\" or \"Savings Account\"... \n\n\n");
            }
        }

        System.out.println("Printing bag contents...");
        bagOfBanks.printEverything();

        int balanceCheck;
        System.out.println("Enter a balance to check: ");
        balanceCheck = keyboard.nextInt();

        bagOfBanks.balanceCheck(balanceCheck);

        keyboard.close();
    }
}
