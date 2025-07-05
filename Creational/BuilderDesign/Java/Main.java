package Creational.BuilderDesign.Java;


class Car {

    // required attributes
    private final String model;
    private final String engine;


    // optional attributes
    private final Boolean hasGPS;
    private final Boolean hasSunroof;
    private final String transmission;


    public static class Builder {

        // required attributes
        private final String model;
        private final String engine;


        // optional attributes
        private Boolean hasGPS = false;
        private Boolean hasSunroof = false;
        private String transmission = "Manual";

        public Builder(String model, String engine) {
            this.model = model;
            this.engine = engine;
        }

        public Builder hasGPS(Boolean hasGPS) {
            this.hasGPS = hasGPS;
            return this;
        }

        public Builder hasSunroof(Boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public Builder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

        
    }

    public Car(Builder builder) {
        this.engine = builder.engine;
        this.model = builder.model;
        this.hasGPS = builder.hasGPS;
        this.hasSunroof = builder.hasSunroof;
        this.transmission = builder.transmission;
    } 

    @Override
    public String toString() {
        return "Car [model=" + model + ", engine=" + engine + ", hasGPS=" + hasGPS + ", hasSunroof=" + hasSunroof
                + ", transmission=" + transmission + "]";
    }

}


public class Main {

    public static void main(String args[]) {

        Car myCar = new Car.Builder("Mustang", "V8").transmission("Automatic").build();
        System.out.println(myCar);
    }
}