package br.com.manzatech.agenda.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection get() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = null;
			StringBuilder url = new StringBuilder("jdbc:");
			url.append(Settings.DRIVER).append("://");
			url.append(Settings.HOST);
			if (!Settings.PORT.isEmpty()) {
				url.append(":").append(Settings.PORT);
			}
			if (!Settings.QUERY_STRING.isEmpty()) {
				url.append(Settings.QUERY_STRING);
			}
			url.append("/").append(Settings.DBNAME);
			String user = Settings.USERNAME;
			String pass = Settings.PASSWORD;

			conn = DriverManager.getConnection(url.toString(), user, pass);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
}
