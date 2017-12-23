package org.tag.mytab;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.tag.entity.Pagination;

import com.sun.xml.internal.bind.CycleRecoverable.Context;

public class findByPage extends tagAttribute {

	/**
	 * ��ѯform��Id,Ĭ��ΪqueryForm
	 */
	private String queryForm = "queryForm";

	/**
	 * ��ҳdiv,Ĭ��ΪpaginationId
	 */
	private String divId = "paginationId";
	/**
	 * ��ҳ��ʽ,Ĭ��Ϊtechnorati
	 */
	private String divClass = "technorati";

	@Override
	public int doStartTag() throws JspException {

		HttpSession ses = pageContext.getSession();
		Pagination page = (Pagination) ses.getAttribute("page");

		int index = page.getIndex();
		int prev = index - 1;
		int next = index + 1;
		int last = page.getMaxPage();

		ses.setAttribute("jsp", jsp);

		if (state) {

			StringBuffer strBuf = new StringBuffer();
			strBuf.append("<div id=\"").append(divId).append("\" class=\"")
					.append(divClass).append("\">");

			// ��һҳ
			if (page.getIndex() == 1) {
				// strBuf.append(" <a href=\"#\"><span class=\"first_link\">��ҳ</span></a> ");
				strBuf.append(" <span class=\"disabled\">").append(
						" << </span> ");
			} else {
				// strBuf.append(" <a href=\"#\" onclick=\"paga_toPage(1);\"><span class=\"first_link\">��ҳ</span></a> ");
				strBuf.append(" <a href=\"page?index=" + prev + "\" > << </a> ");
			}

			for (int i = page.getIndex(); i <= page.getMaxPage(); i++) {
				if (page.getIndex() == i) {
					strBuf.append("<span class=\"current\">").append(i)
							.append("</span>");
				} else {
					strBuf.append("<a href=\"page?index=" + i + "\">")
							.append(i).append("</a>");
				}
			}

			// ��һҳ
			if (page.getIndex() == page.getMaxPage()) {
				strBuf.append(" <span class=\"disabled\">").append(
						" >> </span> ");
				// strBuf.append(" <a href=\"#\"><span class=\"end_link\">ĩҳ</span></a> ");
			} else {
				strBuf.append(" <a href=\"page?index=" + next + "\" > >> </a> ");
				// strBuf.append(" <a href=\"#\" onclick=\"paga_toPage(").append(pagination.getTotalPage()).append(")\"><span class=\"end_link\">ĩҳ</span></a> ");
			}

			strBuf.append("<span class=\"info\">(��")
					.append(page.getIndex())
					.append("/")
					.append(page.getMaxPage())
					.append("ҳ")
					.append("&nbsp;ÿҳ��ʾ <select  onchange=\"window.location.href=\'page?index=1&size=\'+this.value\">");
			if (page.getSize() == 3) {
				strBuf.append("<option selected=\"selected\">3</option>");
			} else {
				strBuf.append("<option>3</option>");
			}
			if (page.getSize() == 5) {
				strBuf.append("<option selected=\"selected\">5</option>");
			} else {
				strBuf.append("<option>5</option>");
			}
			if (page.getSize() == 10) {
				strBuf.append("<option selected=\"selected\">10</option>");
			} else {
				strBuf.append("<option>10</option>");
			}
			if (page.getSize() == 50) {
				strBuf.append("<option selected=\"selected\">50</option>");
			} else {
				strBuf.append("<option>50</option>");
			}
			if (page.getSize() == 100) {
				strBuf.append("<option selected=\"selected\">100</option>");
			} else {
				strBuf.append("<option>100</option>");
			}

			strBuf.append("</select>��&nbsp;");
			strBuf.append(" ��").append(page.getTotal()).append("��)</span>");

			strBuf.append("</div>");
			// System.out.println(strBuf.toString());

			try {
				JspWriter out = pageContext.getOut();
				out.print(strBuf.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return super.doStartTag();
	}

}
