package com.example.shoppingmall.product;

import com.example.shoppingmall.member.Member;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service //이 anotation은 큰 기능 추가는 없고 명시 기능이 제일 크다
@AllArgsConstructor //생성자 코드를 안 써줘도 된다!
public class ProductService {

    ProductJPARepository productJPARepository;

    @Transactional
    public String join(Product product) {
        productJPARepository.save(product);

        String name = productJPARepository
                .findByName(product.getName())
                .map(Member::getNAme).orElseThrow(()->new IllegalStateException("User ID not found after save"));

        return name;
    }

    public boolean checkDuplicated(String name){
        return productJPARepository.findByName(name).isPresent();
    }


}
