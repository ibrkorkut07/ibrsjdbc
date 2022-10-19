import java.sql.*;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        Statement st = con.createStatement();
        st.execute("CREATE TABLE workers (worker_id CHAR(3), worker_name VARCHAR2(50), worker_salary NUMBER(7,2))");

        // 2.Example: Alter table by adding worker_address column into the workers table
        st.execute("ALTER table workers add worker_address VARCHAR2(50)");
        // st.execute("DROP table workers");
        String sql2 = "drop table workers";
        // st.execute(sql2);

        con.close();
        st.close();


    }
}


