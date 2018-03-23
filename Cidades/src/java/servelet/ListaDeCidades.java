package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

@WebServlet(name = "ListaDeCidades", urlPatterns = "/")
public class ListaDeCidades extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String rq = (request.getRequestURI());

        if (rq.charAt(rq.length() - 1) == 'A') {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/aula01_web2?autoReconnect=true&useSSL=false", "root", "");

                PreparedStatement ps = conexao.prepareStatement("SELECT nome FROM cidades");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (rs.getString("nome").charAt(0) == 'A') {
                        writer.println("<html><body><li>" + rs.getString("nome") + "</li></body></html>");
                    }
                }

            } catch (Exception e) {
            }
        } 
        
        if(rq.charAt(rq.length() - 1) == 'B')

            try {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/aula01_web2?autoReconnect=true&useSSL=false", "root", "");

                PreparedStatement ps = conexao.prepareStatement("SELECT nome FROM cidades");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (rs.getString("nome").charAt(0) == 'B') {
                        writer.println("<html><body><li>" + rs.getString("nome") + "</li></body></html>");
                    }
                }
            } catch (Exception e) {
        } 

        if(rq.charAt(rq.length() - 1) == 'C')

            try {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/aula01_web2?autoReconnect=true&useSSL=false", "root", "");

                PreparedStatement ps = conexao.prepareStatement("SELECT nome FROM cidades");
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    if (rs.getString("nome").charAt(0) == 'C') {
                        writer.println("<html><body><li>" + rs.getString("nome") + "</li></body></html>");
                    }
                }
            } catch (Exception e) {
        }         
        
    }

}
