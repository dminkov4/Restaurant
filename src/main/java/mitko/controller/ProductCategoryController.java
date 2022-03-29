package mitko.controller;

import mitko.dto.ProductCategoryDto;
import mitko.model.ProductCategory;
import mitko.service.ProductCategoryService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryController {

    private ProductCategoryService productCategoryService;


    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public List<ProductCategoryDto> getProductCategories()  {
        return productCategoryService.getProductCategories();
    }

    @PostMapping
    public ProductCategoryDto createProductCategory(@RequestBody ProductCategoryDto productCategoryDto) throws SQLException {
        return productCategoryService.create(productCategoryDto);
    }

    @RequestMapping("/{id}")
    public ProductCategory productCategory(@PathVariable("id") int id) {
        return (ProductCategory) productCategoryService.getProductCategories();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ProductCategory updateProductCategory(@PathVariable("id") long id, @RequestBody ProductCategoryDto productCategoryDto) {
        return productCategoryService.update(id, productCategoryDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
       productCategoryService.delete(id);
    }
}