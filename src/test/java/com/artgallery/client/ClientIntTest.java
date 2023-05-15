package com.artgallery.client;

import static com.artgallery.dao.db.Tables.CLIENT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.artgallery.BaseTestSpecification;
import com.artgallery.api.client.AddClientDto;
import com.artgallery.api.client.ClientDto;
import com.artgallery.api.client.EditClientDto;
import com.artgallery.dao.db.tables.records.ClientRecord;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

public class ClientIntTest extends BaseTestSpecification {

    @Test
    public void addClient() throws Exception {
        //given
        AddClientDto request = createAddClientDto();

        //when
        mockMvc.perform(post("/api/1/client/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        ClientRecord record = dslContext.selectFrom(CLIENT).fetchOne();

        assertEquals(record.getFirstName(), request.getFirstName());
        assertEquals(record.getLastName(), request.getLastName());
    }

    @Test
    @Sql("classpath:test-data/mock-client.sql")
    public void getClient() throws Exception {
        //when
        String stringResponse = mockMvc.perform(get("/api/1/client")
                .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<ClientDto> response = objectMapper.readValue(stringResponse, new TypeReference<>() {
        });

        //then
        assertEquals(response.get(0).getFirstName(), "Roger");
        assertEquals(response.get(0).getLastName(), "Roger");
    }

    @Test
    @Sql("classpath:test-data/mock-client.sql")
    public void deleteClient() throws Exception {
        //when
        mockMvc.perform(delete("/api/1/client/1")
                .contentType("application/json"))
            .andExpect(status().isOk());

        //then
        ClientRecord record = dslContext.selectFrom(CLIENT).fetchOne();

        assertNull(record);
    }

    @Test
    @Sql("classpath:test-data/mock-client.sql")
    public void patchClient() throws Exception {
        //given
        EditClientDto request = createEditClientDto();

        //when
        mockMvc.perform(patch("/api/1/client/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        ClientRecord record = dslContext.selectFrom(CLIENT).fetchOne();

        assertEquals(record.getFirstName(), request.getFirstName());
        assertEquals(record.getLastName(), request.getLastName());
    }

    private AddClientDto createAddClientDto() {
        AddClientDto request = new AddClientDto();
        request.setFirstName("Roger");
        request.setLastName("Roger");
        return request;
    }

    private EditClientDto createEditClientDto() {
        EditClientDto request = new EditClientDto();
        request.setFirstName("NewRoger");
        request.setLastName("NewRoger");
        return request;
    }
}
