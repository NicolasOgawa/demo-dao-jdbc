package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n==== TEST 1: Department findById ====");
		System.out.println("Enter id for consult: ");
		int idConsult = sc.nextInt();
		Department department = departmentDao.findById(idConsult);
		System.out.println(department);

		System.out.println("\n==== TEST 2: Department update ====");
		department = departmentDao.findById(1);
		department.setName("Computers");
		departmentDao.update(department);
		System.out.println("Update completed");

		System.out.println("\n==== TEST 3: Department insert ====");
		Department newDep = new Department(null, "Tablets");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());

		System.out.println("\n==== TEST 4: Department delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		System.out.println("\n==== TEST 3: seller findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

	}
}