import java.sql.SQLException;

public class DatabaseManager {
    int sampleAccountNumber= 112211;
    int funds;

    public void searchDBForAccount(int accountNumber) throws SQLException{
        //sample method that throws an SQL Exception
        if(sampleAccountNumber!=accountNumber){
            throw new SQLException("Cannot Establish Connection");
        }
    }

    //sample method that throws an Arithmetic Exception
    public void searchDBForFunds(int amount){
            funds = amount/0;
    }
    
}
