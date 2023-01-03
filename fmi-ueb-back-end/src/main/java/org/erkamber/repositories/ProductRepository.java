package org.erkamber.repositories;

import org.erkamber.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductByProductCategory(String category);

    Optional<Product> findProductByProductCode(String productCode);

    Optional<Product> findProductByProductCodeAndProductCategory(String productCode, String productCategory);
}