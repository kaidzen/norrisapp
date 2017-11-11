package norrisquotes;

public class Quote {
    private String quote;

    public Quote(String quote){
        this.setQuote(quote);
    }

    public String getQuote(){
        return this.quote;
    }

    public void setQuote(String quote){
        this.quote = quote;
    }
}
