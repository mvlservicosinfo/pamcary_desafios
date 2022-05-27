package br.com.dominio.cpfweb.View;

import br.com.dominio.cpfweb.Model.ModelCPF;
import kong.unirest.Unirest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_CPF", value = "/Servlet_CPF")
public class Servlet_CPF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModelCPF m = new ModelCPF();
        response = (HttpServletResponse) Unirest.get("https://www.sintegraws.com.br/api/v1/execute-api.php")
                .queryString("token",m.getToken() )
                .queryString("cpf", m.getCPF())
                .queryString("data-nascimento", m.getData_nascimento())
                .queryString("plugin", m.getPlugin())
                .asString();
    }


}
