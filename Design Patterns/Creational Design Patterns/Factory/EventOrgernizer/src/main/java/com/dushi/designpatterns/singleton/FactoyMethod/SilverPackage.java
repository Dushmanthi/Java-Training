package com.dushi.designpatterns.singleton.FactoyMethod;

public class SilverPackage extends Package {
    @Override
    protected void createPackage() {
        decorations.add(new BridalDeco());
    }
}
