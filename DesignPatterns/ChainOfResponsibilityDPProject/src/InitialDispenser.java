public class InitialDispenser extends Dispenser {

    @Override
    public void dispense(Currency currency) {
        //passes user input to successor
        successor.dispense(currency);

    }
    
}
