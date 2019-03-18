package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	// Referências: https://www.ibm.com/support/knowledgecenter/en/SSGMCP_5.4.0/product-overview/acid.html  
	//   API: 
	//      - setAutoCommit(false) 
	//      - commit() 
	//      - rollback()
	
	public static void main(String[] args) {

		Connection conn = null;

		Statement st = null;

		try {

			conn = DB.getConnection();

			conn.setAutoCommit(false);

			st = conn.createStatement();

			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 8090 WHERE DepartmentId = 1");

			// Simula error
			/*int x = 1;
			if (x < 2) {

				throw new SQLException("Fake error");

			}*/
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 4090 WHERE DepartmentId = 2");

			conn.commit();

			System.out.println("rows1 = " + rows1);
			System.out.println("rows2 = " + rows2);

		}

		catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transação não foi concluida (Rollback): " + e.getMessage());

			} 

			catch (SQLException e1) {
				throw new DbException("Erro quando tentava realizar o (Rollback): " + e1.getMessage());

			}

		} 

		finally {
			DB.closeStatement(st);
			DB.closeConnection();

		}

	}

}