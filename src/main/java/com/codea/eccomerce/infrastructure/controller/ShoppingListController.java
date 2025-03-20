package com.codea.eccomerce.infrastructure.controller;

import com.codea.eccomerce.aplication.service.OrderProductService;
import com.codea.eccomerce.aplication.service.OrderService;
import com.codea.eccomerce.aplication.service.UserService;
import com.codea.eccomerce.domain.Order;
import com.codea.eccomerce.domain.OrderProduct;
import com.codea.eccomerce.domain.User;
import com.codea.eccomerce.infrastructure.adapter.OrderProductCrudRepository;
import com.codea.eccomerce.infrastructure.entity.OrderEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/cart/shopping")

public class ShoppingListController {
    private final OrderService orderService;
    private final UserService userService;
    private final OrderProductService orderProductService;

    public ShoppingListController(OrderService orderService, UserService userService, OrderProductService orderProductService) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderProductService = orderProductService;
    }

    @GetMapping
    public String showShoppingList(Model model, HttpSession httpSession){
        List<Order> newListOrder = new ArrayList<>();
        User user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));

        Iterable<Order> orders = orderService.getOrdersByUser(user);
        for (Order order: orders ) {
            newListOrder.add(getOrdersProducts(order));
        }
        model.addAttribute("id", Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        model.addAttribute("orders", newListOrder);

        return "user/shoppinglist";
    }

    private Order getOrdersProducts(Order order){
        Iterable<OrderProduct> orderProducts = orderProductService.getOrderProductsByOrderId(order);
        order.addOrdersProduct((List<OrderProduct>) orderProducts);
        return order;
    }
}

