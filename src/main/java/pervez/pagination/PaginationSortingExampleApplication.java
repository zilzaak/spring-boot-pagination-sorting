package pervez.pagination;

import pervez.pagination.dto.APIResponse;
import pervez.pagination.entity.Product;
import pervez.pagination.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class PaginationSortingExampleApplication {

	@Autowired
    private ProductService service;

    @GetMapping("/all")
    private APIResponse<List<Product>> getProducts() {
        List<Product> allProducts = service.findAllProducts();
        return new APIResponse(allProducts.size(), allProducts);
    }

    @GetMapping("/{field}")
    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = service.findProductsWithSorting(field);
        return new APIResponse(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Product> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
        Page<Product> productsWithPagination = service.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @RequestMapping("/add/{name}/{price}/{quantity}")
    private APIResponse<Product> addproduct(@PathVariable String name, @PathVariable long price,@PathVariable int quantity) {
    	Product pr=new Product();
    	pr.setName(name);
    	pr.setPrice(price);
    	pr.setQuantity(quantity);
       service.addproduct(pr);
       return new APIResponse(pr);
    }

    public static void main(String[] args) {
        SpringApplication.run(PaginationSortingExampleApplication.class, args);
    }

}
