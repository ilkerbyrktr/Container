package com.distro.Container.service;

import com.distro.Container.entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();

    Item findbyId(int itemId);

    void remove(Integer itemId);

}
