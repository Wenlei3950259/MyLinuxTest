package com.demo.controller;

import com.demo.util.CpachaUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/code")
public class CodeController {
    /**
     * 显示 验证码
     *
     * @param request
     * @param response
     * @param vl
     * @param w
     * @param h
     */
    @GetMapping("/checkCode")
    public void generateCpacha(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam(value = "vl", defaultValue = "4", required = false) Integer vl,
                               @RequestParam(value = "w", defaultValue = "110", required = false) Integer w,
                               @RequestParam(value = "h", defaultValue = "39", required = false) Integer h) {
        CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute("code", generatorVCode);
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/getCode")
    @ResponseBody
    public void submitlogin(@Param("code") String code, HttpSession session) {
        if (StringUtils.isEmpty(code)) {
            System.out.println("null");
        }
        if (!code.equalsIgnoreCase((String) session.getAttribute("code"))) {
            System.out.println("验证码错误");
        }
        System.out.println(session.getAttribute("code"));
        String id = session.getId();
        System.out.println(id);
    }
}
