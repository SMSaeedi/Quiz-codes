package com.example.demo.SOLID;

public class SingleResponsibility {
            /*Eg.
            public class vehicle{
                public void printData();
                public double calculateValues();
                public void addVehicleToDB();
            }*/
             /*--> this class has three responsibilities, we can separate the above class into three classes with separate responsibility
                  like below code*/
}

class PrintData {
    public void printData() {

    }
}

class calculateValues{
    public double calculateValues() {
        return 0;
    }
}

class addVehicleToDB{
    public void addVehicleToDB() {

    }
}