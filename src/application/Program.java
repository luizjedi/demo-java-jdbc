package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller = sellerDao.findById(3);
				
		System.out.println("=== TEST 1: seller findById ===");
		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartmentId ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Hanna", "hanna@gmail.com", new Date(), 6300.0, new Department(1, "Computers"));
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		seller.setEmail("martha@gmail.com");
		sellerDao.update(seller);
		System.out.print("Updated! New name = " + seller.getName());
		System.out.print(", New email = " + seller.getEmail() + "\n");
		
		System.out.println("\n=== TEST 6: seller deleteById ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Done! Id " + id + " sucessfully deleted!");
		
		sc.close();
	}

}
