package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.MODEL_T_MALL_ATTR;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;

@Controller
public class LoginController {

	@RequestMapping(value="login",produces="text/html; charset=UTF-8")
	@ResponseBody
	public String login(MODEL_T_MALL_ATTR list_attr, T_MALL_USER_ACCOUNT user, String username, String password) {

		return "中文";

	}

}
