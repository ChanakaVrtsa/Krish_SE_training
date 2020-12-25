import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static DatabaseManager databaseManager;
    private static Connection connection;
    private String url = "jdbc:mysql://localhost:3306/student";
    private String username = "root";
    private String password = "";

    //made private so new instances cannot be created
    private DatabaseManager() {

        //prevents manual invoking
        if (databaseManager != null) {
            throw new RuntimeException("Invoke getDatabaseManager to get instance");
        }
    }

    public static DatabaseManager getDatabaseManager() {

        //if DatabaseManager is not created, creates a new instance
        //if not null, return the existing instance
        if (databaseManager == null) {
            //creates a lock to make instantiation thread safe
            //only one thread can access at a single time
            synchronized (DatabaseManager.class) {
                if (databaseManager == null) {
                    databaseManager = new DatabaseManager();
                }
            }
        }
        return databaseManager;
    }

    //returns new connection
    public Connection getConnection() {

        if (connection == null) {
            //synchronized to make connection creation thread safe
            synchronized (DatabaseManager.class) {
                if (connection == null) {
                    try {
                        //loads MySQL JDBC Driver
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        //creates new connection by passing DB URL, username and password
                        connection = DriverManager.getConnection(url, username, password);
                    } catch (ClassNotFoundException classNotFoundException) {
                        System.out.println("Cannot load mySQL Driver");
                    } catch (SQLException sqlException ) {
                        System.out.println("Cannot make connection to DB");
                    }
                }
            }
        }
        return connection;
    }
}
