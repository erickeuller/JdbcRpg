import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by erick on 01/12/16.
 */
public class DataEngine {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/JdbcRpg";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "eulleropelt";

	private Connection connection;
	private Statement statement;

	public void connect() throws Exception {
		Class.forName(JDBC_DRIVER);
		connection = DriverManager.getConnection(DB_URL, USER, PASS);
		statement = connection.createStatement();
	}

	public ResultSet executeQuery(String sql) throws Exception {
		return statement.executeQuery(sql);
	}
}
