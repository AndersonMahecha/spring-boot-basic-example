package crudbasic.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import crudbasic.test.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
