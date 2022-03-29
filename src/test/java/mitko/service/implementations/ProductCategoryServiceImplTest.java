package mitko.service.implementations;

import mitko.dto.ProductCategoryDto;
import mitko.model.ProductCategory;
import mitko.repository.ProductCategoryRepository;
import mitko.util.ProductCategoryConverter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductCategoryServiceImplTest {

    @Mock
    private ProductCategoryRepository productCategoryRepository;

    @InjectMocks
    private ProductCategoryServiceImpl productCategoryServiceImpl;
    private ProductCategoryDto productCategory1;
    private ProductCategoryDto productCategory2;
    List<ProductCategoryDto> productCategoryDtoList;
    List<ProductCategory> productCategoryList;

    @BeforeEach
    public void setUp() {
        productCategoryDtoList = new ArrayList<>();
        productCategoryList = new ArrayList<>();
        productCategory1 = new ProductCategoryDto();
        productCategory2 = new ProductCategoryDto();
        productCategoryDtoList.add(productCategory1);
        productCategoryDtoList.add(productCategory2);
        productCategoryDtoList
                .stream()
                .forEach(productCategoryDto ->
                        productCategoryList.add(ProductCategoryConverter.toProductCategoryEntity(productCategoryDto)));
    }

    @AfterEach
    public void tearDown() {
        productCategory1 = productCategory2 = null;
        productCategoryList = null;
    }

    @Test
    void getProductCategories() {
        productCategoryRepository.save(ProductCategoryConverter.toProductCategoryEntity(productCategory1));
        when(productCategoryRepository.findAll()).thenReturn(productCategoryList);
        List<ProductCategoryDto> productCategoryList1 = productCategoryServiceImpl.getProductCategories();
        assertEquals(productCategoryList, productCategoryList1);
    }

    @Test
    void create() throws SQLException {
        when(productCategoryRepository.save(any())).thenReturn(productCategory1);
        productCategoryServiceImpl.create(productCategory1);
        verify(productCategoryRepository, times(1)).save(any());
    }
}
