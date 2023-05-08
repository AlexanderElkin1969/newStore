package pro.sky.java.course2.newStore.service;

import pro.sky.java.course2.newStore.model.*;

import java.util.List;
import java.util.Map;

public interface NewStoreService {

    public Map<String, Product> getList();

    public Product add(String id, int quantity);

    public List<Product> get();
}
