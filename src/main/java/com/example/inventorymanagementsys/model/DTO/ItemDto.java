package com.example.inventorymanagementsys.model.DTO;

import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private String name;
    private int quantity;
    private Date date;
}
