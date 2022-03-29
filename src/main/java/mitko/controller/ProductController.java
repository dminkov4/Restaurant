package mitko.controller;

import mitko.dto.ProductDto;
import mitko.model.Product;
import mitko.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProduct(){
        return productService.getProduct();
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) throws SQLException {
        return productService.create(productDto);
    }

    @RequestMapping("/{id}")
    public Product product(@PathVariable("id") int id) {
        return (Product) productService.getProduct();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ProductDto updateProduct(@PathVariable("id") long id, @RequestBody ProductDto productDto) {
        return productService.update(id, productDto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }
}
