package com.artgallery.curator;

import static com.artgallery.dao.db.Tables.CURATOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.artgallery.BaseTestSpecification;
import com.artgallery.api.curator.AddCuratorDto;
import com.artgallery.api.curator.CuratorDto;
import com.artgallery.api.curator.EditCuratorDto;
import com.artgallery.dao.db.tables.records.CuratorRecord;
import com.fasterxml.jackson.core.type.TypeReference;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

public class CuratorIntTest extends BaseTestSpecification {

    @Test
    public void addCurator() throws Exception {
        //given
        AddCuratorDto request = createAddCuratorDto();

        //when
        mockMvc.perform(post("/api/1/curator/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        CuratorRecord record = dslContext.selectFrom(CURATOR).fetchOne();

        assertEquals(record.getFirstName(), request.getFirstName());
        assertEquals(record.getLastName(), request.getLastName());
        assertEquals(record.getSalary(), formatBigDecimal(request.getSalary()));
    }

    @Test
    @Sql("classpath:test-data/mock-curator.sql")
    public void getCurator() throws Exception {
        //when
        String stringResponse = mockMvc.perform(get("/api/1/curator")
                .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<CuratorDto> response = objectMapper.readValue(stringResponse, new TypeReference<>() {
        });

        //then
        assertEquals(response.get(0).getFirstName(), "Roger");
        assertEquals(response.get(0).getLastName(), "Roger");
        assertEquals(response.get(0).getSalary(), formatBigDecimal(BigDecimal.valueOf(5000.00)));
    }

    @Test
    @Sql("classpath:test-data/mock-curator.sql")
    public void deleteCurator() throws Exception {
        //when
        mockMvc.perform(delete("/api/1/curator/999")
                .contentType("application/json"))
            .andExpect(status().isOk());

        //then
        CuratorRecord record = dslContext.selectFrom(CURATOR).fetchOne();

        assertNull(record);
    }

    @Test
    @Sql("classpath:test-data/mock-curator.sql")
    public void patchCurator() throws Exception {
        //given
        EditCuratorDto request = createEditCuratorDto();

        //when
        mockMvc.perform(patch("/api/1/curator/999")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        CuratorRecord record = dslContext.selectFrom(CURATOR).fetchOne();

        assertEquals(record.getFirstName(), request.getFirstName());
        assertEquals(record.getLastName(), request.getLastName());
        assertEquals(record.getSalary(), formatBigDecimal(request.getSalary()));
    }

    private AddCuratorDto createAddCuratorDto() {
        AddCuratorDto request = new AddCuratorDto();
        request.setFirstName("Roger");
        request.setLastName("Roger");
        request.setSalary(BigDecimal.valueOf(5000.00));
        return request;
    }

    private EditCuratorDto createEditCuratorDto() {
        EditCuratorDto request = new EditCuratorDto();
        request.setFirstName("NewRoger");
        request.setLastName("NewRoger");
        request.setSalary(BigDecimal.valueOf(500.00));
        return request;
    }
}
