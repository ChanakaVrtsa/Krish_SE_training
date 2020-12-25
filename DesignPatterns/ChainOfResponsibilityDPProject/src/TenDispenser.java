public class TenDispenser extends Dispenser {

    @Override
    public void dispense(Currency currency) {
        //checks if user input is not null
        if(currency != null) {
            int amount = currency.getAmount();
            int remainder = 0;
            //if user input is greater than or equal to 10 perform operation
            if(amount >= 10) {
                int count = amount/10;
                remainder = amount % 10;
                System.out.println("Number of ten notes: " + count);
            } else {
                //if user input is less than 10 pass user input to successor
                successor.dispense(currency);
            }
            if(remainder > 0) {
                //if user input is greater than or equal to 10 and there is a remainder after calculations
                //calls successor and pass the new remaining value
                successor.dispense(new Currency(remainder));
            }
        }
    }
    
}
