public class Application {
    public static void main(String[] args) {
        //creates new BankAccountBuilder object
        BankAccount.BankAccountBuilder bankAccountBuilder = 
        new BankAccount.BankAccountBuilder("John", "98989898v", "Colombo, Sri lanka");
        
        //calls methods occupation,branch,medianIncome and build method
        //assign returned object to bankAccount instance
        BankAccount bankAccount = 
        bankAccountBuilder.occupation("Engineer").branch("Colombo").medianIncome(50000).build();
        bankAccount.displayAccountDetails();
    }
}
