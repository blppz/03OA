package com.bl.oa.mapper;

import com.bl.oa.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 使用 @Repository 直接不能启动
@Mapper
@Repository
public interface AccountMapper {

  /**
   * 查找所有的用户
   * @return 所有用户
   */
  List<Account> findAll();

  /**
   * 分页查找用户
   * @return 用户列表
   */
  List<Account> accountList();

  /**
   * 根据用户名查找用户
   * @param loginName 用户名
   * @return 用户实体
   */
  List<Account> findByName(String loginName);

  /**
   * 添加一个用户
   * @param account 待添加的用户
   */
  void save(Account account);
}
