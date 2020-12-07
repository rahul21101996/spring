package com.demo.dao;

import java.util.List;

import com.demo.bean.Product;

public interface ProductDao {

	List<Product> getallproduct();

	Product editproduct(int pid);

	int updateProduct(Product p);

	int deleteprod(int pid);

	int addproduct(int pid,String pname,double price);

}
