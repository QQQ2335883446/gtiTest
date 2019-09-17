package servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.VerifyCode;

@WebServlet("/verify")
public class VerifyCodeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VerifyCode verifyCode = new VerifyCode();
		OutputStream out = response.getOutputStream();
		VerifyCode.output(verifyCode.getImage(), out);
		request.getSession().setAttribute("verify", verifyCode.getText());//把验证码存入到session对象中
		out.flush();
		out.close();
	}
	
}
