package com.dushi.designpatterns.singleton.FactoyMethod;

public class PackageFactory {
    public static Package createPackage(PackageCode packageCode){

        switch (packageCode){
            case SILVER:
                return new SilverPackage();
            case GOLD:
                return new GoldPackage();
            case PLATINUM:
                return new PlatinumPackage();
            default:
                return null;

        }
    }
}
