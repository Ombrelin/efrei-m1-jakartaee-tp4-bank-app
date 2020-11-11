package fr.arsenelapostolet.bank.controller;

import fr.arsenelapostolet.bank.domain.Operation;
import fr.arsenelapostolet.bank.services.AccountService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/createOperation")
public class OperationsController extends HttpServlet {

    @EJB
    private AccountService accountService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operationType = request.getParameter("operationType");
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        Integer accountId = Integer.parseInt(request.getParameter("accountId"));

        switch (operationType) {
            case "payment" -> accountService.pay(accountId,amount);
            case "withdrawal" -> accountService.withdraw(accountId,amount);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/createOperation.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/createOperation.jsp").forward(request, response);

    }
}
