package in.ravi.service;

import in.ravi.dto.ExpenseDTO;

import java.util.List;
/**
 * Service interface for Expense module
 * @author Ravi
 * */
public interface ExpenseService {
    /**
     * It will fetch the expenses from database
     * @return list
     * */
    List<ExpenseDTO> getAllExpenses();


}
