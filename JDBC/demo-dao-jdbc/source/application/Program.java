package source.application;

import source.model.dao.DaoFactory;
import source.model.dao.SellerDao;
import source.model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(2);
        
        System.out.println(seller);
    }
}
