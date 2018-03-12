package br.com.manzatech.agenda.database;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		try {
			Connection c = ConnectionFactory.get();
			System.out.println("Conexão aberta!");
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
