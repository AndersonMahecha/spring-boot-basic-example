package crudbasic.test.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crudbasic.test.entity.Product;
import crudbasic.test.repository.ProductRepository;
import crudbasic.test.rest.api.ProductApi;
import crudbasic.test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository,
							  ModelMapper modelMapper) {
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<ProductApi> getAll() {
		return productRepository.findAll().stream()
				.map(product -> modelMapper.map(product, ProductApi.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductApi create(ProductApi productApi) {
		Product product = modelMapper.map(productApi, Product.class);
		product = productRepository.save(product);
		return modelMapper.map(product, ProductApi.class);
	}

	@Override
	public ProductApi delete(Integer id) throws Exception {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new Exception("Producto no encontrado"));
		productRepository.delete(product);
		return modelMapper.map(product, ProductApi.class);
	}

	@Override
	public ProductApi update(ProductApi productApi, Integer id) throws Exception {

		Product product = productRepository.findById(id)
				.orElseThrow(() -> new Exception("Producto no encontrado"));
		Product updated = modelMapper.map(productApi, Product.class);
		updated.setId(product.getId());
		product = productRepository.save(updated);
		return modelMapper.map(product, ProductApi.class);
	}

}
