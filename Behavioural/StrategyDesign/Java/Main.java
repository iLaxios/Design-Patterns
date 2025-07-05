package Behavioural.StrategyDesign.Java;

// strategy
interface PaymentStrategy {
    void pay(int amount);
}

// concrete strategy
class CardPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paying via card amount of " + amount);
    }
}

class PaypalPayment implements PaymentStrategy {

    public void pay(int amount) {
        System.out.println("Paying via Paypal amount of " + amount);
    }
}

// context which consumes the strategy
class ShoppingCart {

    PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String args[]) {

        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new PaypalPayment());
        cart.checkout(1000);
    }
}
