public class FundsHandler {

    public void checkSufficientFunds(int amount){
        //passes the value to DatabaseManager class to check in DB; whether sufficient amount is there
        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.searchDBForFunds(amount);
    }
    
}
