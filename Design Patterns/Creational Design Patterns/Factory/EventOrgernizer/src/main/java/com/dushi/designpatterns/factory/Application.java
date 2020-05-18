package com.dushi.designpatterns.factory;

public class Application {
    public static void main(String[] args) {

        Package aPackage=PackageFactory.createPackage(PackageCode.SILVER);
        System.out.println(aPackage);

        Package aPackage1=PackageFactory.createPackage(PackageCode.GOLD);
        System.out.println(aPackage1);

        Package aPackage2=PackageFactory.createPackage(PackageCode.PLATINUM);
        System.out.println(aPackage2);
    }
}
