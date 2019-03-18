package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {
	
	
	
	// Statement = serve para monta um sql e recuperar os dados do banco.
	// ResultSet = Representa um (Objeto) contendo o resultado da consulta do banco de dados.
	//             - Observação: O objeto ResultSet contém os dados armazenados na forma de tabela.
	// 			   - O objeto ResultSet tem operações para posicionar na tabela de resultado.

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			conn = DB.getConnection();
			st = conn.createStatement();
			
			rs = st.executeQuery("select * from department");

			while (rs.next()) {
				System.out.println(rs.getInt("Id") + " - " + rs.getString("Name"));

			}

		}

		catch (SQLException e) {
			e.printStackTrace();

		}

		finally {

			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}
}