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

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    String usuario, senha;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" </link>");
            out.println("<title>Servlet LoginServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Login</h1>");
            out.println("<form class='form-horizontal' action='LoginServlet' method='post'>");
            out.println("<div class='form-group'>");
            out.println("<label for='nome' class='col-sm-2 control-label'>Login</label>");
            out.println("<div class='col-sm-10'>");
            out.println("<input type='text' class='form-control' id='usuario' name='nome'/>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='senha' class='col-sm-2 control-label'>Senha</label>");
            out.println("<div class='col-sm-10'>");
            out.println("<input type='password' class='form-control' id='senha' name='senha'/>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<div class='col-sm-offset-2 col-sm-10'>");
            out.println("<button type='submit' class='btn btn-primary'>Login</button>");
            out.println("</div>");
            out.println("</div>");
            out.print("</form>");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select * from login");
      
     
            while (rs.next())
            {
              int id = rs.getInt("id_login");
              usuario = rs.getString("usuario");
              senha = rs.getString("senha");

              if( usuario.equals(request.getParameter("nome")) && senha.equals(request.getParameter("senha"))){
                  HttpSession session = request.getSession(true);
                  session.setAttribute("codigo", "123");

                  RequestDispatcher dispatcher = getServletContext()
                  .getRequestDispatcher("/MenuServlet"); 
                dispatcher.forward(request, response);
              }

            }
            st.close();

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