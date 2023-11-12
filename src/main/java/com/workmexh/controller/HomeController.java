package com.workmexh.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.workmexh.common.ActSetNumber;
import com.workmexh.domain.*;
import com.workmexh.mapper.home.RegiMapper;
import com.workmexh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
/*
*
* 控制类 活动报名主页
* 包含 活动页列表的刷新、报名功能
*
* */

@Controller
@RequestMapping("/Home")
public class HomeController {

    @Autowired
    private HomeService homeService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ActService actService;
    @Resource
    private RecordService recordService;
    @Resource
    private RegiService regiService;
    @Resource
    private SignService signService;
// 个人中心 admin 的用户信息管理列表
    @ResponseBody
    @RequestMapping("/getAll")
    public Map<String, Object> getAll(PageParam pageParam){
        PageHelper.startPage(pageParam);
        List<User> userList=new ArrayList<>();
        userList=homeService.findAllUsers();
//        System.out.println("userList:"+userList);
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        Map<String,Object> map=new HashMap<>();
        map.put("userList",pageInfo.getList());
        map.put("total",pageInfo.getTotal());
//        System.out.println(map);
        return map;
    }
    // redis test
//    @ResponseBody
//    @RequestMapping("/redis")
//    public String getredis(){
//        stringRedisTemplate.opsForValue().set("name","123");
//        return "redis test";
//    }
    /*
    *  跳转主页
    *  将数据以json格式返回前端
    * */
//    @ResponseBody
//    @RequestMapping("loadIndex")
//    public Map<String, Object> loadIndex(){
//        List<User> userList=new ArrayList<>();
//        userList=homeService.findAllUsers();
//        Map<String,Object> map=new HashMap<>();
//        map.put("userList",userList);
//        System.out.println(map);
//        return map;
//    }
/*
*     infIndex
* */
@ResponseBody
@RequestMapping("/showActlist")
public Map<String, Object> showActlist(){
    List<Regiact> actlist=actService.showList();
    Map<String,Object> map=new HashMap<>();
    map.put("actlist",actlist);
    return map;
}

//    @ResponseBody
//    @RequestMapping("/doSignup")
//    public int signupAct(@RequestBody Integer actNumber, String userAcc){
//        int signs= recordService.doSignup(actNumber,userAcc);
//        System.out.println(signs);
//        return signs;
//
//    }

    @ResponseBody
    @RequestMapping("/doRecord")
    public int doRecordAct(@RequestBody Record record){

        int signs= recordService.dosignuptest(record);
        System.out.println(signs);
        return signs;

    }
    // 活动测试写入
//    @ResponseBody
//    @RequestMapping("/doAddactTest")
//    public int addActTest(){
//        Integer recNumber=0;//定义recNumber 用于判断活动表中是否有相同的recNumber
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        java.util.Date utilStartTime = null;
//        java.util.Date utilOverTime = null;
//        java.util.Date utilDateTime=null;
//        try {
//            utilStartTime = dateFormat.parse("2023-09-18 14:13:12");
//            utilOverTime = dateFormat.parse("2023-09-18 15:12:11");
//            utilDateTime=dateFormat.parse("2023-10-01 15:11:12");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(utilOverTime);
//        System.out.println(utilStartTime);
//        System.out.println(utilDateTime);
//        java.sql.Timestamp startTime = new java.sql.Timestamp(utilStartTime.getTime());
//        java.sql.Timestamp overTime = new java.sql.Timestamp(utilOverTime.getTime());
//        java.sql.Timestamp dateTime = new java.sql.Timestamp(utilDateTime.getTime());
//        System.out.println(startTime);
//        System.out.println(overTime);
//        System.out.println(dateTime);
//        Regiact regiact=new Regiact("学校复课通知","发布号","这是一篇文章详情content detail 12345",startTime, overTime,dateTime,"https://www.gdxzzy.edu.cn/__local/5/59/D5/9F0035EE9643B7D7260848CD661_D21898F0_A2F61.png",11111,30,2);
//
//        int signs= regiService.doAddact(regiact);
//        System.out.println(signs);
//        return signs;
//
//    }
    @ResponseBody
    @RequestMapping("/doAddact")
    public Integer addAct(@RequestBody Regiact regiact){
        /**
         *
         * 时间部分的配置↓↓↓
         *
         */
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        java.util.Date utilStartTime = null;
//        java.util.Date utilOverTime = null;
//        try {
//            utilStartTime = dateFormat.parse("2023-09-18 14:13:12");
//            utilOverTime = dateFormat.parse("2023-09-20 15:12:11");
//
//            utilDateTime=dateFormat.parse(String.valueOf(utilDateTime));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        java.sql.Timestamp startTime = new java.sql.Timestamp(utilStartTime.getTime());
//        java.sql.Timestamp overTime = new java.sql.Timestamp(utilOverTime.getTime());
        java.util.Date utilDateTime=new Date();// 获取发布文章时的当前时间
        java.sql.Timestamp dateTime = new java.sql.Timestamp(utilDateTime.getTime());
        /**
         * 进行添加操作前对给定默认值的实体类构造的配置↓↓↓
         * */
//        regiact.setRegiStarttime(startTime);
//        regiact.setRegiOvertime(overTime);
        regiact.setRegiDatetime(dateTime);
        regiact.setRegiImg("https://www.gdxzzy.edu.cn/__local/5/59/D5/9F0035EE9643B7D7260848CD661_D21898F0_A2F61.png");
        regiact.setRegiAlnum(0);
        /**
         * 单独为RegiNumber生成随机活动编号↓↓↓
         */
        Integer regiNumber=0;//定义recNumber 用于判断活动表中是否有相同的recNumber
        ActSetNumber actSetNumber=new ActSetNumber();
        regiNumber= actSetNumber.setNumber(8);
        Integer norepeat=regiService.doNorepeat(regiNumber);// 进行随机编号查重返回0/1
        while(norepeat!=null){// 用null判断是否有重复 非null则select得到单个或多个值
            norepeat=regiService.doNorepeat(regiNumber);
        }
       regiact.setRegiNumber(regiNumber);
//        配置结束,准备执行数据库操作接口
        int signs=regiService.doAddact(regiact);
        if (signs==1){
            System.out.println(signs);
            return regiNumber; //如果为1则添加成功，返回随机生成的文章ID，并传给前端，如0则失败返回0
        }else{
            return 0;
        }
    }
//    toActDetail
    @ResponseBody
    @RequestMapping("/toActDetail/{regiNumber}")
    public Regiact doshowDetail(@PathVariable Integer regiNumber){
        Regiact regiact1=regiService.getNumbertoselect(regiNumber);
        return regiact1;
}
    @ResponseBody
    @RequestMapping("/hello")
    public String he(){
        System.out.println("连通");
        return "连通";
    }

