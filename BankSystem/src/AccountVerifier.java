import java.sql.SQLException;

public class AccountVerifier {

    public void verifier(int accountNumber) throws AccountVerifierException{
        //sends accountNumber to Database manager which creates connection/queries etc
        DatabaseManager dbManager = new DatabaseManager();
        try {
            //calls searchDB function of DatabaseManager class
            dbManager.searchDBForAccount(accountNumber);
        } catch (SQLException msg) {
            //if exception occurs throws exception along with cause
            throw new AccountVerifierException("Error Occured while Accessing Database", msg);
        }

    }
    
}
