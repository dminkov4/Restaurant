package mitko.service.implementations;

import mitko.dto.ProductDto;
import mitko.model.Product;
import mitko.repository.ProductRepository;
import mitko.service.ProductService;
import mitko.util.ProductConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(ProductConverter.toProductDto(product));
        }
        return productDtos;
    }

    @Override
    public ProductDto create(ProductDto productDto) {
        Product product = ProductConverter.toProductEntity(productDto);
        productRepository.save(product);
        return ProductConverter.toProductDto(product);
    }

    @Override
    public ProductDto update(long id, ProductDto productDto) {
        Product product = ProductConverter.toProductEntity(productDto);
        product.setId(id);
        return ProductConverter.toProductDto(productRepository.save(product));
    }

    @Override
    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
