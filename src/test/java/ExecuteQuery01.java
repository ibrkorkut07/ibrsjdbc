import java.sql.*;

public class ExecuteQuery01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        Statement st = con.createStatement();

        // Find the name and salary of the worker whose salary the second highest from the workers2 table
        // way 1:
        String sql1 = "SELECT name, salary FROM workers2 ORDER BY salary DESC 1 ROW FETCH NEXT 1 ROW ONLY";
        ResultSet rs1 = st.executeQuery(sql1);
        while (rs1.next()) {
            System.out.println(rs1.getString("name") + " --> " + rs1.getInt("salary"));
        }
        // way 2:
        String sql2 = "SELECT name, salary from workers2 where salary = (SELECT max(salary) from workers2 where salary < (SELECT max(salary) from workers2))";
        ResultSet rs2 = st.executeQuery(sql2);
        while (rs2.next()) {
            System.out.println(rs2.getString("name") + " --> " + rs2.getInt("salary"));
        }

        /* ............................. */
        // create table companies (
        //company_id varchar2(5),
        //company varchar2(20),
        //number_of_employees number(6));
        //
        //insert into companies values(100, 'IBM', 12000);
        //insert into companies values(101, 'GOOGLE', 18000);
        //insert into companies values(102, 'MICROSOFT', 10000);
        //insert into companies values(103, 'APPLE', 21000);

        /* ............................. */

        con.close();
        st.close();
        rs1.close();
        rs2.close();
    }
}
