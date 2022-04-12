import java.sql.*;

public class JDBC {
    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymdb", "root", "90952");
            //STATEMNT OBJECT TO REPRESENT THE ACTUAL STATEMENT
            Statement statement = connection.createStatement();
            //execute statement that gets result
            ResultSet resultSet = statement.executeQuery("select * from employee");
            //resultSet = statement.executeQuery("SELECT * FROM lastname;");

            //display data
            while (resultSet.next()){
                String name=resultSet.getString(2);
                System.out.println(name);
            }
            /*while (resultSet.next()) {
                //what we want to show
                System.out.println(resultSet.getString("firstname"));
            }
        } catch (Exception e){
            e.printStackTrace();*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //inserting Data

    }
}
