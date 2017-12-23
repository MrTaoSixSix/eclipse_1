package org.tag.mytab;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.tag.dao.BaseDao;
import org.tag.entity.Pagination;

public class findAllTag extends tagAttribute{

	@Override
	public int doStartTag() throws JspException {
		
		HttpSession ses = pageContext.getSession();
		Pagination page = (Pagination) ses.getAttribute("page");
		if(page==null){
			page = new Pagination();
		}
		ses.setAttribute(listName, dao.findAll(dbName, name, pwd, dtName, page,state).getRows()); 
		page.setTotal(dao.getCount(dbName, name, pwd, dtName, page));
		ses.setAttribute("page", page);
		return super.doStartTag();
	}

	
	
}
