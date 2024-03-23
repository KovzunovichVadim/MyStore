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

@WebServlet("/create")
public class AccountCreateServlet extends HttpServlet {
    private  AccountRepository accountRepository;
    private Account account;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        accountRepository = new AccountRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/create-update-account.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        Account newAccount = new Account(firstname, lastname, email);
        req.setAttribute("account", newAccount);
        accountRepository.createAccount(newAccount);
        req.getRequestDispatcher("/pages/read-account.jsp").forward(req,resp);
    }
}
