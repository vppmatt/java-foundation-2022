package uk.co.multicode.expenses.management;

import uk.co.multicode.expenses.domain.Employee;
import uk.co.multicode.expenses.domain.ExpenseClaim;

public interface ExpenseManagementProcess {

    public int registerExpenseClaim(ExpenseClaim claim);
    public boolean approveClaim(int id, Employee employee);
}
