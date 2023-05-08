package com.artgallery.bankaccount;

import static com.artgallery.dao.db.Tables.BANK_ACCOUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.artgallery.BaseTestSpecification;
import com.artgallery.api.bankaccount.AddBankAccountDto;
import com.artgallery.api.bankaccount.BankAccountDto;
import com.artgallery.api.bankaccount.EditBankAccountDto;
import com.artgallery.dao.db.tables.records.BankAccountRecord;
import com.fasterxml.jackson.core.type.TypeReference;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

public class BankAccountIntTest extends BaseTestSpecification {

    @Test
    public void addBankAccount() throws Exception {
        //given
        AddBankAccountDto request = createAddBankAccountDto();

        //when
        mockMvc.perform(post("/api/1/bankAccount/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        BankAccountRecord record = dslContext.selectFrom(BANK_ACCOUNT).fetchOne();

        assertEquals(record.getName(), request.getName());
        assertEquals(record.getAccountNumber(), request.getAccountNumber());
        assertEquals(record.getBalance(), formatBigDecimal(request.getBalance()));
    }

    @Test
    @Sql("classpath:test-data/mock-bank-account.sql")
    public void getBankAccount() throws Exception {
        //when
        String stringResponse = mockMvc.perform(get("/api/1/bankAccount")
                .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<BankAccountDto> response = objectMapper.readValue(stringResponse, new TypeReference<>() {
        });

        //then
        assertEquals(response.get(0).getName(), "Account");
        assertEquals(response.get(0).getAccountNumber(), "11111");
        assertEquals(response.get(0).getBalance(), formatBigDecimal(BigDecimal.valueOf(5000.00)));
    }

    @Test
    @Sql("classpath:test-data/mock-bank-account.sql")
    public void deleteBankAccount() throws Exception {
        //when
        mockMvc.perform(delete("/api/1/bankAccount/999")
                .contentType("application/json"))
            .andExpect(status().isOk());

        //then
        BankAccountRecord record = dslContext.selectFrom(BANK_ACCOUNT).fetchOne();

        assertNull(record);
    }

    @Test
    @Sql("classpath:test-data/mock-bank-account.sql")
    public void patchBankAccount() throws Exception {
        //given
        EditBankAccountDto request = createEditBankAccountDto();

        //when
        mockMvc.perform(patch("/api/1/bankAccount/999")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        BankAccountRecord record = dslContext.selectFrom(BANK_ACCOUNT).fetchOne();

        assertEquals(record.getName(), request.getName());
        assertEquals(record.getAccountNumber(), request.getAccountNumber());
        assertEquals(record.getBalance(), formatBigDecimal(request.getBalance()));
    }

    private AddBankAccountDto createAddBankAccountDto() {
        AddBankAccountDto request = new AddBankAccountDto();
        request.setName("Account");
        request.setAccountNumber("11111");
        request.setBalance(BigDecimal.valueOf(5000.00));
        return request;
    }

    private EditBankAccountDto createEditBankAccountDto() {
        EditBankAccountDto request = new EditBankAccountDto();
        request.setName("NewAccount");
        request.setAccountNumber("99999");
        request.setBalance(BigDecimal.valueOf(50000.00));
        return request;
    }
}
