package source.application;

import java.util.List;

import source.model.dao.DaoFactory;
import source.model.dao.SellerDao;
import source.model.entities.Department;
import source.model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== Test 1: seller findById ====");
        Seller seller = sellerDao.findById(2);
        System.out.println(seller);

        System.out.println("\n==== Test 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartmet(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        
    }
}
