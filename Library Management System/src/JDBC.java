import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymdb", "root", "90952");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from employee");

            //display data
            while (resultSet.next()) {
                //what we want to show
                System.out.println(resultSet.getString("firstname"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
