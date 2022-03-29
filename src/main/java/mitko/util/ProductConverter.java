package mitko.util;

import mitko.dto.ProductDto;
import mitko.model.Product;

public class ProductConverter {

    private ProductConverter() {
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        return productDto;
    }

    public static Product toProductEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        return product;
    }
}
