package com.liuff.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private Long id;
    private String title;
    private String pic;
    private String desc;
    private Long price;
}