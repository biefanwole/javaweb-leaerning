package cookie;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/cookieDemo04")

public class CookieDemo04 extends HttpServlet {
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                String value =cookie.getValue();
                String username = URLDecoder.decode(value, StandardCharsets.UTF_8);
                System.out.println("获取到用户名是："+username);
            }

        }
    }

}