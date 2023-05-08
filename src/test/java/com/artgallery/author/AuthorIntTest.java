package com.artgallery.author;

import static com.artgallery.dao.db.Tables.AUTHOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.artgallery.BaseTestSpecification;
import com.artgallery.api.author.AddAuthorDto;
import com.artgallery.api.author.AuthorDto;
import com.artgallery.api.author.EditAuthorDto;
import com.artgallery.dao.db.tables.records.AuthorRecord;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

public class AuthorIntTest extends BaseTestSpecification {

    @Test
    public void addAuthor() throws Exception {
        //given
        AddAuthorDto request = createAddAuthorDto();

        //when
        mockMvc.perform(post("/api/1/author/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        AuthorRecord record = dslContext.selectFrom(AUTHOR).fetchOne();

        assertEquals(record.getFirstName(), request.getFirstName());
        assertEquals(record.getSecondName(), request.getSecondName());
        assertEquals(record.getLastName(), request.getLastName());
        assertEquals(record.getCountry(), request.getCountry());
    }

    @Test
    @Sql("classpath:test-data/mock-author.sql")
    public void getAuthors() throws Exception {
        //when
        String stringResponse = mockMvc.perform(get("/api/1/author")
                .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<AuthorDto> response = objectMapper.readValue(stringResponse, new TypeReference<>() {
        });

        //then
        assertEquals(response.get(0).getFirstName(), "Paul");
        assertEquals(response.get(0).getSecondName(), "Marc");
        assertEquals(response.get(0).getLastName(), "Atryda");
        assertEquals(response.get(0).getCountry(), "Arrakis");
    }

    @Test
    @Sql("classpath:test-data/mock-author.sql")
    public void deleteAuthor() throws Exception {
        //when
        mockMvc.perform(delete("/api/1/author/999")
                .contentType("application/json"))
            .andExpect(status().isOk());

        //then
        AuthorRecord record = dslContext.selectFrom(AUTHOR).fetchOne();

        assertNull(record);
    }

    @Test
    @Sql("classpath:test-data/mock-author.sql")
    public void patchAuthor() throws Exception {
        //given
        EditAuthorDto request = createEditAuthorDto();

        //when
        mockMvc.perform(patch("/api/1/author/999")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        AuthorRecord record = dslContext.selectFrom(AUTHOR).fetchOne();

        assertEquals(record.getFirstName(), request.getFirstName());
        assertEquals(record.getSecondName(), request.getSecondName());
        assertEquals(record.getLastName(), request.getLastName());
        assertEquals(record.getCountry(), request.getCountry());
    }

    private AddAuthorDto createAddAuthorDto() {
        AddAuthorDto request = new AddAuthorDto();
        request.setFirstName("Paul");
        request.setSecondName("Marc");
        request.setLastName("Atryda");
        request.setCountry("Arrakis");
        return request;
    }

    private EditAuthorDto createEditAuthorDto() {
        EditAuthorDto request = new EditAuthorDto();
        request.setFirstName("NewName");
        request.setSecondName("NewSecond");
        request.setLastName("NewLast");
        request.setCountry("France");
        return request;
    }
}
