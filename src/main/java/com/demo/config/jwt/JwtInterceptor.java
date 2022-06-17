package com.demo.config.jwt;

import com.demo.config.util.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String token = request.getHeader("token");
        try {
            // 1.校验JWT字符串
            JWTUtils.verify(token);
            // 2.取出JWT字符串载荷中的随机token，从Redis中获取用户信息
            map.put("state",200);
            map.put("msg","token验证成功");
            return true;
        } catch (ExpiredJwtException e){
            e.printStackTrace();
            map.put("msg","token已过期");
        }catch (MalformedJwtException e){
//            System.out.println("算法不一致");
            e.printStackTrace();
            map.put("msg","算法不一致");
        }catch (Exception e){
//            System.out.println("token无效");
            e.printStackTrace();
            map.put("msg","token无效");
        }
        map.put("state",400);
//将map转换成json对象返回
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }

}
