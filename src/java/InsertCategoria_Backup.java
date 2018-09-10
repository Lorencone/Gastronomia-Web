//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(urlPatterns = {"/InsertCategoria"})
//public class InsertCategoria extends HttpServlet {
//
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, ClassNotFoundException, SQLException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            
//            String query = "select * from categoria";    
//            
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
//            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'/>");
//            out.println("<title>Servlet InsertCategorias</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<div class='container'>");
//            out.println("<form class='form-horizontal' action='InsertCategorias' method='POST'>");
//            out.println("<div class='form-group'>");
//            out.println("<label for='nome' class='col-sm-2 control-label'>Nome</label>");
//            out.println("<div class='col-sm-10'>");
//            out.println("<input type='text' class='form-control' id='nome' name='nome'/>");
//            out.println("</div>");
//            out.println("</div>");
//            out.println("<div class='form-group'>");
//            out.println("<label for='categoria_id' class='col-sm-2 control-label'>Categoria</label>");
//            out.println("<div class='col-sm-10'>");
//            out.println("<select id='categoria_id' name='categorias_id'>");
//           
//            PreparedStatement stmt = con.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery(query);
//            
//            while(rs.next()){
//                out.println("<option value='"+rs.getInt("id_categoria")+"'>"+rs.getString("nome")+"</option>");
//            }
//            out.println("</select>");
//            out.println("</div>");
//            out.println("</div>");
//            out.println("<button type='submit'>Enviar</butto>");
//            out.println("</form>");
//            out.println("</div>");
//            out.println("</body>");
//            out.println("</html>");
//            query = "insert into categorias(nome, categorias_id) values(?,?)";
//            
//            if( request.getParameter("nome")!= null){
//               
//                PreparedStatement preparedStmt = con.prepareStatement(query);
//                preparedStmt.setString (1, request.getParameter("nome"));
//                preparedStmt.setString (2, request.getParameter("categorias_id"));
//                preparedStmt.execute();
//                con.close();
//            }
//        }
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(InsertCategoria.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(InsertCategoria.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(InsertCategoria.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(InsertCategoria.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//}