package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		//Department obj = new Department(1, "Books");
		
		//Seller seller = new Seller(21, "Douglas", "teste@gmail.com", new Date(), 2000.00, obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
	}

}