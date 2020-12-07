package com.demo.dao;

import com.demo.bean.User;

public interface LoginDao {

	User validateUser(String uname, String pass);

}
