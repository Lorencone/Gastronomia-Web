<%@page import="java.sql.*, java.io.*, java.util.*, javax.servlet.*" contentType="text/html" pageEncoding="UTF-8"%>

<%
   Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");

    Statement st = con.createStatement();

    String query = "select * from categoria";

    ResultSet rs = st.executeQuery(query);             
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    </head>
    <body>
        <div class='container'>              
            <h1>Cardapio</h1>
            <h2>Itens do Cardápio</h2>            
            <table class='table table-bordered table-striped table-hover'>
                <tr>
                    <th>Ação</th>
                    <th>Id_Categoria</th>
                    <th>Nome</th>
                    <th>Categoria_Id</th>                    
                </tr>
                    <%
                        while (rs.next())
                        {  
                    %>
                        <tr>
                            <td>
                                <a class='btn' href='../Gastronomia/InsertCategoria.jsp'>Alterar</a>
                                <a class='btn' href='../Gastronomia/InsertCategoria.jsp'>Excluir</a>
                            </td>
                            <td>
                                <%
                                    out.println(rs.getInt("id_categoria"));
                                %>
                            </td>
                            <td>
                                <%
                                    out.println(rs.getString("nome"));
                                %>
                            </td>
                            <td>
                                <%
                                    out.println(rs.getDouble("categoria_id"));
                                %>                                
                            </td>                            
                        </tr>
                <%
                    }
                    st.close();
                %>
            </table>
            <form>
                <a class='btn btn-warning' href='../Gastronomia/InsertCardapio.jsp'>Inserir</a>
                <a class='btn btn-danger' href='../Gastronomia/Index.jsp'>Voltar</a>
            </form>                    
        </div>
    </body>
</html>
