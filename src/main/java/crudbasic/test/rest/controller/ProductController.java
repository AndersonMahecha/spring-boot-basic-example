package crudbasic.test.rest.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crudbasic.test.rest.api.ProductApi;
import crudbasic.test.service.ProductService;

@Validated
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<List<ProductApi>> getAll() {
		List<ProductApi> productApis = productService.getAll();
		return ResponseEntity.ok(productApis);
	}

	@PostMapping
	public ResponseEntity<ProductApi> create(@RequestBody @Valid ProductApi productApi) {
		ProductApi created = productService.create(productApi);
		return ResponseEntity.ok(created);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ProductApi> delete(@PathVariable @NotNull Integer id) throws Exception {
		ProductApi deleted = productService.delete(id);
		return ResponseEntity.ok(deleted);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ProductApi> update(@PathVariable @NotNull Integer id, @RequestBody @Valid ProductApi productApi)
			throws Exception {
		ProductApi updated = productService.update(productApi, id);
		return ResponseEntity.ok(updated);
	}

}
