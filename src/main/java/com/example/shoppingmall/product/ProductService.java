package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service //이 anotation은 큰 기능 추가는 없고 명시 기능이 제일 크다
@AllArgsConstructor //생성자 코드를 안 써줘도 된다!
public class ProductService {

    ProductRepository productRepository;


    public Product registerProduct(Product product) {
        System.out.println("/prodicts _ service");

        return productRepository.save(product);
    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
    }
}
