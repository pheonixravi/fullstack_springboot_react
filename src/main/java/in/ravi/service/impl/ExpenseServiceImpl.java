package in.ravi.service.impl;

import in.ravi.dto.ExpenseDTO;
import in.ravi.entity.ExpenseEntity;
import in.ravi.repository.ExpenseRepository;
import in.ravi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Service Implementation class of Expense Module
 * @author Ravi
 * */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    private final ModelMapper modelMapper;

    /**
     * It will fetch the expenses from database
     * @return list
     * */
    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<ExpenseEntity> list=expenseRepository.findAll();
        log.info("Printing the data from repository {}",list);

        //Convert the entity object to DTO object
        List<ExpenseDTO> listOfExpenses=list.stream().
                map(expenseEntity ->mapToExpenseDTO(expenseEntity))
                .collect(Collectors.toList());
        return listOfExpenses;

    }
    /**
     * Mapper method to convert expense entity to expense DTO
     * @param expenseEntity
     * @return ExpenseDTO
     * */
    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
