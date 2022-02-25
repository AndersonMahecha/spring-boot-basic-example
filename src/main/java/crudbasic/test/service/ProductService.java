package crudbasic.test.service;

import java.util.List;

import crudbasic.test.rest.api.ProductApi;

public interface ProductService {

	List<ProductApi> getAll();

	ProductApi create(ProductApi productApi);

	ProductApi delete(Integer id) throws Exception;

	ProductApi update(ProductApi productApi, Integer id) throws Exception;

}
