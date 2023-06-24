import CollectionFiles.CommandData;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import org.postgresql.Driver;

public class DataBaseConnector {
    private static final String URL = ("jdbc:postgresql://localhost/MusicBandManagerApp");
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1205";

    public static void getConnection() throws SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Connection connection;
        Class.forName("org.postgresql.Driver");
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            CommandData.stm = connection.createStatement();
            CommandData.stm1 = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к базе данных");
            System.out.println(e.getErrorCode());
            throw e;
        }
    }
}
