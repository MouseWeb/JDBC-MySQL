package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;
import model.entities.Department;

public class Program {

	public static void main(String[] args) {

		//Department obj = new Department(1, "Books");
		
		//Seller seller = new Seller(21, "Douglas", "teste@gmail.com", new Date(), 2000.00, obj);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);

		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
	    list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);

		}
	}

}