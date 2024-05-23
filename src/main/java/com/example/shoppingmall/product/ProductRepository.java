package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {

    @Autowired
    EntityManager entityManager;
    Map<Integer, Product> product_table = new HashMap<>();

    int id = 0;


    public void save(Product product){
        entityManager.persist(product);
//        product.setId(id++);
//        product_table.put(product.getId(), product);
//        System.out.println("/products : repository _ " + product_table.get(id-1));
//        return product_table.get(id-1);
    }

    public Product findByName(String name){
        String jpql = "SELECT m FROM Member m WHERE m.name = :name";

        Product foundProduct = entityManager.createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getSingleResult();

        if (foundProduct == null){
            return null;
        }
        else{
            return foundProduct;
        }

    }
    public Product findById(int id) {
        return product_table.get(id);
    }
}
