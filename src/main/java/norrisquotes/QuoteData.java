package norrisquotes;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuoteData {

    private Logger LGR = Logger.getLogger(QuoteData.class.getName());

    public ArrayList<Quote> getQuotes(){

        ArrayList<Quote> quotes = new ArrayList<>();

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");

            DataSource ds = (DataSource) envContext.lookup("jdbc/c9");
            con = ds.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM Quotes");

            while(rs.next()){
                Quote tmpQuote = new Quote(rs.getString(3));
                quotes.add(tmpQuote);
            }
        } catch(SQLException ex){
            LGR.log(Level.SEVERE, ex.getMessage(), ex);
        } catch(NamingException nmx){
            LGR.log(Level.SEVERE, nmx.getMessage(), nmx);

        } finally{
            try{
                if(rs != null) rs.close();
                if(st != null) st.close();
                if(con != null) con.close();
            } catch(SQLException ex){
                LGR.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return quotes;
    }
}