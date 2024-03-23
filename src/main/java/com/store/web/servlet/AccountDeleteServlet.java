package com.store.web.servlet;

import com.store.repository.AccountRepository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete")
public class AccountDeleteServlet extends HttpServlet {
    private AccountRepository accountRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        accountRepository = new AccountRepository();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = (long) Integer.parseInt(req.getParameter("id"));
        accountRepository.deleteUser(id);
        resp.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
