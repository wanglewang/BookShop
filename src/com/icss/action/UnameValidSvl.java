package com.icss.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bll.UserBiz;
import com.icss.exception.InputEmptyException;

/**
 * Servlet implementation class UnameValidSvl
 */
@WebServlet("/UnameValidSvl")
public class UnameValidSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnameValidSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			  throws ServletException, IOException {
		String uname = request.getParameter("uname");
		PrintWriter out = response.getWriter();
		UserBiz biz = new UserBiz();
		try {
			boolean bRet = biz.validUname(uname);	
			if(bRet) {
				out.print("1");      //用户名冲突
			}else {
				out.print("0");      //用户名可以用
			}
		}catch(InputEmptyException e) {	
			out.print("-2");          //表示输入为空
		} catch (Exception e) {
			out.print("-1");         //异常返回-1
		}		
		out.flush();
		out.close();
	}


}
