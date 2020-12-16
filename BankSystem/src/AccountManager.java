public class AccountManager {
    
    public void VerifyAccount(int accountNumber) throws AccountManagerException{
        //AccountVerifier class handles account verification function
        AccountVerifier accountVerifier = new AccountVerifier();
        try {
            //calls verifier method
            accountVerifier.verifier(accountNumber);  
        } catch (AccountVerifierException msg) {
            //if exception occurs throws exception along with cause
            throw new AccountManagerException("Error Verifying Account", msg);
        }

    }

    public void withdrawMoney(int amount){
        //MoneyHandler class handles all money related functions
        MoneyHandler moneyHandler = new MoneyHandler();
        //checks whether enoughBalance is there
        moneyHandler.checkSufficientFunds(amount);
    }
}
