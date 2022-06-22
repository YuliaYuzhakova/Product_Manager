package ru.netology.Manager;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.Repository.ProductRepository;

import static java.util.regex.Pattern.matches;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }


    private Product[] products = new Product[0];

    //Метод добавления новго продукта в репозиторий
    public void add(Product product) {
        repository.save(product);
    }

    //Метод осуществления поиска
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < products.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    private boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }

}

