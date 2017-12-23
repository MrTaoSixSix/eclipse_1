package org.tag.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.tag.entity.Pagination;



/**
 * 
* @ClassName: pageServlet 
* @Description: TODO(������һ�仰��������������) 
* @author fsjohnhuang
* @date 2017��12��23�� ����5:05:48 
* �½��˷�֧
 */
@WebServlet(name = "page", urlPatterns = { "/page" })
public class pageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();

		int index = Integer.parseInt(request.getParameter("index"));

		Pagination page = (Pagination) ses.getAttribute("page");

		int size = (request.getParameter("size") != null) ? Integer
				.parseInt(request.getParameter("size")) : page.getSize();

		if (size > 0) {
			page.setSize(size);
		}

		page.setIndex(index);

		request.getRequestDispatcher(ses.getAttribute("jsp") + ".jsp").forward(
				request, response);
	}

}
