package com.demo.service;

import com.demo.bean.User;

public interface LoginService {

	User validate(String uname, String pass);

}
