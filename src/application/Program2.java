package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TEST 1: findById =====");
		Department dep = depDao.findById(1);
		System.out.println(dep);
		 
		System.out.println("\n===== TEST 2: findAll =====");
		List<Department> list = depDao.findAll();
		list.forEach(System.out::println);
	
		System.out.println("\n===== TEST 3: insert =====");
		dep = new Department(5, "Teste");
	//	depDao.insert(dep);
		System.out.println("Inserted! New id: " + dep.getId());
	
		System.out.println("\n===== TEST 4: update =====");
		System.out.print("Enter id to update: ");
		int id = sc.nextInt();
		dep = depDao.findById(id);
		System.out.print("Insert the new name: ");
		sc.nextLine();
		dep.setName(sc.nextLine());
		depDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("\n===== TEST 5: delete =====");
		System.out.print("Enter id for delete test: ");
		id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Done! Id " + id + " sucessfully deleted!");
		
		
		sc.close();
	}

}
