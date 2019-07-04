  利用JSP设计一个“简易计算器”，在Computer.html页面中显示计算器界面；在Result.jsp页面中显示结果。部分代码已给出：
Computer.html
<body>
    <form action="result.jsp" method="post">
        操作数1:<input type="text" name="num1" /><br />
        运算符:<select name="op">
            <option value="+">加上(+)</option>
            <option value="-">减去(1)</option>
            <option value="*">乘以(*)</option>
            <option value="/">除以(/)</option>
        </select><br />
        操作数2:<input type="text" name="num2" /><br />
        <input type="submit" value="确定" />
    </form>
</body>

Result.jsp
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<body>
    简易计算器<br />
    <%
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String op = request.getParameter("op");
         
        switch(op) {
        case "+":
            out.println(num1 + op + num2 + "=" + (num1 + num2));
            break;
        case "-":
            out.println(num1 + op + num2 + "=" + (num1 - num2));
            break;
        case "*":
            out.println(num1 + op + num2 + "=" + (num1 * num2));
            break;
        case "/":
            out.println(num1 + op + num2 + "=" + (num1 / num2));
            break;
        default:
            out.println("无效的运算符。");
            break;
        }
    %>
</body>
