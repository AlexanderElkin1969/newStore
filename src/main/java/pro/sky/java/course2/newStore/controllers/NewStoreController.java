package pro.sky.java.course2.newStore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.newStore.model.*;
import pro.sky.java.course2.newStore.exceptions.*;
import pro.sky.java.course2.newStore.service.NewStoreServiceImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/store")
public class NewStoreController {
    private final NewStoreServiceImpl newStoreService;

    public NewStoreController(NewStoreServiceImpl newStoreService) {
        this.newStoreService = newStoreService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "<h1 style = \" color: green \">Добро пожаловать в наш интернет-магазин.</h1>" +
                "Для просмотра каталога товара воспользуйтесь командой /order.  " +
                "Для выбора товара воспользуйтесь командой /order/add?ID=Артикль_товара&quantity=количество_товара.  " +
                "Для просмотра выбранного товара воспользуйтесь командой /order/get.  ";
    }

    @GetMapping(path = "/order")
    public Map<String, Product> getList() {
        return newStoreService.getList();
    }

    @GetMapping(path = "/order/add")
    public String addProductToBasket(@RequestParam("ID") String id,
                                     @RequestParam("quantity") int quantity) {
        return newStoreService.add(id, quantity).toString() + " добавлен в корзину.";
    }

    @GetMapping(path = "/order/get")
    public List<Product> getProductToBasket() {
        return newStoreService.get();
    }

    @ExceptionHandler(LittleValueProductException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String LittleValueProductException(LittleValueProductException e) {
        return e.getMessage();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public String ProductNotFoundException(ProductNotFoundException e) {
        return e.getMessage();
    }

}
