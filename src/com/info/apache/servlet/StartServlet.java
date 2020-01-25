package com.info.apache.servlet;

import com.info.apache.jdbc.service.AccountService;
import com.info.apache.jdbc.service.AccountServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/start")
public class StartServlet extends HttpServlet {

    private AccountService accountService;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/index").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(accountService.entry(login, password)){
            RequestDispatcher dispatcher = req.getRequestDispatcher("Welcome");
            dispatcher.forward(req, resp);
        } else {
            out.println("Sorry username or password error");
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.include(req, resp);
        }
        out.close();
    }
}
