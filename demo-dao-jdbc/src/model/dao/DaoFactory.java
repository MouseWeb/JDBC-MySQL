package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	// è um a macete para não precisar expor a IMPL, deixando somente a interface.
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
	
}
