package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shoppingmall.utils.Validator;

@RestController
@AllArgsConstructor //생성자 없애도 된다!
public class ProductController {
    @Autowired //밑에 있는 필드에다가 너가 가지고 있는 Spring Bean에 넣어줄래 라고 DI를 요청
    ProductService productService;

    //상품 개별 등록
    @PostMapping("/products")
    //역직렬화: json으로 들어오면 뒤에 객체가 있든, key-value가 있든 xml이 있든 mapping해준다
    public String registerProduct(@RequestBody Product product) {
        // * 유효성 검사 : name(영어), price(숫자)
        // 1) 조건문
        if(Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {
            System.out.println(
                    "/products : controller - " + product.getName());
            Product savedProduct = productService.registerProduct(product);
            if (savedProduct == null)
                return "등록 실패";
            return "등록 성공!";
        }
        else
            return "name 또는 price가 형식에 맞지 않습니다.";

    }

    //상품 개별 조회
    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable int id) {
        //1. Product 반환 필드 : id가 없어요
        //2. id 숫자만 들어온 거 맞는지 유효성 검사 추가
        if (Validator.isNumber(id))
            System.out.println("id 숫자야");
        return productService.findProduct(id); //repository에서 객체를 만들어야 service도 -> controller도
    }


}

