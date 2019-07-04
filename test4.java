  编写一个servlet。servlet的功能要求：记录访问该servlet的客户端的ip和访问时间，把记录写入client_ip.log文件。client_ip.log里的格式大致如下：
9:36 25-4-8 192.168..1
9:36 25-4-8 127...1部分代码已给出：


public class WriteFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			File FileclientIp = new File("E:/桌面/client_ip.log");
			FileOutputStream fos = new FileOutputStream(FileclientIp);
			String clientIp = request.getRemoteAddr();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm yyyy-MM-dd");
			Date date = new Date();
			String currDate = sdf.format(date);
			String clientIpLog = currDate + " " + clientIp;
			fos.write(clientIpLog.getBytes());
			fos.flush();
			fos.close();
		} catch (Exception e) {

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			doGet(request, response);
		} catch (Exception e) {

		}
	}
}
