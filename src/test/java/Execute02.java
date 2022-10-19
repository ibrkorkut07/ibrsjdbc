import java.sql.*;

public class Execute02 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        Statement st = con.createStatement();

        String sql1= "SELECT country_name from countries where region_id=1";
        ResultSet rs1 = st.executeQuery(sql1);

        while (rs1.next()) {
            System.out.println(rs1.getString("country_name"));
        }

        String sql2 = "SELECT country_id, country_name from countries where region_id>2";
        ResultSet rs2 = st.executeQuery(sql2);

        while (rs2.next()) {
            System.out.println(rs2.getString("country_id")+"-->"+rs2.getString("country_name"));
        }

        // CREATE table workers2
        //(id char (5),
        //name VARCHAR2(50),
        //salary NUMBER(5),
        //constraint id4_pk primary key (id) );
        //
        //insert into workers2 values(10001, 'Ali Can', 12000);
        //insert into workers2 values(10002, 'Veli Han', 2000);
        //insert into workers2 values(10003, 'Mary Star', 7000);
        //insert into workers2 values(10004, 'Angie Ocean', 8500);
        //
        //SELECT * from workers2 where salary = (SELECT min(salary) FROM workers2);

        String sql3 = "SELECT * FROM workers2 WHERE salary = (SELECT min(salary) FROM workers2)";
        ResultSet rs3 = st.executeQuery(sql3);

        while (rs3.next()) {
            System.out.println(rs3.getString(1) + " - " + rs3.getString(2) + " - " + rs3.getInt(3));
        }
        con.close();
        st.close();
        rs1.close();
        rs2.close();
        rs3.close();
    }
    }




