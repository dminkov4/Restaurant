package mitko.service;

import mitko.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProduct();
    ProductDto create (ProductDto productDto);
    ProductDto update (long id, ProductDto productDto);
    void delete(long id);
}
