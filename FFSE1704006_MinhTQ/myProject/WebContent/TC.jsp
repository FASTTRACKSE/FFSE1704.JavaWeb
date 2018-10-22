<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>bạn là ai </h1>
	<!-- <h:commandLink value="first" action="#{nhanVienController.showPage()}"
			rendered="#{nhanVienController.currentPage gt 2}">
			<f:param name="page" value="1" />
			<h:outputText value="&#160;" />
		</h:commandLink>
		<h:commandLink value="&lt;" action="#{nhanVienController.showPage()}"
			rendered="#{nhanVienController.currentPage ne 1}">
			<f:param name="page" value="#{nhanVienController.currentPage - 1}" />
			<h:outputText value="&#160;" />
		</h:commandLink>

		<ui:repeat var="next" value="#{nhanVienController.pageLink}">
			<h:commandLink value="next" action="#{sinhVienForm.showPage()}"
				rendered="#{next ne sinhVienForm.currentPage}">
				<f:param name="page" value="#{next}" />
			</h:commandLink>
			<h:outputText value="#{next}"
				rendered="#{next eq nhanVienController.currentPage}" />
			<h:outputText value="&#160;" />
		</ui:repeat>

		<h:commandLink value="&gt;" action="#{nhanVienController.showPage()}"
			rendered="#{nhanVienController.currentPage ne nhanVienController.totalPage}">
			<f:param name="page" value="#{nhanVienController.currentPage + 1}" />
			<h:outputText value="&#160;" />
		</h:commandLink>
		<h:commandLink value="last" action="#{nhanVienController.showPage()}"
			rendered="#{nhanVienController.currentPage lt (nhanVienController.totalPage - 1)}">
			<f:param name="page" value="#{nhanVienController.totalPage}" />
		</h:commandLink>
 -->
</body>
</html>