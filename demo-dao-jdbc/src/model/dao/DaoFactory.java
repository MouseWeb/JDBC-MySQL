package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	// � um a macete para n�o precisar expor a IMPL, deixando somente a interface.
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
	
}
