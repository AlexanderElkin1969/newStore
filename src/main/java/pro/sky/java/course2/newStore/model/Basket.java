package pro.sky.java.course2.newStore.model;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Repository
@SessionScope
public class Basket {

    private final List<Product> basketList = new ArrayList<>();

    public void add(Product product) {
        basketList.add(product);
    }

    public List<Product> getBasketList() {
        return List.copyOf(basketList);
    }
}
