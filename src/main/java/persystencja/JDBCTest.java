package persystencja;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    private static void createTableForStudent() throws SQLException, ClassNotFoundException {
        Connection connection=AppH2.getConnection();
        Statement statement=connection.createStatement();
        String query="CREATE TABLE STUDENTS(id int primary key,name varchar(255))";
        statement.execute(query);
        connection.commit();
    }
    private static void insertStudent(Student student) throws SQLException, ClassNotFoundException {
        Connection connection=AppH2.getConnection();
        Statement statement=connection.createStatement();
        String query="INSERT INTO STUDENTS VALUES("+
                student.getId()+",\'"+student.getName()+"\')";
        statement.execute(query);
        connection.commit();
    }
    public static List<Student> getStudent() throws SQLException, ClassNotFoundException {
        List<Student> students=new ArrayList<>();
        Connection connection=AppH2.getConnection();
        Statement statement=connection.createStatement();
        String query="SELECT * FROM STUDENTS";
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            int id=resultSet.getInt("id");
            String name=resultSet.getString("name");
            students.add(new Student(id,name));
        }
        return students;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createTableForStudent();
        Student student1=new Student(1,"Jacek");
        Student student2=new Student(2,"Placek");
        insertStudent(student1);
        insertStudent(student2);
        List<Student> studentList=getStudent();
        for (Student st:studentList
             ) {
            System.out.println(st);
        }
    }
}
