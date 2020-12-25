public class Application {
    public static void main(String[] args) {

        Student student = new Student();
        StudentDao studentDao = new StudentDao();

        student.setStudentName("Jay");
        student.setStudentClass("Grade 10");

        //add to DB
        System.out.println("Number of executed rows: " + studentDao.addStudent(student));

        //delete from DB 
        studentDao.deleteStudent(5);

        //read from DB
        student = studentDao.getStudent(2); 
        System.out.println(student.getStudentID() + " "+ student.getStudentName() + " "
        + student.getStudentClass()); 

        //update to DB 
        student = studentDao.getStudent(6); 
        student.setStudentName("Jason"); 
        studentDao.updateStudent(student); 
        System.out.println(student.getStudentID() + " "+ student.getStudentName() + " "
        + student.getStudentClass()); 

    }
}
