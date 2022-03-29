package mitko.service.implementations;

import mitko.dto.ProductCategoryDto;
import mitko.model.ProductCategory;
import mitko.repository.ProductCategoryRepository;
import mitko.service.ProductCategoryService;
import mitko.util.ProductCategoryConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<ProductCategoryDto> getProductCategories() {
        List<ProductCategoryDto> productCategoryDtos = new ArrayList<>();
        List<ProductCategory> productCategories = productCategoryRepository.findAll();
        for (ProductCategory productCategory : productCategories){
            ProductCategoryDto productCategoryDto = ProductCategoryConverter.toProductCategoryDto(productCategory);
            productCategoryDtos.add(productCategoryDto);
        }
        return productCategoryDtos;
    }

    @Override
    public ProductCategoryDto create(ProductCategoryDto productCategoryDto){
        ProductCategory productCategory = ProductCategoryConverter.toProductCategoryEntity(productCategoryDto);
        productCategoryRepository.save(productCategory);
        return ProductCategoryConverter.toProductCategoryDto(productCategory);
    }

    @Override
    public ProductCategory update(long id, ProductCategoryDto productCategoryDto) {
        ProductCategory productCategoryDb = productCategoryRepository.findById(id).get();
        productCategoryRepository.save(productCategoryDb);
        return productCategoryDb;
    }

    @Override
    public void delete(long id) {
        productCategoryRepository.deleteById(id);
    }
}