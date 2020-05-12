package cn.kj.vuedemo.controller;

import cn.kj.vuedemo.domain.User;
import cn.kj.vuedemo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/usersub")
public class UserControllersub {
    @Autowired
    private UserService userService;
    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll.do")

    public PageInfo<User> findAll(@Param("page")  Integer page ){
        PageHelper.startPage(page==null?1:page,3);
        List<User> all = userService.findAll();
        return new PageInfo<User>(all);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    public User findById(Integer id){
        return userService.findById(id);
    }

    /**
     * 更新
     * @param user
     */
    @RequestMapping("/updateUser.do")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
}
