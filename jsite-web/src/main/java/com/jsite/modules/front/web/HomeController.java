package com.jsite.modules.front.web;


import com.jsite.common.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "${frontPath}")
public class HomeController extends BaseController {

    @RequestMapping(value = {"list", ""})
    public String list() {
        return "modules/home/index";
    }


}