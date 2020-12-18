import java.sql.SQLException;

public class AccountVerifier {

    public void verify(int accountNumber) throws AccountVerifierException{
        //sends accountNumber to Database manager which creates connection/queries etc
        DatabaseManager databaseManager = new DatabaseManager();
        try {
            //calls function to look for account in DB
            databaseManager.searchDBForAccount(accountNumber);
        } catch (SQLException sqlException) {
            //if exception occurs throws exception along with cause
            throw new AccountVerifierException("Error Occured while Accessing Database", sqlException);
        }

    }
    
}
