package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// cont�m os m�todos staticos que conecta e desconecta a conex�o.
public class DB {

	private static Connection conn = null;

	// M�todo que conecta com banco de dados
	public static Connection getConnection() {

		if (conn == null) {

			try {

				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);

			}

			catch (SQLException e) {
				throw new DbException(e.getMessage());

			}

		}

		return conn;

	}

	// M�todo fecha a conex�o com banco de dados
	public static void closeConnection() {
		if (conn != null) {

			try {

				conn.close();

			} catch (SQLException e) {
				throw new DbException(e.getMessage());

			}

		}

	}

	// Ler o arquivo com os dados da conex�o com banco de dados.
	private static Properties loadProperties() {

		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;

		}

		catch (IOException e) {
			throw new DbException(e.getMessage());

		}

	}

}