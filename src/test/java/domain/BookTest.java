package domain;

import manager.ProductManager;
import org.junit.jupiter.api.Test;
import repositoy.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book[] books;
    private ProductRepository productRepository = new ProductRepository();
    private ProductManager productManager = new ProductManager(productRepository);

    @Test
    public void shouldMatchBook() {
        books = new Book[4];
        books[0] = new Book("bookName1", "author1");
        books[1] = new Book("bookName2", "author2");
        books[2] = new Book("bookName3", "author3");
        books[3] = new Book("bookName4", "author4");

        for (int i = 0; i < 4; i++) {
            productManager.add(books[i]);
        }
        Product[] actual = productManager.searchBy("bookName2");
        Product[] expected = {books[1]};

        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldNotMatchBook() {
        books = new Book[4];
        books[0] = new Book("bookName1", "author1");
        books[1] = new Book("bookName2", "author2");
        books[2] = new Book("bookName3", "author3");
        books[3] = new Book("bookName4", "author4");

        for (int i = 0; i < 4; i++) {
            productManager.add(books[i]);
        }
        Product[] actual = productManager.searchBy("boo kName2");
        Product[] expected = new Book[0];

        assertArrayEquals(actual, expected);

    }

}