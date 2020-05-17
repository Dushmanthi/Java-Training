package com.dushi.designpatterns.bulder;

public class Application {
    public static void main(String[] args) {
        CarTelescopic1 carTelescopic1= new CarTelescopic1("full");
        System.out.println(carTelescopic1);

        CarTelescopic2 carTelescopic2= new CarTelescopic2("empty");
        System.out.println(carTelescopic2);

        //using builder pttern
        Car.Builder builder=new Car.Builder("Full");
        Car car = builder.dropOffLocation("Location Assistance").roadAssistance("yes").build();
        System.out.println(car);
    }
}
