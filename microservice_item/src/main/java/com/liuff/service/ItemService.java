package com.liuff.service;

import java.util.HashMap;
import java.util.Map;

import com.liuff.entity.Item;

import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private static final Map<Long, Item> ITEM_MAP = new HashMap<Long, Item>();

    static {
        // 静态数据 模拟数据库
        ITEM_MAP.put(1L, new Item(1L, "商品1", "http://1", "商品描述1", 1000L));
        ITEM_MAP.put(2L, new Item(2L, "商品1", "http://2", "商品描述2", 2000L));
        ITEM_MAP.put(3L, new Item(3L, "商品3", "http://3", "商品描述3", 3000L));
        ITEM_MAP.put(4L, new Item(4L, "商品4", "http://4", "商品描述4", 4000L));
        ITEM_MAP.put(5L, new Item(5L, "商品5", "http://5", "商品描述5", 5000L));
    }

    public Item queryItemById(Long id) {
        return ITEM_MAP.get(id);
    }
}