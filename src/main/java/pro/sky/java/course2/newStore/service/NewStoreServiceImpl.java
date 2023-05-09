package pro.sky.java.course2.newStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.newStore.exceptions.*;
import pro.sky.java.course2.newStore.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewStoreServiceImpl implements NewStoreService {

    private final Map<String, Product> store = new HashMap<>(Map.of(
            "001", new Product("001", "product1", 10),
            "002", new Product("002", "product2", 10),
            "003", new Product("003", "product3", 10),
            "004", new Product("004", "product4", 10),
            "005", new Product("005", "product5", 10),
            "006", new Product("006", "product6", 10),
            "007", new Product("007", "product7", 10)
    ));

    @Autowired
    private Basket basket;

    public Map<String, Product> getList() {
        return Map.copyOf(store);
    }

    public Product add(String id, int quantity) {
        Product order;
        Product product = store.get(id);
        if (product == null) {
            throw new ProductNotFoundException("Товар не найден. Проверьте правильность написания Артикула_товара.");
        }
        int balance = product.getQuantity() - quantity;
        if (balance >= 0) {
            order = new Product(id, product.getNameOfProduct(), quantity);
            basket.add(order);
            product.setQuantity(balance);
            return order;
        } else {
            throw new LittleValueProductException("Товар временно не доступен в данном объёме.");
        }
    }

    public List<Product> get() {
        return basket.getBasketList();
    }

}
