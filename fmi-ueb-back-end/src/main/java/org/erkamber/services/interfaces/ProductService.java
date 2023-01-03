package org.erkamber.services.interfaces;

import org.erkamber.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    /**
     * Method, which is used to find products by category
     *
     * @param productCategory Category, which is used to search products
     * @return List of DTO objects that have same category
     */
    List<ProductDto> findProductByCategory(String productCategory);

    /**
     * Method, which is used to find a product by a given Code
     *
     * @param code Code, used to find a product
     * @return DTO of the searched Product object
     */
    ProductDto findProductByCode(String code);

    /**
     * Method, which is used to add a new Product in the DB
     *
     * @param newProductDto DTO object of the product, which is going to be added in the DB
     */
    void addNewProduct(ProductDto newProductDto);

    /**
     * Method, which is used to delete a product by given ID
     *
     * @param productID ID of the Searched Product, which is going to be deleted.
     */
    void deleteProductByID(int productID);

    /**
     * Method, which is used to delete a product by a given code
     *
     * @param code Code used to search a product for deletion
     */
    void deleteProductByCode(String code);

    /**
     * Method, which is used to update a product, receiving a DTO and setting its new values to the object being updated
     *
     * @param productDto DTO object containing new values for update
     */
    void updateProduct(ProductDto productDto);

    /**
     * Method, which is used find and return a product by ID
     *
     * @param searchedProductID ID of the product, which is being searched
     * @return DTO object of the searched product
     */
    ProductDto findProductByID(int searchedProductID);

    /**
     * Method, which is used to get and return all the products from the DB.
     *
     * @return List of all The products as DTO
     */
    List<ProductDto> findAllProducts();
}