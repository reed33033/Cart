package com.mypackage.pojo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    public Map<Integer,CartItem> items=new LinkedHashMap<>();

    public void AddItem(CartItem cartItem){
        CartItem item=items.get(cartItem.getId());

        if(item==null){
            cartItem.setCount(1);
            cartItem.setTotalPrice(cartItem.getPrice());
            items.put(cartItem.getId(),cartItem);
        }else {
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getTotalPrice()+item.getPrice());
        }
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
