package source.application;

import source.model.dao.DaoFactory;
import source.model.dao.SellerDao;
import source.model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("==== Test 1: seller findById ====");
        Seller seller = sellerDao.findById(2);
        
        System.out.println(seller);
    }
}
