import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class MyServlet extends HttpServlet {
    private File clientIp;
    private FileOutputStream fos;
     
    public MyServlet() {
        super();
    }
 
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }
     
    public void service(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        openFileOutputStream();
        String clientIp = req. getRemoteAddr();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm yyyy-MM-dd");
        Date date = new Date();
        String currDate = sdf.format(date);
        String clientIpLog = clientIp + " " + currDate;
        this.fos.write(clientIpLog.getBytes());
        this.fos.flush();
        closeFileOutputStream();
    }
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out
                .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
 
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out
                .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
 
    public void init() throws ServletException {
        clientIp = new File("D:\\client_ip.log");       
    }
     
    private void openFileOutputStream() {
        try {
            fos = new FileOutputStream(clientIp);
        }
        catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }
     
    private void closeFileOutputStream() {
        try {
            fos.close();
            fos = null;
        }
        catch(IOException fnfe) {
            fnfe.printStackTrace();
        }
    }
}
