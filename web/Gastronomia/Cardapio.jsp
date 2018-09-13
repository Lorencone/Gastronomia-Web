<%@page import="java.sql.*, java.io.*, java.util.*, javax.servlet.*" contentType="text/html" pageEncoding="UTF-8"%>

<%
   Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");

    Statement st = con.createStatement();

    String query = "select a.*, b.nome as categoria"
            + " from cardapio as a inner join categoria as b "
            + "on a.id_categoria = b.id_categoria";

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
                    <th>Id_Cardapio</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço de Venda</th>
                    <th>Categoria</th>
                </tr>
                    <%
                        while (rs.next())
                        {  
                    %>
                        <tr>
                            <td>
                                <%
                                    out.println(rs.getInt("id_cardapio"));
                                %>
                            </td>
                            <td>
                                <%
                                    out.println(rs.getString("nome"));
                                %>
                            </td>
                            <td>
                                <%
                                    out.println(rs.getDouble("qtd"));
                                %>                                
                            </td>
                            <td>
                                <%
                                    out.println(rs.getDouble("valor_venda"));
                                %>
                            </td>
                            <td>
                                <%
                                    out.println(rs.getString("categoria"));
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
