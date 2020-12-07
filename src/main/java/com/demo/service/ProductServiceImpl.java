package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	@Override
	public List<Product> getallProduct() {
		
		return productDao.getallproduct();
	}
	@Override
	public Product getProductById(int pid) {
		
		return productDao.editproduct(pid);
	}
	@Override
	public int updateProduct(Product p) {
		
		return productDao.updateProduct(p);
	}
	@Override
	public int deletebyId(int pid) {
		
		return productDao.deleteprod(pid);
	}
	@Override
	public int addproduct(int pid, String pname, double price) {
		
		return productDao.addproduct(pid,pname,price);
	}

}
