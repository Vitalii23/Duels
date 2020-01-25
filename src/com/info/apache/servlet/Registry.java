package com.info.apache.servlet;

import com.info.apache.jdbc.service.AccountService;
import com.info.apache.jdbc.service.AccountServiceImpl;
import com.info.apache.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Registry extends HttpServlet {

    private AccountService accountService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
       // AccountServiceImpl accountService = new AccountServiceImpl();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (req.getParameter("add") != null){
            accountService.add(login, password);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/registry.jsp");
            dispatcher.forward(req, resp);
        } else {
            writer.checkError();
        }
        writer.close();
    }
}
