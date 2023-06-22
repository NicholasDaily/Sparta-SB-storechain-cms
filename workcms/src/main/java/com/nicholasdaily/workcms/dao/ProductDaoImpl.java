package com.nicholasdaily.workcms.dao;

import com.nicholasdaily.workcms.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    EntityManager manager;

    ProductDaoImpl(EntityManager manager){
        this.manager = manager;
    }

    @Override
    public Product getProductById(int id) {
        return manager.find(Product.class, id);
    }

    @Override
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = manager.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void createProduct(Product product) {
        manager.persist(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        return manager.merge(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Product product) {
        deleteProductById(product.getId());
    }

    @Override
    @Transactional
    public void deleteProductById(int id) {
        Product tempProduct = manager.find(Product.class, id);
        manager.remove(tempProduct);
    }
}
