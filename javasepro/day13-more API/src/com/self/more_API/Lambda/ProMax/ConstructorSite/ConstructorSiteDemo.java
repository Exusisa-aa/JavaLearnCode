package com.self.more_API.Lambda.ProMax.ConstructorSite;

public class ConstructorSiteDemo {

    public static void main(String[] args) {
//    CarCreator c = new CarCreator() {
//        @Override
//        public Car createCar(String name, int year) {
//            return new Car(name,year);
//        }
//    };

//    CarCreator c = (name,year) -> new Car(name,year);

        CarCreator c = Car::new;

        Car car = c.createCar("奔驰",2077);
        System.out.println(car);
    }
}
