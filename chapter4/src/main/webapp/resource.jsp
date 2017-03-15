<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.springframework.web.context.support.ServletContextResource" %>
<%@ page import="org.springframework.core.io.Resource" %>
<%@ page import="org.springframework.web.util.WebUtils" %>

<%

    Resource res3 = new ServletContextResource(application, "/WEB-INF/classes/conf/file3.txt");
    out.print(res3.getFilename()+"</br>");
    out.print(WebUtils.getTempDir(application).getAbsolutePath());
%>
