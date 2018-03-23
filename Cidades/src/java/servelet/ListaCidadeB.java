/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gabri
 */
@WebServlet(name = "SegundaServelet", urlPatterns = {"/helloB"})
public class ListaCidadeB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter writer = response.getWriter();
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/aula01_web2?autoReconnect=true&useSSL=false", "root", "");
            
            PreparedStatement ps = conexao.prepareStatement("SELECT nome FROM cidades");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                if(rs.getString("nome").charAt(0) == 'B'){
                    writer.println("<html><body><li>" + rs.getString("nome") + "</li></body></html>");
                } 
            }            
        } catch (Exception e) {
            writer.println(e);
        }   
    }

}
