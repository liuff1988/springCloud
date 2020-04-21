package com.liuff.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liuff.entity.Item;
import com.liuff.entity.Order;
import com.liuff.entity.OrderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private static final Map<String, Order> ORDER_DATA = new HashMap<String, Order>();

    static {
        // 模拟数据库，构造测试数据
        Order order = new Order();
        order.setOrderId("201810300001");
        order.setCreateDate(Instant.now());
        order.setUpdateDate(order.getCreateDate());
        order.setUserId(1L);
        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

        Item item = new Item();// 此处并没有商品的数据，只是保存了商品ID，需要调用商品微服务获取
        item.setId(1L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        item = new Item(); // 构造第二个商品数据
        item.setId(2L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));

        order.setOrderDetails(orderDetails);

        ORDER_DATA.put(order.getOrderId(), order);
    }

    @Autowired
    private ItemService itemService;

    public Order queryOrderById(String orderId) {
        Order order = ORDER_DATA.get(orderId);

        if (null == order) {
            return null;
        }

        List<OrderDetail> orderDetails = order.getOrderDetails();

        for (OrderDetail orderDetail : orderDetails) {
            Item item = itemService.queryItemById(orderDetail.getItem().getId());
            if (null == item) {
                continue;
            }
            orderDetail.setItem(item);
        }

        return order;
    }
}