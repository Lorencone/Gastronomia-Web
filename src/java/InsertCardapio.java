import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/InsertCardapio"})
public class InsertCardapio extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            String query = "select * from cardapio";    
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>");
            out.println("<title>Servlet InsertCategorias</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Cadastro</h1>");
            out.println("<form class='form-horizontal' action='InsertCategoria' method='POST'>");
            out.println("<div class='form-group'>");
            out.println("<label for='nome' class='col-sm-2 control-label'>Nome</label>");
            out.println("<div class='col-sm-10'>");
            out.println("<input type='text' class='form-control' id='nome' name='nome'/>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='descricao' class='col-sm-2 control-label'>Descrição</label>");
            out.println("<div class='col-sm-10'>");
            out.println("<input type='text' class='form-control' id='descricao' name='descricao'/>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='qtd' class='col-sm-2 control-label'>Quantidade</label>");
            out.println("<div class='col-sm-10'>");
            out.println("<input type='text' class='form-control' id='qtd' name='qtd'/>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='valor_venda' class='col-sm-2 control-label'>Valor de Venda</label>");
            out.println("<div class='col-sm-10'>");
            out.println("<input type='text' class='form-control' id='valor_venda' name='valor_venda'/>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='valor_compra' class='col-sm-2 control-label'>Valor de Compra</label>");
            out.println("<div class='col-sm-10'>");
            out.println("<input type='text' class='form-control' id='valor_compra' name='valor_compra'/>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='categoria_id' class='col-sm-2 control-label'>Categoria</label>");
            out.println("<div class='col-sm-10'>");
            out.println("<select class='form-control' id='categoria_id' name='categoria_id'>");
            out.println("<option value''>Selecione</option>");
           
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                out.println("<option value='"+rs.getInt("id_categoria")+"'>"+rs.getString("nome")+"</option>");
            }
            out.println("</select>");
            out.println("</div>");
            out.println("</div>");                      
            out.println("<div class='form-group'>");
            out.println("<div class='col-sm-offset-2 col-sm-10'>");
            out.println("<button type='submit' class='btn btn-success'>Enviar</button>");
            out.println("<a href='././CategoriaServlet' class='btn btn-danger'>Voltar</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            query = "insert into categorias(nome, categorias_id) values(?,?)";
            
            if( request.getParameter("nome")!= null){
               
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, request.getParameter("nome"));
                preparedStmt.setString (2, request.getParameter("categorias_id"));
                preparedStmt.execute();
                con.close();
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertCardapio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertCardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertCardapio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertCardapio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}