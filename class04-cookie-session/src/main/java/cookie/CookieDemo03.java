package cookie;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/cookieDemo03")

public class CookieDemo03 extends HttpServlet {
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp){

String value = "zhangsan";
        Cookie cookie = new Cookie("username", URLEncoder.encode(value, StandardCharsets.UTF_8));
        resp.addCookie(cookie);
        cookie.setMaxAge(60*60*24+7);
    }

}