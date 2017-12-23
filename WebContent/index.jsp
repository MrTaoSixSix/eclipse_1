<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="Http://org.tag.showData" prefix="p"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
/*CSS technorati style pagination*/
DIV.technorati {
	PADDING-RIGHT: 3px;
	PADDING-LEFT: 3px;
	PADDING-BOTTOM: 3px;
	MARGIN: 3px;
	PADDING-TOP: 3px;
	TEXT-ALIGN: center
}

DIV.technorati A {
	BORDER-RIGHT: #ccc 1px solid;
	PADDING-RIGHT: 6px;
	BACKGROUND-POSITION: 50% bottom;
	BORDER-TOP: #ccc 1px solid;
	PADDING-LEFT: 6px;
	FONT-WEIGHT: bold;
	PADDING-BOTTOM: 2px;
	BORDER-LEFT: #ccc 1px solid;
	COLOR: rgb(66, 97, 222);
	MARGIN-RIGHT: 3px;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #ccc 1px solid;
	TEXT-DECORATION: none
}

DIV.technorati A:hover {
	BACKGROUND-IMAGE: none;
	COLOR: #fff;
	BACKGROUND-COLOR: #4261df
}

DIV.technorati A:active {
	BACKGROUND-IMAGE: none;
	COLOR: #fff;
	BACKGROUND-COLOR: #4261df
}

DIV.technorati SPAN.current {
	PADDING-RIGHT: 6px;
	PADDING-LEFT: 6px;
	FONT-WEIGHT: bold;
	PADDING-BOTTOM: 2px;
	COLOR: #000;
	MARGIN-RIGHT: 3px;
	PADDING-TOP: 2px
}

DIV.technorati SPAN.disabled {
	BORDER-RIGHT: #eee 1px solid;
	PADDING-RIGHT: 5px;
	BORDER-TOP: #eee 1px solid;
	PADDING-LEFT: 5px;
	PADDING-BOTTOM: 2px;
	MARGIN: 2px;
	BORDER-LEFT: #eee 1px solid;
	COLOR: #ddd;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #eee 1px solid /* DISPLAY: none */
}
</style>
</head>
<body>
	<h1>显示数据</h1>
	<p:showData name="root" dtName="info" dbName="temp" pwd="root" />
	<table width="80%" border="1" style="margin: 0px auto">


		<c:forEach items="${list}" var="obj">
			<tr>
				<td>${obj.id}</td>
				<td>${obj.name}</td>
				<td>${obj.gender}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3"><p:page /></td>
		</tr>
		

	</table>
</body>
</html>