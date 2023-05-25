package com.order.service;

import com.order.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    void saveItem(Item item);
}

