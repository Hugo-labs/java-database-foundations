import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                "INSERT INTO seller "
                + "(Name, Email, Birthdate, BaseSalary, DepartmentId) "
                +  "VALUES "
                + "(?, ?, ?, ?, ?)",
                java.sql.Statement.RETURN_GENERATED_KEYS);

                st.setString(1, "Carl Purple");
                st.setString(2, "carlp@gmail.com");
                java.time.LocalDate date = java.time.LocalDate.parse("22/10/1990", fmt);
                st.setDate(3,  java.sql.Date.valueOf(date));
                st.setDouble(4, 4998.80);
                st.setInt(5, 2);

                int rowsAffected = st.executeUpdate();

                if (rowsAffected > 0) {
                    ResultSet rs = st.getGeneratedKeys();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        System.out.println("Done! Id = " + id);
                    }
                }
                else {
                    System.out.println("No rows affected");
                }
            }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
