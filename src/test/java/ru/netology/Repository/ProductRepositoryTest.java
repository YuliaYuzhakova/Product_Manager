package ru.netology.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Manager.ProductManager;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.Repository.ProductRepository;

public class ProductRepositoryTest {
    Product one = new Book(1, "Мастер и Маргарита", 100, "Булгаков М.А.");
    Product two = new Book(2, "Американские боги", 300, "Гейман Нил");
    Product three = new Book(3, "Ребекка", 200, "Дафна Дюморье");
    Product four = new Smartphone(4, "IPone 11", 50000, "USA");
    Product five = new Smartphone(5, "IPone 12", 70000, "USA");
    Product six = new Smartphone(6, "Samsung", 80000, "China");

    @Test
    public void saveNewProduct() {
        ProductRepository repository = new ProductRepository();
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);
        repository.save(six);

        Product[] actual = repository.findAll();
        Product[] expected = {one, two, three, four, five, six};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void saveNullProduct() {
        ProductRepository repository = new ProductRepository();
        Product[] actual = repository.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeOneProduct() {
        ProductRepository repository = new ProductRepository();
        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);
        repository.save(five);
        repository.save(six);
        repository.removeById(6);

        Product[] actual = repository.findAll();
        Product[] expected = {one, two, three, four, five};

        Assertions.assertArrayEquals(expected, actual);
    }


}
