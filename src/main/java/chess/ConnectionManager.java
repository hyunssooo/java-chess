package chess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static Connection getConnection() {
        Connection con = null;
        String server = "localhost";
        String database = "chess";
        String userName = "zino";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! JDBC Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", userName, password);

            System.out.println("정상적으로 연결되었습니다.");
        } catch (SQLException e) {
            throw new IllegalArgumentException("드라이버 연결 오류");
        }

        return con;
    }

}

