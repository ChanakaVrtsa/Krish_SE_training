public class TwentyDispenser extends Dispenser {

    @Override
    public void dispense(Currency currency) {
        //checks if user input is not null
        if(currency != null) {
            int amount = currency.getAmount();
            int remainder = 0;
            //if user input is greater than or equal to 20 perform operation
            if(amount >= 20) {
                int count = amount/20;
                remainder = amount % 20;
                System.out.println("Number of twenty notes: " + count);
            } else {
                //if user input is less than 20 pass user input to successor
                successor.dispense(currency);
            }
            if(remainder > 0) {
                //if user input is greater than or equal to 20 and there is a remainder after calculations
                //calls successor and pass the new remaining value
                successor.dispense(new Currency(remainder));
            }
        }
    }
    
}
