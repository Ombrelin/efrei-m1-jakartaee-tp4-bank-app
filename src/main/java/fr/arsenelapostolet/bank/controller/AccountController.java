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
import java.util.List;

@WebServlet("/accounts")
public class AccountController extends HttpServlet {

    @EJB
    private AccountService accountService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> accounts = accountService.getAccounts();
        System.out.println("Accounts count :");
        System.out.println(accounts.size());
        accounts.forEach(account -> System.out.println(account.getAccountNumber()));
        request.setAttribute("accounts", accounts);
        this.getServletContext().getRequestDispatcher("/WEB-INF/accounts.jsp").forward(request, response);
    }
}
