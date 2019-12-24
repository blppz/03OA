package com.bl.oa.controller;

import com.bl.oa.entity.Account;
import com.bl.oa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/23 19:26
 */
@Controller
@RequestMapping("/account")
public class AccountController {

  @Autowired
  private AccountService accountService;

  /**
   * 分页获取用户列表
   */
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") Integer pageNum,
      @RequestParam(defaultValue="5") Integer pageSize,
      HttpServletRequest request
  ) {
    final List<Account> list = accountService.accountList(pageNum, pageSize);
    for (Account account : list) {
      System.out.println(account);
    }

    // 将 accountList 设置到 request
    request.setAttribute("accountList", list);

    return "account/list";
  }

  @ResponseBody
  @RequestMapping("validateAccount")
  public String validateAccount(HttpServletRequest request, String loginName, String password) {
    Account account = accountService.login(loginName, password);

    System.out.println(account);
    if(account==null) {
      return "你还没注册呢";
    }

    if(!account.getPassword().equals(password)) {
      return "密码不对";
    }

    final HttpSession session = request.getSession();
    session.setAttribute("account", account);
    return "success";
  }

  @RequestMapping("/login")
  public String login() {
    return "account/login";
  }

  @RequestMapping("logout")
  public String logout(HttpServletRequest request) {
    final HttpSession session = request.getSession();
    session.setAttribute("account", null);
    return "index";
  }
}
