package com.bl.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Deacription TODO
 * @Author BarryLee
 * @Date 2019/12/23 19:24
 */
@Controller
public class MainController {
  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/index")
  public String toIndex() {
    return "index";
  }

}
