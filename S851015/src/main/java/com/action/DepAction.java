package com.action;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pojo.Dep;
import com.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/dep.do")
public class DepAction {

    @Autowired
    private DepService depService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(params = "p=fenye")
    public String fenye(){
        IPage<Dep> iPage = new Page<Dep>(1,2);
        QueryWrapper queryWrapper = new QueryWrapper();
        IPage page = depService.fenye(iPage,queryWrapper);
        request.setAttribute("page",page);
        return "show.jsp";
    }

    @RequestMapping(params ="p=findEmp")
    public String fenye2(){
        Map map = new HashMap();
        map.put("begin",1);
        map.put("size",4);
        IPage page = depService.fenye2(2,map);
        return "show.jsp";
    }

}
