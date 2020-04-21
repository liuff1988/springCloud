package com.liuff.service;

import com.liuff.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {
    @Autowired
    private RestTemplate restTemplate;

    public Item queryItemById(Long id) {
        return restTemplate.getForObject("http://app-item/item/" + id, Item.class);
    }
}