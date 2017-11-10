import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDb{
    public static void main(String[] args){
        
        Logger LGR = Logger.getLogger(TestDb.class.getName());
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        String url = "jdbc:mysql://localhost:3306/c9";
        String user = "kaidzen";
        String pass = "";
        
        try{
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Quotes");
            
            while(rs.next()){
                System.out.println(rs.getString(2)+ " -- " +rs.getString(3));
            }
            LGR.log(Level.INFO, "Connected to DB properly");
        } catch(SQLException ex){
            LGR.log(Level.SEVERE, ex.getMessage(), ex);
        } finally{
            try{
                if(rs != null) rs.close();
                if(st != null) st.close();
                if(con != null) con.close();
            } catch(SQLException ex){
                LGR.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
}