package com.example.shoppingmall.order;

import com.example.shoppingmall.product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@RequiredArgsConstructor
public class Order {
    // String productName; <- ProductName은 이미 Product에 있으니 Product 클래스에서 가져와야 하는데~ 아래로 해주기
    //but 상품 id만 가지고 있으면 product에서 가져오면 된다! 그렇다고 productId를 가지고 다녀야 하나?
    Product product;
    int count;
    int id;

    public Order(Product orderdProduct, int count) {
        this.product = orderdProduct;
        this.count = count;
    }
    // DB column : Orders orders_id or id "통일성"

}
