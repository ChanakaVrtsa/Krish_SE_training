import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class StudentDao {

    DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();
    Connection connection = databaseManager.getConnection();

    //takes in student object and adds its values to DB
    //returns the number of rows affected
    public int addStudent(Student student) {

        int executedRows= 0;
        try {
            String query  = "INSERT INTO studentdetails(student_name, student_class) VALUES (?, ?)"; 
            PreparedStatement preparedStatement  = connection.prepareStatement(query); 
            preparedStatement.setString(1, student.getStudentName()); 
            preparedStatement.setString(2, student.getStudentClass()); 
            executedRows = preparedStatement.executeUpdate(); 
        } catch (SQLException sqlException) {
            System.out.println("Cannot add entry to Database");
        }

        return executedRows;
    }

    //takes in student id and removes its row from DB
    public void deleteStudent(int id) {

        try {
            String query = "DELETE FROM studentdetails WHERE id =?"; 
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            preparedStatement.setInt(1, id); 
            preparedStatement.executeUpdate(); 
        } catch (SQLException sqlException) {
            System.out.println("Cannot delete entry from Database");
        }
    }
    
    //takes in student id and returns its values to DB
    public Student getStudent(int id) {

        Student student = new Student(); 

        try {
            String query = "SELECT * from studentdetails WHERE id =?"; 
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            preparedStatement.setInt(1, id); 
            //stores values returned in a resultset
            ResultSet resultSet = preparedStatement.executeQuery(); 
  
         //until resultset has elements within it, executes the while loop    
         while (resultSet.next()) { 
             student.setStudentID(resultSet.getInt("id")); 
             student.setStudentName(resultSet.getString("student_name")); 
             student.setStudentClass(resultSet.getString("student_class")); 
         } 
        } catch (SQLException sqlException) {
            System.out.println("Cannot retrieve entry from Database");
        }
        
        return student;
    }

    //takes in student object and adds its updated values to DB
    public void updateStudent(Student student) { 
  
        try {
            String query = "UPDATE studentdetails SET student_name =?, student_class =? WHERE id =?"; 
            PreparedStatement preparedStatement = connection.prepareStatement(query); 
            preparedStatement.setString(1, student.getStudentName()); 
            preparedStatement.setString(2, student.getStudentClass()); 
            preparedStatement.setInt(3, student.getStudentID()); 
            preparedStatement.executeUpdate(); 
        } catch (SQLException sqlException) {
            System.out.println("Cannot update entry to Database");
        }
    } 
   
}
