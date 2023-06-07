package com.spring_e_commerce.web.repository;

import com.spring_e_commerce.web.dto.ProductDto;
import com.spring_e_commerce.web.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   @Query("select p from Product p")
   Page<ProductDto> pageProduct(Pageable pageable);

   @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
   Page<Product> searchProducts(String keyword, Pageable pageable);

   @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
   List<Product> searchProductsList(String keyword);
}
