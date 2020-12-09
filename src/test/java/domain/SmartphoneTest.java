package domain;

import manager.ProductManager;
import org.junit.jupiter.api.Test;
import repositoy.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private Smartphone[] smartphones;
    private ProductRepository productRepository = new ProductRepository();
    private ProductManager productManager = new ProductManager(productRepository);

    @Test
    public void shouldMatchBook() {
        smartphones = new Smartphone[4];
        smartphones[0] = new Smartphone("n1", "s1");
        smartphones[1] = new Smartphone("n2", "s2");
        smartphones[2] = new Smartphone("n3", "s3");
        smartphones[3] = new Smartphone("n4", "s4");

        for (int i = 0; i < 4; i++) {
            productManager.add(smartphones[i]);
        }
        Product[] actual = productManager.searchBy("s2");
        Product[] expected = {smartphones[1]};

        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldNotMatchBook() {
        smartphones = new Smartphone[4];
        smartphones[0] = new Smartphone("b1", "s1");
        smartphones[1] = new Smartphone("b2", "s2");
        smartphones[2] = new Smartphone("b3", "s3");
        smartphones[3] = new Smartphone("b4", "s4");

        for (int i = 0; i < 4; i++) {
            productManager.add(smartphones[i]);
        }
        Product[] actual = productManager.searchBy("boo kName2");
        Product[] expected = new Book[0];

        assertArrayEquals(actual, expected);

    }


}