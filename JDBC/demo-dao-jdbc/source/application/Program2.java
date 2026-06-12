package source.application;

import java.util.List;
import java.util.Scanner;

import source.model.dao.DaoFactory;
import source.model.dao.DepartmentDao;
import source.model.entities.Department;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        DepartmentDao departmentDao = DaoFactory.creatDepartmentDao(); 

        System.out.println("==== Test 1: department findById ====");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("\n==== Test 2: department findAll ====");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n==== Test 3: department insert ====");
        Department newDepartment = new Department(null, "Food");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Id = " + newDepartment.getId());

        System.out.println("\n==== Test 4: department update ====");
        Department dep2 = departmentDao.findById(5);
        dep2.setName("Frozen Food");
        departmentDao.update(dep2);
        System.out.println("Update complete");

        System.out.println("\n==== Test 5: department deleteById ====");
        System.out.print("Enter Id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();
    }
}
