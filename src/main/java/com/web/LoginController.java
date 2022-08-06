package com.web;

import com.alibaba.fastjson.JSON;
import com.bean.Tblpower;
import com.bean.Tblrole;
import com.bean.Tbluser;
import com.service.RolePowerService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userManage")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private RolePowerService rolePowerService;

    // 权限变换
    @RequestMapping("/changePower")
    public  String changePower(String[] powerIds, long roleId) {
        // 删除角色的所有权限
        rolePowerService.delPower(roleId);
        boolean flag = true;
        // 循环给角色添加权限
        for (int i = 0; i < powerIds.length; i++) {
            long powerId = Long.parseLong(powerIds[i]);
            if (rolePowerService.addPower(roleId,powerId)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            return "1";
        } else {
            return "2";
        }
    }

    // 查询权限
    @RequestMapping(value="/findPower",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public  String findPower(long roleId) {
        System.out.println("---------权限管理---------");
        List<Tblrole> rolePowerList = rolePowerService.findRoleAllPower(roleId);
        List<Tblpower> powerList = rolePowerService.findPower();
        Map<String, Object> map = new HashMap<>();
        map.put("rolePowerList",rolePowerList);
        map.put("powerList",powerList);
        String json = JSON.toJSONString(map);
        return json;
    }

    // 分配权限按钮
    @RequestMapping("/power")
    public  String power(long roleId, String roleName, HttpSession session) {
        System.out.println("---------分配权限按钮---------");
        session.setAttribute("roleId", roleId);
        session.setAttribute("roleName", roleName);
        return "1";  // 页面名称
    }

    // 权限管理
    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    // 查询所有角色
    @RequestMapping(value="/findAllrole",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String findAllrole(String roleName) {
        System.out.println("---------角色管理---------");
        List<Tblrole> roleList = rolePowerService.findAllRole(roleName);
        String json = JSON.toJSONString(roleList);
        return json;
    }

    // 修改角色
    @RequestMapping(value = "/confirmUpdRole",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String confirmUpdRole(String roleDescribe,Long roleId){
        boolean flag = rolePowerService.updRole(roleDescribe,roleId);
        if (flag) {
            return "1";
        } else {
            return "2";
        }
    }

    // 删除角色
    @RequestMapping(value = "/delRole",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String delRole(Long roleId){
        List<Tblrole> checkRoleList = rolePowerService.checkRole(roleId);   // 检测该角色是否已被使用
        if (checkRoleList.size() > 0) {
            return "0"; // 角色已被使用
        } else {
            boolean flag = rolePowerService.delRole(roleId);
            if (flag) {
                return "1";
            } else {
                return "2";
            }
        }
    }

    // 新增角色
    @RequestMapping(value = "/confirmAddRole",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String confirmAddRole(String roleName,String roleDescribe){
        List<Tblrole> tblrole = rolePowerService.checkRoleName(roleName);
        if (tblrole.size() > 0) {
            return "0";
        } else {
            boolean flag = rolePowerService.addRole(roleName,roleDescribe);
            if (flag) {
                return "1";
            } else {
                return "2";
            }
        }
    }

    // 判断角色名称是否已存在
    @RequestMapping(value = "/checkRoleName",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String checkRoleName(String roleName){
        List<Tblrole> tblrole = rolePowerService.checkRoleName(roleName);
        if (tblrole.size() > 0) {
            return "1";
        } else {
            return "2";
        }
    }

    // 角色管理
    @RequestMapping("/role")
    public String role() {
        return "role";  // 页面名称
    }

    // 动态权限
    @RequestMapping(value = "/rolePower",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String findRolePower(long roleId) {
        System.out.println("---------动态权限---------");
        List<Tblrole> rolePowerList = rolePowerService.findRoleAllPower(roleId);
        String json = JSON.toJSONString(rolePowerList);
        return json;
    }

    // 首页
    @RequestMapping("/index")
    public String index() {
        return "index";  // 页面名称
    }

    // 打开用户列表界面
    @RequestMapping("/userList")
    public String userList() {
        return "userList";  // 页面名称
    }

    // 查询用户列表数据
    @RequestMapping(value="/findUser",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String findUser(String acc, String userName) {
        System.out.println("---------userlist---------");
        List<Tbluser> userList = userService.findUser(acc, userName);
        String json = JSON.toJSONString(userList);
        return json;
    }

/*
    // 新增用户
    @RequestMapping("/confirmAdd")
    public String confirmAdd(String addAcc, String addPwd, String addName, long addSex, long addAge, MultipartFile addImg, HttpServletRequest request, HttpServletResponse response) throws IOException {     // 参数名要和前端名字一样才能取到值
        String path = "fail";
        String addImgName = addImg.getOriginalFilename();    // 文件名
        System.out.println("文件名："+addImgName);
        try {
            // 访问的url
            String url = request.getServletContext().getRealPath("/upload");
            System.out.println("头绪路径："+url);
            File file = new File(url);
            if (!file.exists()) {
                file.mkdir();
            }
            addImg.transferTo(new File(url+"/"+addImgName)); // 保存File
        } catch (IOException e) {
            e.printStackTrace();
        }
            // 帐号已存在
            if (userService.checkAcc(addAcc).size() > 0) {
            } else {
                String sex = "";
                if (addSex == 1) {
                    sex = "男";
                } else if (addSex == 2) {
                    sex = "女";
                }
                boolean flag = userService.register(addAcc, addPwd, addName, sex, addAge, addImgName);
                if (flag) {
                    response.getWriter().println("添加成功");
                } else {
                    response.getWriter().println("添加失败");
                }
                path = "userList";
            }
        return path;
    }
*/

    // 新增用户
    @RequestMapping(value = "/confirmAdd",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String confirmAdd(String addAcc, String addName, String addSex, Long addAge, String addAddress) {
        List<Tbluser> tblusers = userService.checkAcc(addAcc);
        if (tblusers.size() > 0) {
            return "0";
        } else {
            boolean flag = userService.confirmAddUser(addAcc,addName,addSex,addAge,addAddress);
            if (flag) {
                System.out.println("新增用户成功");
                return "1";
            } else {
                System.out.println("新增用户失败");
                return "2";
            }
        }
    }

    // 删除用户
    @RequestMapping(value = "/delUser",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String delUser(Long id) {
        System.out.println("删除的用户ID："+id);
        boolean flag = userService.delUser(id);
        if (flag) {
            return "1";
        } else {
            return "2";
        }
    }

    // 修改用户
    @RequestMapping(value = "/updUser",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String updUser(Long id, String updPwd, String updName, String updSex, Long updAge, String updAddress) {
        System.out.println("修改的用户ID："+id);
        boolean flag = userService.updUser(updPwd,updName,updSex,updAge,updAddress,id);
        if (flag) {
            return "1";
        } else {
            return "2";
        }
    }

    // 打开登录界面
    @RequestMapping("/loginView")
    public String login(){
        return "login";//   页面名称
    }

    // 登录
    @RequestMapping(value = "/doLogin",produces = { "text/html;charset=UTF-8;", "application/json;charset=UTF-8;" })
    public String doLogin(String acc, String pwd, Model model) {
        System.out.println("267          帐号："+acc+"，密码："+pwd);
        Tbluser tbluser = userService.login(acc,pwd);
        if (tbluser != null) {
            System.out.println("登录成功");
            return "1";
        } else {
            System.out.println("登录失败");
            return "2";
        }
    }

    // 打开注册界面
    @RequestMapping("/registerView")
    public String toRegister(){
        return "register";//   页面名称
    }

    // 注册
    @RequestMapping("/doRegister")
    public String doRegister(String acc, String pwd, String checkPwd, String userName, long userSex, long age, MultipartFile fileAct, HttpServletRequest request) {     // 参数名要和前端名字一样才能取到值
        String path = "register";
        String fileName = fileAct.getOriginalFilename();    // 文件名
        System.out.println("文件名："+fileName);
        try {
            // 访问的url
            String url = request.getServletContext().getRealPath("/upload");
            System.out.println("服务器文件夹："+url);
            File file = new File(url);
            if (!file.exists()) {
                file.mkdir();
            }
            fileAct.transferTo(new File(url+"/"+fileName)); // 保存File
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 密码和确认密码相等
        if (pwd.equals(checkPwd)) {
            // 帐号已存在
            if (userService.checkAcc(acc).size() > 0) {
            } else {
                String sex = "";
                if (userSex == 1) {
                    sex = "男";
                } else if (userSex == 2) {
                    sex = "女";
                }
                userService.register(acc, pwd, userName, sex, age, fileName);
                path = "login";
            }
        }
        return path;
    }

}

// 1、SpringApplication 静态电泳run，从静态run方法中new一个自己的实例，开调用实例的run方法 SpringAppplication构造方法进行属性变更的初始化
// 2、run方法（主要流程）
    // 2.1 创建SpringApplicationRunListeners类，实例对象，starting()，启动监听
    // 2.2 如何加载配置文件     加载xml / properties
        // 2.2.1 通过configurableEnvironment得到配置环境对象， new ApplicationServletEnvironment ------> 配置tomcat、运行环境
        // 2.2.2 prepareContext加载xml / properties
        // 2.2.3 通知listener对象，配置环境已读取完成
    // 2.3 从ApplicationContextFactory中 create 个 ApplicationContext(上下文容器)对象
        // ApplicationContext = new ClasspathXMLApplicationContext("application.xml)，实例化类得到对象
        // @RestController @RequestMapping("/XXX")：相当于在上下文容器注入，进行实例化生成对象

// 三个注解
    // @SpringBootApplication
    // @SpringBootConfiguration：实例对象    @configuration ---> @component
    // @EnableAutoConfiguration
