package com.workmexh.common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
// 普通类 邮箱发送功能
@Controller
public class LoginMail {
    @Resource
    private JavaMailSenderImpl mailSender;
    @Autowired
    private MailUtils mailUtils;
    @Value("${spring.mail.username}")
    private String mailto;

    @ResponseBody
    @RequestMapping("/Mail")
    public void sendEmail(){
        mailUtils.sendSimpleEmail("3122518422@qq.com","123","456");
    }
    @ResponseBody
    @RequestMapping("/Mail1")
    public void sendMail2(){
        System.out.println("成功");
    }
}
