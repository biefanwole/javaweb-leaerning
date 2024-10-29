package cookie;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookieDemo01")
public class CookieDemo01 extends HttpServlet {
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp){
        Cookie cookie = new Cookie("username", "zhangsan");
        resp.addCookie(cookie);
cookie.setMaxAge(60*60*24*7);//cookie存活时间
    }

}
