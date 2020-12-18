public class AccountManager {
    
    public void verifyAccount(int accountNumber) throws AccountManagerException{
        //AccountVerifier class handles account verification function
        AccountVerifier accountVerifier = new AccountVerifier();
        try {
            //calls verify method to do verification
            accountVerifier.verify(accountNumber);  
        } catch (AccountVerifierException accountVerifierException) {
            //if exception occurs throws exception along with cause
            throw new AccountManagerException("Error Verifying Account", accountVerifierException);
        }

    }

    public void withdrawMoney(int amount){
        //FundsHandler class handles all money related functions;checkfunds,withdraw etc
        FundsHandler fundsHandler = new FundsHandler();
        //checks whether enoughBalance is there
        fundsHandler.checkSufficientFunds(amount);
    }
}
