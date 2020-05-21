package com.dushi.designpatterns.memento;

import java.util.Stack;

//who hold the state of previous object
// as stack(last in first out)
public class CareTaker {
    Stack<Cart.CartMemento> history = new Stack<Cart.CartMemento>();

    public void save(Cart cart){
        history.push(cart.save());
    }

    public void revert(Cart cart){
        if(!history.isEmpty()){
            cart.revert(history.pop());
        }
        else{
            System.out.println("Can't undo");
        }
    }
}
