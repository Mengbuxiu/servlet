import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author zhenglin
 * @date 2019/04/03
 */
@WebServlet("/test.do")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("this is get request");
        String sessionId = req.getRequestedSessionId();
        System.out.println(sessionId);
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println(servletConfig.getServletName());
        Enumeration initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            System.out.println(initParameterNames.toString());
        }
        System.out.println(servletConfig.getServletContext().toString());
        System.out.println(this.getServletInfo());
        // req.getRequestDispatcher("success.jsp").forward(req,resp);
        resp.sendRedirect("success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println("this is post request");
    }
}
