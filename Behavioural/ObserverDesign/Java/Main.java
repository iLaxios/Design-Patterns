package Behavioural.ObserverDesign.Java;

import java.util.*;

// observer
interface Investor {
    void update(String stock, Double price);
}

// subject
interface StockExchange{
    void addInvestor(Investor investor);
    void removeInvestor(Investor investor);
    void notifyAllSubscribers(String stock, Double price);
}

class StockMarket implements StockExchange {

    private List<Investor> investors = new ArrayList<>();
    private Map<String, Double> stocks = new HashMap<>();

    public void setPrice(String stock, Double price) {
        stocks.put(stock, price);
        notifyAllSubscribers(stock, price);
    }

    @Override
    public void addInvestor(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void removeInvestor(Investor investor) {
        investors.remove(investor);
    }
    
    @Override
    public void notifyAllSubscribers(String stock, Double price) {
        for(Investor investor : investors) {
            investor.update(stock, price);
        }
    }
}

class PhoneInvestor implements Investor {

    String name;
    Map<String, Double> stocks;

    PhoneInvestor(String name) {
        this.name = name;
        stocks = new HashMap<>();
    }    

    public void update(String stock, Double price) {
        System.out.println(name + " updated with new stock alert! for " + stock + " " + price);
        stocks.put(stock, price);
    }

} 

public class Main {
    
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        
        PhoneInvestor AlexInvestor = new PhoneInvestor("Alex");
        PhoneInvestor MikeInvestor = new PhoneInvestor("Mike");
        stockMarket.addInvestor(AlexInvestor);
        stockMarket.addInvestor(MikeInvestor);

        stockMarket.setPrice("NVDA", 100.12);
        stockMarket.setPrice("TSLA", 312.12);
    }
}
