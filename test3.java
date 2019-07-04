	编写程序实现登录功能，要求：
页面使用jsp表单提交，包含姓名和密码
提交目的地为Servlet，在Servlet中获得表单提交的数据
在Servlet中判断，如果姓名是“张三”，密码是“123”，返回客户登录成功
写出核心代码即可
	public class login extends HttpServlet {
	
		public void doGet(HttpServletRequest request, HttpServletResponse response) {
			try {
				doPost(request, response);
			} catch (Exception e) {
				}
		}
	
		public void doPost(HttpServletRequest req, HttpServletResponse resp) {
			try {
				req.setCharacterEncoding("utf-8");
				String name = req.getParameter("uname");
				String pwd = req.getParameter("pwd");
	
				if (name.equals("张三") && pwd.equals("123")) {
					resp.getWriter().println("<p>success</p>");
				} else {
					resp.getWriter().println("<p>fail</p>");//这里不用用中文，要不然错误
				}
			} catch (Exception e) {
				
			}
	
		}
	
	}



<%@ page contentType="text/html;charset=UTF-8" %>
<form action="login" method="post">
        <p>
        	姓名<input type="text" name="uname">
        </p>
        <p>
        	密码<input type="text" name="pwd">
        </p>
        <p>
            <input type="submit" value="登录">
        </p>
 </form>
