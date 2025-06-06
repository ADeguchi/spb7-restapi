package com.example.demo.rest;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RequestMapping("/api1")
@RequiredArgsConstructor
@RestController

public class CustomerController {
	private final CustomerRepository repository;
	
	@Operation(summary = "顧客情報のテスト")
	@RequestMapping("/")
	CustomerEntity test() {
		//入れたものがそのまま見えるテスト
		return new CustomerEntity((long)1,"テスト",30,"大阪府テスト市",true);
	}
	
	@Operation(summary = "顧客情報の全件取得")
	@GetMapping("/view/all")
	List<CustomerEntity> findAll() {
	    return repository.findAll();
	}
	
	@Operation(summary = "顧客情報のページ取得")
	@GetMapping("/view")
	public Page<CustomerEntity> findPaged(
	    @PageableDefault(size = 5) Pageable pageable) {
	    return repository.findAll(pageable);
	}
	
	@Operation(summary = "顧客情報の登録")
	//@PostMapping("/comp")
	@PostMapping("/create")
	CustomerEntity save(@RequestBody CustomerEntity customerEntity) {
		return repository.save(customerEntity);
	}
	
	@Operation(summary = "顧客情報の削除")
	@DeleteMapping("/del/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@Operation(summary = "顧客情報の１件取得")
	@GetMapping("/view/{id}")
	CustomerEntity findOne(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@Operation(summary = "顧客情報の更新")
	@PutMapping("/update/{id}")
	CustomerEntity save(@RequestBody CustomerEntity updateCustomer, @PathVariable Long id) {
		return repository.save(updateCustomer);
	}
}
