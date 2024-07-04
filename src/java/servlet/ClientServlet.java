/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

/**
 *
 * @author ninza
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet {
    private List<Client> clients = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/admin/manageClients.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            clients.add(new Client(clients.size() + 1, username, password, email, address));
        } else if ("delete".equals(action)) {
            int clientID = Integer.parseInt(request.getParameter("clientID"));
            clients.removeIf(client -> client.getClientID() == clientID);
        } else if ("update".equals(action)) {
            int clientID = Integer.parseInt(request.getParameter("clientID"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            for (Client client : clients) {
                if (client.getClientID() == clientID) {
                    client.setUsername(username);
                    client.setPassword(password);
                    client.setEmail(email);
                    client.setAddress(address);
                    break;
                }
            }
        }
        response.sendRedirect("/clients");
    }
}
