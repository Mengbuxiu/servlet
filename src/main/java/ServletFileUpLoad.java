import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-servlet/
 * @author zhenglin
 * @date 2019/04/03
 */
@WebServlet("/upload.do")
@MultipartConfig
public class ServletFileUpLoad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("file-input.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Part part = req.getPart("myfile");
        String disposition = part.getHeader("Content-Disposition");
        String suffix = disposition.substring(disposition.lastIndexOf("."),disposition.length()-1);
        //获取上传的文件名
        String filename = UUID.randomUUID()+suffix;
        InputStream is = part.getInputStream();
        //动态获取服务器的路径
        String serverPath = req.getServletContext().getRealPath("/");
        String name = serverPath + filename;
        File path = new File(name);

        if (!path.exists()) {
            path.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(name);
        byte[] bty = new byte[1024];
        int length =0;
        while((length=is.read(bty))!=-1){
            fos.write(bty,0,length);
        }
        fos.close();
        is.close();
        // 该如何等比？
        ImageUtil.changeSize(name);
    }
}