    @Configuration
    @EnableWebMvc
    public class MyWebMvcConfiguration implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            /**
             * 配置资源映射
             * 意思是：如果访问的资源路径是以“/images/”开头的，
             * 就给我映射到本机的“E:/images/”这个文件夹内，去找你要的资源
             * 注意：E:/images/ 后面的 “/”一定要带上
             */
            registry.addResourceHandler("/images/**")
                    .addResourceLocations("file:" + uploadPathImg);
        }

    }
//    全局变量 定义保存路径
    private String uploadPathImg="E:/userImg/";
    @ResponseBody
    @RequestMapping(value = "/upload",produces = "text/html;charset=utf-8")
    public void uploadFile(@RequestParam("file") MultipartFile mutifile, HttpServletRequest request) {
        // 1：空判断
        if (mutifile.isEmpty()) {
            System.out.println("文件为空！！！");
        }
        mutifile.getSize();//得到大小
        mutifile.getOriginalFilename();//得到文件名
        String contentType = mutifile.getContentType();//得到文件类型
        System.out.println("fileName:"+mutifile.getOriginalFilename());
        System.out.println("contentType:"+contentType);
        // 2：判断文件是否符合
        if (!"image/png".equals(contentType) &&
                !"image/jpg".equals(contentType)&&
                !"image/jpeg".equals(contentType)) {
            System.out.println("文件格式不符合");
        }
        //3.给文件重新设置一个名字
        //后缀
        String suffix = mutifile.getOriginalFilename().substring(mutifile.getOriginalFilename().lastIndexOf("."));
        String newFileName= UUID.randomUUID().toString().replaceAll("-", "")+suffix;
        //4.创建这个新文件
        File newFile = new File(uploadPathImg  + newFileName);
        //5.复制操作
        try {
            mutifile.transferTo(newFile);
            //协议 :// ip地址 ：端口号 / 文件目录(/images/2020/03/15/xxx.jpg)
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/images/"  + newFileName;
            System.out.println("图片上传，访问URL：" + url);

        } catch (IOException e) {
            System.out.println("上传失败");
        }
    }

//        @RequestMapping("/upload")
//        public Object upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest req, Company company) throws IOException {
//            try {
//                if (file != null) {
//                    String fileName = System.currentTimeMillis() + file.getOriginalFilename();
//                    String upload_file_dir=uploadPathImg;//注意这里需要添加目录信息
//                    String destFileName =  uploadPathImg +fileName;
//                    //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
//                    File upload_file_dir_file = new File(upload_file_dir);
//                    if (!upload_file_dir_file.exists())
//                    {
//                        upload_file_dir_file.mkdirs();
//                    }
//                    //5.把浏览器上传的文件复制到希望的位置
//                    File targetFile = new File(upload_file_dir_file, fileName);
//                    file.transferTo(targetFile);
//                    company.setBusinessLicenseUrl(fileName);
//                }
//                companyMapper.addCompay(company);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//            return company;
//        }
//    }

    /**
     * 显示当前登录用户已发布的活动
      * @param userAcc
     * @return records-manageAct.vue
     */
@ResponseBody
@RequestMapping("/record/{userAcc}")
public List<Record> selectUserAct(@PathVariable String userAcc){
    List<Record> records =recordService.selectUserAct(userAcc);
    System.out.println("record:"+records);
    return records;
}

@ResponseBody
@RequestMapping("/record2/{rexNumber}")
public List<Regiact> selectRecNumber(@PathVariable String rexNumber){
    Integer recNumber=0;
    recNumber=Integer.valueOf(rexNumber);
    List<Regiact> regiact1=recordService.getNumberSelect(recNumber);
    System.out.println("record2:"+regiact1);
    return regiact1;
}

    /**
     * doShow 查看活动的报名用户
     * @param recNumber
     * @return sign(List<Sign>)
     */
    @ResponseBody
    @RequestMapping("/manageStu/{recNumber}")
    public List<Sign> manageStu(@PathVariable Integer recNumber){
        List<Sign> sign=signService.getSignNumberUser(recNumber);
        // 返回所有用户ID和名字
        return sign;
    }

    /**
     * doSignAct 用户点击报名活动
     * @param sign
     * @return signNums(int)
     */
    @ResponseBody
    @RequestMapping("/doSignAct")
    public int doSignAct(@RequestBody Sign sign){
        int signNums=signService.doSignAct(sign);
        return signNums;
    }



}
