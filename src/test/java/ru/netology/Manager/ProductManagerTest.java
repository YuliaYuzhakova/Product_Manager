package ru.netology.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.Repository.ProductRepository;


public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product one = new Book(1, "Мастер и Маргарита", 100, "Булгаков М.А.");
    Product two = new Book(2, "Американские боги", 300, "Гейман Нил");
    Product three = new Book(3, "Ребекка", 200, "Дафна Дюморье");
    Product four = new Smartphone(4, "IPone 11", 50000, "USA");
    Product five = new Smartphone(5, "IPone 12", 70000, "USA");
    Product six = new Smartphone(6, "Samsung", 80000, "China");
    Product seven = new Book(7, "Алхимик", 200, "Горвард Лавкрафт");
    Product eight = new Book(8, "Алхимик", 250, "Питер Джеймс");

    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
    }

    @Test
    public void shouldSearchNameBook() {
        Product[] actual = manager.searchBy("Мастер и Маргарита");
        Product[] expected = new Product[]{one};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNameSmartphone() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{six};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNull() {
        Product[] actual = manager.searchBy("Война и мир");
        Product[] expected = new Product[]{};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSameBookName() {
        Product[] actual = manager.searchBy("Алхимик");
        Product[] expected = new Product[]{seven, eight};
        Assertions.assertArrayEquals(expected, actual);
    }
}