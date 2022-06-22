package ru.netology.Repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    //Сохранение продуктов в Product
    public void save(Product product) {
        //создаем новый массив, где length - длина нового массива
        //products.length + 1 - это длинна исходного массива + одна новая ячейка
        //tmp - название нового массива
        int length = products.length + 1;
        Product[] tmp = new Product[length];

        //перебираем ячейки, копируем старый массив
        //и добавляем еще одну пустую ячейку - i
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        //заполняем последнюю ячейку
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    //Получаем все сохраненные продукты в Product
    public Product[] findAll() {
        int resultLength = products.length;
        Product[] result = new Product[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = products[i];
        }
        return result;
    }

    //Удаление по id
    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}