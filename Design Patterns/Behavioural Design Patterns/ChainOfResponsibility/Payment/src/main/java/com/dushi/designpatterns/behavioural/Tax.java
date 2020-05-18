package com.dushi.designpatterns.behavioural;

public class Tax extends Handler {

    public double applyTax(Invoice invoice) {
        return successor.applyTax(invoice);
    }
}
