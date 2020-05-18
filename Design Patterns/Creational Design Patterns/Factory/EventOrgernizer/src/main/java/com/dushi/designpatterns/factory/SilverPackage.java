package com.dushi.designpatterns.factory;

public class SilverPackage extends Package {
    @Override
    protected void createPackage() {
        decorations.add(new BridalDeco());
    }
}
