package com.distro.Container.implementation;

import com.distro.Container.dao.ItemRepository;
import com.distro.Container.entity.Item;
import com.distro.Container.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @Override
    public List<Item> findAll(){return itemRepository.findAll();}

    @Override
    public Item findbyId(int itemId){
        Optional<Item> byId=itemRepository.findById(itemId);
        Item item = byId.get();
        return item;
    }

    @Override
    public void remove(Integer itemId){
        itemRepository.deleteById(itemId);
    }
}