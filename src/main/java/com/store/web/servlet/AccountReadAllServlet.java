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
import java.util.List;

@WebServlet("/list")
public class AccountReadAllServlet extends HttpServlet {
    AccountRepository accountRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        accountRepository = new AccountRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> listAccount = accountRepository.readAllAccount();
        req.setAttribute("listAccount", listAccount);
        req.getRequestDispatcher("/pages/list-account.jsp").forward(req, resp);
    }
}
