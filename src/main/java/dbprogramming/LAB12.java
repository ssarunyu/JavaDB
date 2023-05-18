package dbprogramming;

import dbprogramming.Dbprogramming;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//เพิ่มข้อมูลโดยใช้ PreparedStatement
public class LAB12 {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "Angle#10555";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, username, password);
            String sql = "insert into student(studentID, firstname, lastname, email, deptID)"
                    + "values(?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, "111111");
            preparedStatement.setString(2, "Murray");
            preparedStatement.setString(3, "Konami");
            preparedStatement.setString(4, "murray.kona@gmail.com");
            preparedStatement.setString(5, "IT");
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dbprogramming.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dbprogramming.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
