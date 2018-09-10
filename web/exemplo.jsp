

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="br.iesb.Calculadora" import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
                
        <%
            Calculadora c = new Calculadora(4);
            out.println(c.getCalculadora());
        %>
        
        Olá JSP! Qual o tempo agora?
        
        <%
            Date date = new Date();
            out.println(date);
            out.println("<br>Endereço da sua máquina é ");
            out.println(request.getRemoteHost());
        %>
        <p>
            Hoje é : <%= (new java.util.Date()).toLocaleString()%>
        </p>
    </body>
</html>
