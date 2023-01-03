package org.erkamber.controllers;

import org.erkamber.dtos.ProductDto;
import org.erkamber.services.interfaces.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1")
@Validated
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Method, which is used to find a product by code
     *
     * @param productCode Code, used for searching a product
     * @return ProductDto, which was found by a given Code.
     */
    @GetMapping(value = "/products/code", params = {"productCode"})
    public ProductDto findProductByCode(@RequestParam(name = "productCode")
                                        String productCode) {

        return productService.findProductByCode(productCode);
    }

    /**
     * Method, which is used to find a product by category.
     *
     * @param productCategory String, which represents a product category.
     * @return List of all the Product Dto that have been found by a given Category.
     */
    @GetMapping(value = "/products/category", params = {"productCategory"})
    public List<ProductDto> findProductByCategory(@RequestParam(name = "productCategory")
                                                  String productCategory) {

        return productService.findProductByCategory(productCategory);
    }

    /**
     * Method, which is used to add a new product.
     *
     * @param newProductDto Product Dto, which is going to be added in the DB.
     */
    @PostMapping("/products")
    public void addNewProduct(@Valid @RequestBody ProductDto newProductDto) {

        productService.addNewProduct(newProductDto);
    }

    /**
     * Method, which is used to Delete a product by ID
     *
     * @param productID ID of the product which is going to be deleted
     */
    @DeleteMapping(value = "/products/delete", params = {"productID"})
    public void deleteProductByID(@RequestParam(name = "productID")
                                  int productID) {

        productService.deleteProductByID(productID);
    }

    /**
     * method, which is used to update a product
     *
     * @param newProductUpdateDto ProductDTO, which is going to be used for an update
     */
    @PutMapping("/products/update")
    public void updateProduct(@Valid @RequestBody ProductDto newProductUpdateDto) {

        productService.updateProduct(newProductUpdateDto);
    }

    /**
     * Method, which is used to get a product by ID
     *
     * @param productID ID of the product which is being searched
     * @return Product which is being searched by ID
     */
    @GetMapping(value = "/products/byId", params = {"productID"})
    public ProductDto getProductByID(@RequestParam(name = "productID")
                                     int productID) {

        return productService.findProductByID(productID);
    }

    /**
     * Method, which is being used for getting and return all the products from the DB
     * @return List of all the products as DTO object
     */
    @GetMapping(value = "/products")
    public List<ProductDto> getAllProducts() {

        return productService.findAllProducts();
    }
}