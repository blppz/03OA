package com.bl.oa.service;

import com.bl.oa.entity.Account;
import com.bl.oa.mapper.AccountMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/23 19:21
 */
@Service
public class AccountService {

  @Autowired
  private AccountMapper accountMapper;

  /**
   * 查找所有的用户
   * @return 所有用户
   */
  public List<Account> findAll(){
    return null;
  }

  /**
   * 分页查找用户
   * @param pageNum 当前第几页
   * @param pageSize 每页有几条数据
   * @return 用户列表
   */
  public List<Account> accountList(int pageNum, int pageSize) {
    // 使用分页插件PageHelper
    PageHelper.startPage(pageNum, pageSize);
    return accountMapper.accountList();
  }

  /**
   * 根据用户名查找用户
   * @param loginName 用户名
   * @return 用户实体
   */
  public Account login(String loginName, String password) {
    List<Account> list = accountMapper.findByName(loginName);
    System.out.println(list.size());
    return list.size()==1?list.get(0):null;
  }

  /**
   * 添加一个用户
   * @param account 待添加的用户
   */
  public void save(Account account) {
  }
}
