package com.artgallery.transaction;

import static com.artgallery.dao.db.Tables.TRANSACTION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.client.ExpectedCount.twice;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.artgallery.BaseTestSpecification;
import com.artgallery.api.CurrencyDto;
import com.artgallery.api.transaction.AddTransactionDto;
import com.artgallery.api.transaction.AddTransactionValueDto;
import com.artgallery.api.transaction.TransactionDto;
import com.artgallery.api.transaction.TransactionTypeDto;
import com.artgallery.dao.db.tables.records.TransactionRecord;
import com.artgallery.infrastructure.nbp.NbpExchangeRates;
import com.artgallery.infrastructure.nbp.NbpExchangeRatesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

public class TransactionIntTest extends BaseTestSpecification {

    @Test
    @Sql("classpath:test-data/mock-add-transaction.sql")
    public void addTransaction() throws Exception {
        //given
        AddTransactionDto request = createAddTransactionDto();

        mockServer.expect(twice(), requestTo(
                "http://api.testnbp.pl/api/exchangeratessupertest/tables/c/"))
            .andExpect(method(HttpMethod.GET))
            .andRespond(withSuccess(objectMapper.writeValueAsString(createResponse()), MediaType.APPLICATION_JSON));

        //when
        mockMvc.perform(post("/api/1/transaction/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        TransactionRecord record = dslContext.selectFrom(TRANSACTION).fetchOne();

        assertEquals(record.getPaintingId(), request.getPaintingId());
        assertEquals(record.getClientId(), request.getClientId());
        assertEquals(record.getCuratorId(), request.getCuratorId());
        assertEquals(record.getBankAccountId(), request.getBankAccountId());
        assertEquals(record.getType(), request.getType().name());
        assertEquals(formatBigDecimal(record.getValue()), formatBigDecimal(request.getTransactionValue().getValue()
            .multiply(BigDecimal.valueOf(createResponse()[0].getRates().get(0).getBid()))));
        assertEquals(record.getValueCurrency(), "PLN");
        assertEquals(record.getDate(), request.getDate());
    }

    @Test
    @Sql("classpath:test-data/mock-transaction.sql")
    public void getTransactions() throws Exception {
        //when
        String stringResponse = mockMvc.perform(get("/api/1/transaction")
                .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<TransactionDto> response = objectMapper.readValue(stringResponse, new TypeReference<>() {
        });

        //then
        assertEquals(response.get(0).getPaintingId(), 2);
        assertEquals(response.get(0).getClientId(), 3);
        assertEquals(response.get(0).getCuratorId(), 4);
        assertEquals(response.get(0).getBankAccountId(), 5);
        assertEquals(response.get(0).getType(), TransactionTypeDto.BUY);
        assertEquals(response.get(0).getTransactionValue().getValue(), formatBigDecimal(BigDecimal.valueOf(10000.00)));
        assertEquals(response.get(0).getTransactionValue().getCurrency(), CurrencyDto.PLN);
        assertEquals(response.get(0).getOriginalTransactionValue().getValue(), formatBigDecimal(BigDecimal.valueOf(2000.00)));
        assertEquals(response.get(0).getOriginalTransactionValue().getCurrency(), CurrencyDto.EUR);
        assertEquals(response.get(0).getDate(), LocalDate.of(2020, 01, 01));
    }

    @Test
    @Sql("classpath:test-data/mock-transaction.sql")
    public void deleteTransaction() throws Exception {
        //when
        mockMvc.perform(delete("/api/1/transaction/1")
                .contentType("application/json"))
            .andExpect(status().isOk());

        //then
        TransactionRecord record = dslContext.selectFrom(TRANSACTION).fetchOne();

        assertNull(record);
    }


    private AddTransactionDto createAddTransactionDto() {
        AddTransactionDto request = new AddTransactionDto();
        request.setType(TransactionTypeDto.BUY);
        request.setPaintingId(1L);
        request.setClientId(1L);
        request.setCuratorId(1L);
        request.setBankAccountId(1L);
        request.setTransactionValue(createTransactionValueDto());
        request.setDate(LocalDate.now());
        return request;
    }

    private AddTransactionValueDto createTransactionValueDto() {
        AddTransactionValueDto transactionValueDto = new AddTransactionValueDto();
        transactionValueDto.setValue(formatBigDecimal(BigDecimal.valueOf(10000.00)));
        transactionValueDto.setCurrency(CurrencyDto.EUR);
        return transactionValueDto;
    }

    private NbpExchangeRatesResponse[] createResponse() {
        NbpExchangeRatesResponse rate = new NbpExchangeRatesResponse();
        List<NbpExchangeRates> list = new ArrayList<>();
        list.add(createRates());
        rate.setRates(list);
        return new NbpExchangeRatesResponse[] {rate};
    }

    private NbpExchangeRates createRates() {
        NbpExchangeRates rates = new NbpExchangeRates();
        rates.setCurrency("euro");
        rates.setCode("EUR");
        rates.setBid(4.5f);
        rates.setAsk(4.0f);
        return rates;
    }
}
