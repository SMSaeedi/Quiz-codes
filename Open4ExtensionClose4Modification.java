package com.example.demo.SOLID;

public class Open4ExtensionClose4Modification {

            /*Eg.
            public class VehicleCalculation{
                public double calculationVehicle(Vehicle v){
                    if(v instanceof Car)
                        return v.getValue() * 0.8;
                    if(v instanceof Bike)
                        return v.getValue() * 0.5;
                }
            }*/
    // --> suppose we want to add another subclass called Trunk, we must modify the above class, instead of this we can code like below.
}

class Vehicle {

    double value;

    public double calculateValue() {
        return value;
    }
}

class Car extends Vehicle {
    @Override
    public double calculateValue() {
        value = 10;
        return value * 0.2;
    }
}

class Trunk extends Vehicle {
    @Override
    public double calculateValue() {
        value = 8;
        return value * 0.12;
    }
}

class Bike extends Vehicle {
    @Override
    public double calculateValue() {
        value = 5;
        return value * 0.5;
    }
}