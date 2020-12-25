public abstract class Dispenser {

    protected Dispenser successor;

    //holds successor object
    public void setSuccessor(Dispenser successor) {
        this.successor = successor;
    }

    //overriden in each subclass to perform class specific calculations
    //takes in currency object which has a method to get user entered amount
    public abstract void dispense(Currency currency);
    
}
