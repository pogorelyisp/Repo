import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repo.NotFoundException;
import ru.netology.repo.Product;
import ru.netology.repo.ShopRepository;

public class ShopRepositoryTest {

    @Test
    public void shouldRemoveId() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Пальто", 7_000);
        Product product2 = new Product(2, "Брюки", 2_000);
        Product product3 = new Product(3, "Квартира", 6_000_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        repository.remove(2);

        Product[] expected = {product1, product3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotFoundId() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Пальто", 7_000);
        Product product2 = new Product(2, "Брюки", 2_000);
        Product product3 = new Product(3, "Квартира", 6_000_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.remove(1234567)
        );
    }


}
