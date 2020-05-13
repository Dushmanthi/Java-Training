package com.dushi.designpatterns.singleton.FactoyMethod;

public class GoldPackage extends Package {
    @Override
    protected void createPackage() {
        decorations.add(new BridalDeco());
        decorations.add(new BridesMaidDeco());
    }
}
