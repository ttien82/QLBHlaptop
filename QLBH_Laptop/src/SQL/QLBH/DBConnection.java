package SQL.QLBH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
private static final String DB_URL = "jdbc:sqlserver://DESKTOP-IKTE16D\\SQLEXPRESS:1433;databaseName=QuanLyBanHangLaptop;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa"; 
    private static final String PASS = "123456"; 
    
    private static Connection connection = null;

    // Phương thức để lấy kết nối
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Đăng ký driver
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
                // Thiết lập kết nối
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Kết nối đến SQL Server thành công!");
                
            } catch (ClassNotFoundException e) {
                System.err.println("Không tìm thấy Driver JDBC.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Lỗi kết nối database:");
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    // Phương thức để đóng kết nối
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Đã đóng kết nối đến SQL Server.");
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối:");
                e.printStackTrace();
            }
        }
    }
    
    // Phương thức kiểm tra kết nối (tùy chọn)
    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            // Có thể thực hiện một số thao tác kiểm tra tại đây
            // ...  // Có thể thực hiện một số thao tác kiểm tra tại đây
            // .
            closeConnection();
        }
    }
    
}
