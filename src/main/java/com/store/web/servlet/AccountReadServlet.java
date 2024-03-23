package com.store.web.servlet;

import com.store.model.Account;
import com.store.repository.AccountRepository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/get")
public class AccountReadServlet extends HttpServlet {
    private AccountRepository accountRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        accountRepository = new AccountRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = (long) Integer.parseInt(req.getParameter("id"));
        Account account = accountRepository.readAccount(id);
        req.setAttribute("account", account);
        req.getRequestDispatcher("pages/read-account.jsp").forward(req, resp);
    }
}
