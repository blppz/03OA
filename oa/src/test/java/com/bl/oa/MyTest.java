package com.bl.oa;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/24 10:10
 */
public class MyTest {
  @Test
  void testMD5() {
    final String s = DigestUtils.md5DigestAsHex("123".getBytes());
    System.out.println(s);
  }
}
