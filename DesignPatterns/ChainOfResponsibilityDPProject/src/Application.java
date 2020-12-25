public class Application {
    public static void main(String[] args) {

        //create objects for each class to assign values
        InitialDispenser initialDispenser = new InitialDispenser();
        HundredDispenser hundredDispenser = new HundredDispenser();
        FiftyDispenser fiftyDispenser = new FiftyDispenser();
        TwentyDispenser twentyDispenser = new TwentyDispenser();
        TenDispenser tenDispenser = new  TenDispenser();

        //set successor for each object
        initialDispenser.setSuccessor(hundredDispenser);
        hundredDispenser.setSuccessor(fiftyDispenser);
        fiftyDispenser.setSuccessor(twentyDispenser);
        twentyDispenser.setSuccessor(tenDispenser);

        //initialDispenser.dispense(new Currency(670));
        //creates new currency object to pass user input amount
        Currency currency = new Currency(650);
        //passes the amount to method in initial class of chain
        initialDispenser.dispense(currency);
    }
}
