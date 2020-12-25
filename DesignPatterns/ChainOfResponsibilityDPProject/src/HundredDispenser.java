public class HundredDispenser extends Dispenser {

    @Override
    public void dispense(Currency currency) {
        //checks if user input is not null
        if(currency != null) {
            int amount = currency.getAmount();
            int remainder = 0;
            //if user input is greater than or equal to 100 perform operation
            if(amount >= 100) {
                int count = amount/100;
                remainder = amount % 100;
                System.out.println("Number of hundred notes: " + count);
            } else {
                //if user input is less than 100 pass user input to successor
                successor.dispense(currency);
            }
            if(remainder > 0) {
                //if user input is greater than or equal to 100 and there is a remainder after calculations
                //calls successor and pass the new remaining value
                successor.dispense(new Currency(remainder));
            }
        }
    }
    
}
