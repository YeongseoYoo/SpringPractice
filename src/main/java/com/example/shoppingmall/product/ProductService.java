package com.example.shoppingmall.product;

import com.example.shoppingmall.member.Member;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service //이 anotation은 큰 기능 추가는 없고 명시 기능이 제일 크다
@AllArgsConstructor //생성자 코드를 안 써줘도 된다!
public class ProductService {

    ProductRepository productRepository;


    @Transactional
    public String join(Product product) {
        productRepository.save(product);

        String name = productRepository
                .findByName(product.getName())
                .getName();

        return name;
    }


}
