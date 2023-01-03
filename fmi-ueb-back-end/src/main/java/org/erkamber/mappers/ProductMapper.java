package org.erkamber.mappers;

import org.erkamber.dtos.ProductDto;
import org.erkamber.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    /**
     * Method, which is used to Map a ProductDto to a Product
     *
     * @param productDto productDto, which is going to be mapped
     * @return Mapped object as Product
     */
    public Product mapProductDtoToProduct(ProductDto productDto) {

        return new Product(productDto.getProductID(), productDto.getProductName(), productDto.getProductDescription(),
                productDto.getImageUri(), productDto.getPurchasePrice(), productDto.getSellPrice(),
                productDto.getProductQuantity(), productDto.getProductCategory(), productDto.getProductCode());
    }

    /**
     * Method, which is used to Map a Product to a ProductDto
     *
     * @param product product, which is going to be mapped
     * @return Mapped object as ProductDto
     */
    public ProductDto mapProductToProductDto(Product product) {

        return new ProductDto(product.getProductID(), product.getProductName(), product.getProductDescription(),
                product.getImageUri(), product.getPurchasePrice(), product.getSellPrice(), product.getProductQuantity(),
                product.getProductCategory(), product.getProductCode());
    }

    /**
     * Method, which is going to be used Map a List of Products to List of ProductsDto
     *
     * @param listOfProducts List of Products, which is going to be mapped.
     * @return Mapped List with ProductDto objects.
     */
    public List<ProductDto> mapListOfProductToProductDto(List<Product> listOfProducts) {

        return listOfProducts.stream().map(this::mapProductToProductDto).collect(Collectors.toList());
    }
}