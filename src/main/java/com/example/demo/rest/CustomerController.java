package com.example.demo.rest;

import java.util.List;

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
	
	@Operation(summary = "タスクのテスト")
	@RequestMapping("/")
	CustomerEntity test() {
		return new CustomerEntity((long)1,"タスクのサンプル");
	}
	
	@Operation(summary = "タスクの全件取得")
	@GetMapping("/view")
	List<CustomerEntity> findAll() {
		return repository.findAll();
	}
	
	@Operation(summary = "タスクの登録")
	//@PostMapping("/comp")
	@PostMapping("/create")
	CustomerEntity save(@RequestBody CustomerEntity customerEntity) {
		return repository.save(customerEntity);
	}
	
	@Operation(summary = "タスクの削除")
	@DeleteMapping("/del/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@Operation(summary = "タスクの１件取得")
	@GetMapping("/view/{id}")
	CustomerEntity findOne(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@Operation(summary = "タスクの更新")
	@PutMapping("/update/{id}")
	CustomerEntity save(@RequestBody CustomerEntity updateCustomer, @PathVariable Long id) {
		return repository.save(updateCustomer);
	}
}
