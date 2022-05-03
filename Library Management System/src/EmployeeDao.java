import java.sql.*;

public interface EmployeeDao {
    Connection getConnect();
    public void getAllEmployee() throws SQLException;
    public void deleteEmployee() throws SQLException;
    public void insertEmployee() throws SQLException;
    public void updateEmployee() throws SQLException;

    public  void getAllBooks()throws SQLException;
    public void deleteBook() throws SQLException;
    public void insertBook_bookCount() throws SQLException;
    public void updateBook() throws SQLException;
}
