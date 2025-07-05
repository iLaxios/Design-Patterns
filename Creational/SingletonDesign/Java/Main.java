package Creational.SingletonDesign.Java;

class Logger {

    // expose just one instance
    private static volatile Logger myInstance = null;

    // privatise the constructor, 
    // so client cant access and create multiple objs
    private Logger() {}

    // create single instance
    public static Logger getInstance() {


        // making thread-safe singleton
        if(myInstance == null) {
            synchronized (Logger.class) {
                
                if(myInstance == null) {
                    myInstance = new Logger();
                }
            }
        }

        return myInstance;
    }

    public void log() {
        System.out.println("Logging");
    } 
}

public class Main {
    
    public static void main(String[] args) {
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log();
        logger2.log();

        System.out.println(logger1 == logger2);
        
    }
}
