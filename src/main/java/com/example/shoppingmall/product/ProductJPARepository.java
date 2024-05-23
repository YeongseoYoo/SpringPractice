package com.example.shoppingmall.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ProductJPARepository extends JpaRepository<Product,String>{
    Optional<Product> findByName(String name);
}
