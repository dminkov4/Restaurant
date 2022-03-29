package mitko.util;

import mitko.dto.ProductCategoryDto;
import mitko.model.ProductCategory;

public class ProductCategoryConverter {

    private ProductCategoryConverter() {
    }

    public static ProductCategoryDto toProductCategoryDto(ProductCategory productCategory) {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(productCategory.getId());
        productCategoryDto.setName(productCategory.getName());
        return productCategoryDto;
    }

    public static ProductCategory toProductCategoryEntity(ProductCategoryDto productCategoryDto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDto.getId());
        productCategory.setName(productCategoryDto.getName());
        return productCategory;
    }
}
