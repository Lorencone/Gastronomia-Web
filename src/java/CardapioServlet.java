import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/CardapioServlet"})
public class CardapioServlet extends HttpServlet {
    
    String usuario, senha;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(true);
        if(!session.getAttribute("codigo").equals("123")){
            response.sendRedirect("/LoginServlet");
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>");
            out.println("<title>Servlet CardapioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Itens do Cardápio</h1>");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");

            Statement st = con.createStatement();


            String query = "select a.*, b.nome as categoria"
                    + " from cardapio as a inner join categoria as b "
                    + "on a.id_categoria = b.id_categoria";
            
            ResultSet rs = st.executeQuery(query);
      
            out.println("<table class='table table-bordered table-striped table-hover'>");
            out.println("<tr>");
            out.println("<th>Ação</th>");
            out.println("<th>Id_Cardapio</th>");
            out.println("<th>Nome</th>");
            out.println("<th>Quantidade</th>");
            out.println("<th>Preço de Venda</th>");
            out.println("<th>Categoria</th>");
            out.println("</tr>");
      
        while (rs.next())
        {

            out.println("<tr>");
            out.println("<td>");
            out.println(rs.getInt("id_cardapio"));
            out.println("</td>");
            out.println("<td>");
            out.println(rs.getString("nome"));
            out.println("</td>");
            out.println("<td>");
            out.println(rs.getDouble("qtd"));
            out.println("</td>");
            out.println("<td>");
            out.println(rs.getDouble("valor_venda"));
            out.println("</td>");
            out.println("<td>");
            out.println(rs.getString("categoria"));
            out.println("</td>");
            out.println("</tr>");



        }
        st.close();
          out.println("</table>");
          out.println("<form>");
          out.println("<a class='btn btn-warning' href='././InsertCardapio'>Inserir</a>");
          out.println("<a class='btn btn-danger' href='././MenuServlet'>Voltar</a>");
          out.println("</form>");
          out.println("</div>");
          out.println("</body>");
          out.println("</html>");
          }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


  
}
