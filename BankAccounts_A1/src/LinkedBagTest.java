public class LinkedBagTest {
    public static void main(String[] args){
        BankAccount checking1 = new CheckingAccount("Justin", "January", 1000,50);
        BankAccount checking2 = new CheckingAccount("Alex", "February", 1050,50);
        BankAccount savings1 = new SavingsAccount("Jared", "March", 1100,0.2);
        BankAccount savings2 = new SavingsAccount("John", "April", 1150,0.2);

        LinkedBankBag testBag = new LinkedBankBag();

        testBag.add(checking1);
        testBag.add(checking1);
        testBag.add(checking2);
        testBag.add(savings1);
        testBag.add(savings2);
        testBag.add(savings2);

        testBag.printEverything();

        testBag.remove(savings1);
        testBag.remove();

        testBag.printEverything();

        testBag.balanceCheck(1075);
    }
}
