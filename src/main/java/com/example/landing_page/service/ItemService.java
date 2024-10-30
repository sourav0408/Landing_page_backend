package com.example.landing_page.service;

import com.example.landing_page.entity.Item;
import com.example.landing_page.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    public Item saveItem(Item item) {

        return itemRepository.save(item);
    }

    public Item getItemById(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        return optionalItem.orElse(null);
    }
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    public void deleteItem(Long id) {
        itemRepository.deleteById(id); // Use JpaRepository's deleteById method
    }

}