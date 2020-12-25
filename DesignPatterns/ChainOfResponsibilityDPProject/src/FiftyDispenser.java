public class FiftyDispenser extends Dispenser {
    
    @Override
    public void dispense(Currency currency) {
        //checks if user input is not null
        if(currency != null) {
            int amount = currency.getAmount();
            int remainder = 0;
            //if user input is greater than or equal to 50 perform operation
            if(amount >= 50) {
                int count = amount/50;
                remainder = amount % 50;
                System.out.println("Number of fifty notes: " + count);
            } else {
                //if user input is less than 50 pass user input to successor
                successor.dispense(currency);
            }
            if(remainder > 0) {
                //if user input is greater than or equal to 50 and there is a remainder after calculations
                //calls successor and pass the new remaining value
                successor.dispense(new Currency(remainder));
            }
        }
    }
}
