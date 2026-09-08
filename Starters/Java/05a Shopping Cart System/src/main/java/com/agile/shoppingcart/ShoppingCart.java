package com.agile.shoppingcart;

import java.util.ArrayList;


public class ShoppingCart {
    public ArrayList<Item> cart;
    private double total;
    

    ShoppingCart() {
        cart = new ArrayList<>();
        total = 0.00;
    }

    public void addItem(Item item) {
        for (Item cartItem : cart) {
            if (cartItem.getName().equals(item.getName())) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                break;
            }
        }
        cart.add(item);
    }

    public void removeItem(Item item) {
        for (Item cartItem : cart) {
            if (cartItem.getName().equals(item.getName())) {
                cart.remove(item);
                break;
            } 
        }
    }

    public void setItemQuantity(Item item, int quantity) {
        for (Item cartItem : cart) {
            if (cartItem.getName().equals(item.getName())) {
                item.setQuantity(quantity);;
                break;
            } 
        }
    }

    public int getItemQuantity(Item item) {
        for (Item cartItem : cart) {
            if (cartItem.getName().equals(item.getName())) {
                return item.getQuantity();
            } 
        }
        return 0;
    }


    public double calculateTotal() {
        for (Item cartItem : cart) {
            total += (cartItem.getPrice() * cartItem.getQuantity());
        }
        return total;
    }

    public void emptyCart() {
        cart.removeAll(cart);
    }

    public boolean containsItem(Item item) {
        return cart.contains(item);
    }

}
