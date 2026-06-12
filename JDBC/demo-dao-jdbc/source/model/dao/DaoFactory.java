package source.model.dao;

import source.db.DB;
import source.model.dao.impl.DepartmentDaoJDBC;
import source.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao creatDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
