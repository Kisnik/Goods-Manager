package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import repositoy.ProductRepository;

public class ProductManager {

    private ProductRepository productRepository;

    public ProductManager(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : productRepository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;

    }


    public void add(Product item) {
        productRepository.save(item);
    }


}
