<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String texto;
            texto = request.getParameter("frase");
            session.setAttribute("usuario", texto);
            response.sendRedirect("lesession.jsp");
        %>
    </body>
</html>
