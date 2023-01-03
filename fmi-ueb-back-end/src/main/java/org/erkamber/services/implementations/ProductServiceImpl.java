package org.erkamber.services.implementations;

import org.erkamber.dtos.ProductDto;
import org.erkamber.entities.Product;
import org.erkamber.exceptions.NotFoundException;
import org.erkamber.mappers.ProductMapper;
import org.erkamber.repositories.ProductRepository;
import org.erkamber.services.interfaces.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    /**
     * Method, which is used to find products by category
     *
     * @param productCategory Category, which is used to search products
     * @return List of DTO objects that have same category
     */
    @Override
    public List<ProductDto> findProductByCategory(String productCategory) {

        List<Product> searchedProductsByCategory = productRepository.findProductByProductCategory(productCategory);

        return productMapper.mapListOfProductToProductDto(searchedProductsByCategory);
    }

    /**
     * Method, which is used to find a product by a given Code
     *
     * @param code Code, used to find a product
     * @return DTO of the searched Product object
     */
    @Override
    public ProductDto findProductByCode(String code) {

        Optional<Product> searchedProduct = productRepository.findProductByProductCode(code);

        return productMapper.mapProductToProductDto(searchedProduct.orElseThrow(() ->
                new NotFoundException("Product searched with Code NOT Found!")));
    }

    /**
     * Method, which is used to add a new Product in the DB
     *
     * @param newProductDto DTO object of the product, which is going to be added in the DB
     */
    @Override
    public void addNewProduct(ProductDto newProductDto) {

        Product newProduct = productMapper.mapProductDtoToProduct(newProductDto);

        productRepository.save(newProduct);
    }

    /**
     * Method, which is used to delete a product by given ID
     *
     * @param productID ID of the Searched Product, which is going to be deleted.
     */
    @Override
    public void deleteProductByID(int productID) {

        Optional<Product> searchedProduct = productRepository.findById(productID);

        productRepository.delete(searchedProduct.orElseThrow(() ->
                new NotFoundException("Product searched with ID is NOT Found!")));
    }

    /**
     * Method, which is used to delete a product by a given code
     *
     * @param code Code used to search a product for deletion
     */
    @Override
    public void deleteProductByCode(String code) {

        Optional<Product> searchedProduct = productRepository.findProductByProductCode(code);

        productRepository.delete(searchedProduct.orElseThrow(() ->
                new NotFoundException("Product searched with Code is NOT Found!")));
    }

    /**
     * Method, which is used to update a product, receiving a DTO and setting its new values to the object being updated
     *
     * @param productDto DTO object containing new values for update
     */
    @Override
    public void updateProduct(ProductDto productDto) {

        Optional<Product> productToUpdate = productRepository.findById(productDto.getProductID());

        Product updatedProduct = productToUpdate.orElseThrow(() -> new NotFoundException("Product NOT Found!"));

        updatedProduct.setProductCategory(productDto.getProductCategory());
        updatedProduct.setProductCode(productDto.getProductCode());
        updatedProduct.setProductDescription(productDto.getProductDescription());
        updatedProduct.setImageUri(productDto.getImageUri());
        updatedProduct.setProductName(productDto.getProductName());
        updatedProduct.setProductQuantity(productDto.getProductQuantity());
        updatedProduct.setPurchasePrice(productDto.getPurchasePrice());
        updatedProduct.setSellPrice(productDto.getSellPrice());

        productRepository.save(updatedProduct);
    }

    /**
     * Method, which is used find and return a product by ID
     *
     * @param searchedProductID ID of the product, which is being searched
     * @return DTO object of the searched product
     */
    @Override
    public ProductDto findProductByID(int searchedProductID) {

        Optional<Product> searchedProduct = productRepository.findById(searchedProductID);

        return productMapper.mapProductToProductDto(searchedProduct.orElseThrow(() -> new NotFoundException("Product NOT Found!")));
    }

    /**
     * Method, which is used to get and return all the products from the DB.
     *
     * @return List of all The products as DTO
     */
    @Override
    public List<ProductDto> findAllProducts() {

        List<Product> allProducts = productRepository.findAll();

        return productMapper.mapListOfProductToProductDto(allProducts);
    }
}