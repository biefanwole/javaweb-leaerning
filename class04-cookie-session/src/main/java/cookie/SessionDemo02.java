package cookie;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/sessionDemo02")

public class SessionDemo02 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession();
//        session,invaldate();
        Object username=session.getAttribute("username");
        System.out.println(username);
    }

}
