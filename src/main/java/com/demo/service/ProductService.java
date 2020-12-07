package com.demo.service;

import java.util.List;

import com.demo.bean.Product;

public interface ProductService {

	List<Product> getallProduct();

	Product getProductById(int pid);

	int updateProduct(Product p);

	int deletebyId(int pid);

	int addproduct(int pid, String pname, double price);

}
