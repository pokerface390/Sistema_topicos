package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/gasolinera_mia";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final Logger LOGGER = Logger.getLogger(MySQLConnection.class.getName());

    // Obtener una conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Driver no encontrado", e);
            throw new SQLException("Driver no encontrado", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al conectar con la base de datos", e);
            throw e;
        }
    }

    // Método para cerrar una conexión
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error al cerrar la conexión", e);
            }
        }
    }

    // Método para cerrar un Statement
    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error al cerrar el Statement", e);
            }
        }
    }

    // Método para cerrar un ResultSet
    public static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error al cerrar el ResultSet", e);
            }
        }
    }
}
