package ru.netology.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveId() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(1, "Футболка", 5_000);
        Product product1 = new Product(2, "Брюки", 2_000);
        Product product2 = new Product(3, "Майка", 1_000);
        repository.add(product);
        repository.add(product1);
        repository.add(product2);

        repository.removeById(1);

        Product[] expected = {product1, product2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {
        ShopRepository repository = new ShopRepository();
        Product product = new Product(1, "Футболка", 5_000);
        Product product1 = new Product(2, "Брюки", 2_000);
        Product product2 = new Product(3, "Майка", 1_000);
        repository.add(product);
        repository.add(product1);
        repository.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(4);
        });
    }
}
