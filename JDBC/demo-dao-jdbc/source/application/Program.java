package source.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import source.model.dao.DaoFactory;
import source.model.dao.SellerDao;
import source.model.entities.Department;
import source.model.entities.Seller;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        Department obj = new Department(1, "Books");

        Seller seller = new Seller(1, "Bob Brow", "bob@gmail", LocalDate.parse("12/06/1998", fmt), 3449.9, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(obj);
        System.out.println(seller);
    }
}
