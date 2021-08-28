<%@page session="true" %>
<%
    HttpSession s =request.getSession();
    s.setAttribute("valido", false);
    s.setAttribute("Usuario", null);
    s.setAttribute("mensaje", null);
    response.sendRedirect("../index.jsp");
%>
