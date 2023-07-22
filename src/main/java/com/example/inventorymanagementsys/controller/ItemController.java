package com.example.inventorymanagementsys.controller;

import com.example.inventorymanagementsys.model.DTO.ItemDto;
import com.example.inventorymanagementsys.model.Item;
import com.example.inventorymanagementsys.service.CRUDService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final CRUDService service;

    public ItemController(CRUDService service) {
        this.service = service;
    }

    @Operation(summary = "This API for getting list items")
    @GetMapping()
    public List<Item> getItems(){
        return service.findAll();
    }

    @Operation(summary = "This API for adding new item")
    @PostMapping
    public Item addItem(@RequestBody ItemDto dto) {
        return service.save(dto);
    }

    @Operation(summary = "This API for sorting list and get list items")
    @PostMapping("sortByName")
    public List<Item> SortByName() {
        return service.SortByName();
    }

    @Operation(summary = "This API for delete item with id")
    @DeleteMapping("/{item_id}")
    public String deleteItem(@PathVariable Long item_id){
        service.deleteItem(item_id);
        return "Successfully deleted";
    }
}
