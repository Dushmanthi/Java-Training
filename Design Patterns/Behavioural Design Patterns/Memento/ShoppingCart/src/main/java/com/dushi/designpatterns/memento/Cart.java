package com.dushi.designpatterns.memento;

import java.util.ArrayList;

//originator
public class Cart {
    ArrayList<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return  (ArrayList<Item>) items.clone();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    //save
    public CartMemento save(){
        return new CartMemento(getItems());
    }

    //revert
    public void revert(CartMemento cartMemento){
        items=cartMemento.getItems();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

    static class CartMemento{
        ArrayList<Item> items;

        public CartMemento(ArrayList<Item> items) {
            this.items = items;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void setItems(ArrayList<Item> items) {
            this.items = items;
        }
    }
}
