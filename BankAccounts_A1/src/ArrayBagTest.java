public class ArrayBagTest {
    public static void main(String[] args){

        BankAccount bank1 = new BankAccount("Justin","January 10, 2015",1000,"Checking Account");
        BankAccount bank2 = new CheckingAccount("Alex","January 10, 2015",1050,10);
        BankAccount bank3 = new SavingsAccount("Jared","January 10, 2015",1100,0.2);
        BankAccount bank4 = new BankAccount("John","January 10, 2015",1150,"Checking Account");
        BankAccount bank5 = new BankAccount("Joanne","January 10, 2015",1200,"Savings Account");
        BankAccount bank6 = new BankAccount("Joseph","January 10, 2015",1250,"Savings Account");

        ArrayBag testBag = new ArrayBag(10);
        testBag.add(bank1);
        testBag.add(bank1);
        testBag.add(bank2);
        testBag.add(bank3);
        testBag.add(bank4);
        testBag.add(bank4);
        testBag.add(bank5);
        testBag.add(bank6);

        System.out.println(testBag.toString());

        testBag.remove();
        testBag.remove(bank1);

        System.out.println(testBag.toString());

        testBag.balanceCheck(1150);


    }
}
