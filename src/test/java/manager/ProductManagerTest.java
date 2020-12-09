package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Test;
import repositoy.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private Product[] products;
    private ProductRepository productRepository = new ProductRepository();
    private ProductManager productManager = new ProductManager(productRepository);

    @Test
    public void shouldFindBookByName() {
        products = new Product[4];
        products[0] = new Book("bookName1", "author1");
        products[1] = new Smartphone("smartName1", "man1");
        products[2] = new Smartphone("smartName2", "man2");
        products[3] = new Book("bookName2", "author2");

        for (int i = 0; i < 4; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("bookName2");
        Product[] expected = {products[3]};

        assertArrayEquals(actual, expected);


    }

    @Test
    public void shouldFindBookByAuthor() {
        products = new Product[4];
        products[0] = new Book("bookName1", "author1");
        products[1] = new Smartphone("smartName1", "man1");
        products[2] = new Smartphone("smartName2", "man2");
        products[3] = new Book("bookName2", "author2");

        for (int i = 0; i < 4; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("author1");
        Product[] expected = {products[0]};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        products = new Product[4];
        products[0] = new Book("bookName1", "author1");
        products[1] = new Smartphone("smartName1", "man1");
        products[2] = new Smartphone("smartName2", "man2");
        products[3] = new Book("bookName2", "author2");

        for (int i = 0; i < 4; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("smartName1");
        Product[] expected = {products[1]};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindSmartphoneByManufacturer() {
        products = new Product[4];
        products[0] = new Book("bookName1", "author1");
        products[1] = new Smartphone("smartName1", "man1");
        products[2] = new Smartphone("smartName2", "man2");
        products[3] = new Book("bookName2", "author2");

        for (int i = 0; i < 4; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("man2");
        Product[] expected = {products[2]};

        assertArrayEquals(actual, expected);
    }

    //поиск по несуществующему значению текстового поля
    @Test
    public void shouldSearchNotExists() {
        products = new Product[2];
        products[0] = new Book("bookName1", "author1");
        products[1] = new Smartphone("smartName1", "man1");
        for (int i = 0; i < 2; i++) {
            productManager.add(products[i]);
        }
        Product[] actual = productManager.searchBy("smatName1");
        Product[] expected = new Product[0];

        assertArrayEquals(actual, expected);
    }


}