package mitko.service;

import mitko.dto.ProductCategoryDto;
import mitko.model.ProductCategory;

import java.sql.SQLException;
import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDto> getProductCategories();
    ProductCategoryDto create(ProductCategoryDto productCategoryDto) throws SQLException;
    ProductCategory update(long id, ProductCategoryDto productCategoryDto);
    void delete(long id);
}
