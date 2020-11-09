package fr.arsenelapostolet.bank.controller;

import fr.arsenelapostolet.bank.domain.Account;
import fr.arsenelapostolet.bank.services.AccountService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/createAccount")
public class CreateAccountController extends HttpServlet {

    @EJB
    private AccountService accountService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountType = request.getParameter("accountType");
        switch (accountType) {
            case "current" -> accountService.createCurrentAccount(new BigDecimal(request.getParameter("overdraftRate")));
            case "savings" -> accountService.createSavingsAccount(new BigDecimal(request.getParameter("overdraftRate")));
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/createAccount.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/createAccount.jsp").forward(request, response);
    }
}
