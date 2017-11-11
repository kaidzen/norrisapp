package norrisquotes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuoteServlet extends HttpServlet {
    private Logger LGR = Logger.getLogger(QuoteServlet.class.getName());
    private final static long serialVersionUID = Long.decode(UUID.randomUUID().toString());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html><head></head><body><h1>Here is the Qoutes...</h1>");

        QuoteData quotesData = new QuoteData();
        ArrayList<Quote> quotes = quotesData.getQuotes();
        quotes.forEach(quote -> out.println("<div>"+quote.getQuote()+"</div>"));

        out.println("</body></html>");
        LGR.log(Level.INFO, "Reading the Quotes");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
