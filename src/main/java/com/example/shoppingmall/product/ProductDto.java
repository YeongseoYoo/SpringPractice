package com.example.shoppingmall.product;

import com.example.shoppingmall.member.Member;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private int id;

    @JsonProperty("product_name")
    @NotBlank(message = "상품명은 필수 입력입니다.")
    private String name;

    @NotBlank(message = "가격은 필수 입력입니다.")
    @Size(min=3, message = "최소 3자리 이상 입력해주세요.")
    private int price;

    @NotBlank(message = "상품 설명은 필수 입력입니다.")
    private String description;

    public Product convertToEntity() {
        return new Product(name, price, description);
    }
}
