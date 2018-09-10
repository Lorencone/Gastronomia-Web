<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
    </head>
    <body>
        <div class="container">
            <h3>Teste de Loop </h1>
            <table class="striped responsive-table">
            <%
                int n = 10;
                for(int i = 0; i < n; i++){
            %>
            <tr>
                <td>Number</td>
                <td><%= i+1 %></td>
            </tr>
            <%
                }
            %>
            </table>
        </div>
    </body>
</html>
