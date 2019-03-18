package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
	//    ---------- Consultando dados ---------- (Project JDBC1)
	// Statement = serve para monta um sql e recuperar os dados do banco.
	// ResultSet = Representa um (Objeto) contendo o resultado da consulta do banco de dados.
	//             - Observação: O objeto ResultSet contém os dados armazenados na forma de tabela.
	// 			   - O objeto ResultSet tem operações para posicionar na tabela de resultado.
	
	//    ---------- Inserindo dados ---------- (Project JDBC2)
	// API:  PreparedStatement = é um (Objeto) que permite monta a consulta SQL deixando os parametros para colocar depois.
	//       executeUpdate =
	//       Statement.RETURN_GENERATED_KEYS = é para permitir que recupere o (ID) do novo objeto inserido 
	//       getGeneratedKeys = 

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;

		try {

			conn = DB.getConnection();

			// EXAMPLE 1:
			st = conn.prepareStatement(

					"INSERT INTO seller "
							+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
							+ "VALUES "
							+ "(?, ?, ?, ?, ?)",

					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, "Douglas Coelho");
			st.setString(2, "douglas@mouseweb.com.br");
			st.setDate(3, new java.sql.Date(sdf.parse("17/04/1993").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);

			// EXAMPLE 2:

			/* st = conn.prepareStatement(

			 "insert into department (Name) values ('D1'),('D2')",

			 Statement.RETURN_GENERATED_KEYS); */

			// a variavel (rowsAffected) recebe o resultado do executeUpdate e informa a quantidade de linhas inseridas no BD.
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {			
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Feito! Id: " + id );

				}
				// Mostra a quantidade de linhas afetadas.
				System.out.println( "Linha afetada: " + rowsAffected );

			}

			else {
				System.out.println("Nenhuma linha afetada!");

			}

		}

		catch (SQLException e) {
			e.printStackTrace();

		}

		catch (ParseException e) {
			e.printStackTrace();

		}

		finally {
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}
	
}