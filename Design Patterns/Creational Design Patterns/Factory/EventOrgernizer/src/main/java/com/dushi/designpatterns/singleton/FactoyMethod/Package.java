package com.dushi.designpatterns.singleton.FactoyMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class Package {
    protected List<Decoration> decorations = new ArrayList<Decoration>();

    public Package(){
        createPackage();
    }

    protected abstract void createPackage();

    @Override
    public String toString() {
        return "Packages{" +
                "decorations=" + decorations +
                '}';
    }
}
