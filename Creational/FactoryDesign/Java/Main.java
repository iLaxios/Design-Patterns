package Creational.FactoryDesign.Java;

// common interface of choicy class
interface Payment {
    void pay(int amount);
} 


class PaymentFactory {


    public static Payment getPayment(String type) {

        if(type.equalsIgnoreCase("Paypal")) {
            return new Paypal();
        }

        if(type.equalsIgnoreCase("Stripe")) {
            return new Stripe();
        }

        if(type.equalsIgnoreCase("Razorpay")) {
            return new Razorpay();
        }

        throw new IllegalArgumentException("unknow type");
    }
}

// concrete class for each factory products
class Paypal implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("paying "+ amount +  " through paypal...");
    }
}

class Stripe implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("paying "+ amount +  " through Stripe...");
    }
}

class Razorpay implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("paying "+ amount +  " through Razorpay...");
    }
}


public class Main {
    
    public static void main(String args[]) {
        
        Payment payment = PaymentFactory.getPayment("Stripe");
        payment.pay(500);
    } 
}
