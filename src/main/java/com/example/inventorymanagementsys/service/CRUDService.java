package com.example.inventorymanagementsys.service;

import com.example.inventorymanagementsys.model.DTO.ItemDto;
import com.example.inventorymanagementsys.model.Item;
import com.example.inventorymanagementsys.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDService {

    private final ItemRepository repository;

    public CRUDService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> findAll() {
        return repository.findAll();
    }


    public void deleteItem(Long itemId) {
        repository.deleteById(itemId);
    }

    public List<Item> SortByName() {
        return repository.findByOrderByNameAsc();
    }

    public Item save(ItemDto dto) {
        Item item = new Item(dto.getName(), dto.getQuantity(), dto.getDate());
        return repository.save(item);
    }
}
