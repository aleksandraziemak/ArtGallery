package com.artgallery.painting;

import static com.artgallery.dao.db.Tables.PAINTING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.artgallery.BaseTestSpecification;
import com.artgallery.api.CurrencyDto;
import com.artgallery.api.painting.AddPaintingDto;
import com.artgallery.api.painting.EditPaintingDto;
import com.artgallery.api.painting.MovementDto;
import com.artgallery.api.painting.PaintingDto;
import com.artgallery.api.painting.PaintingEstimatedPriceDto;
import com.artgallery.api.painting.StatusDto;
import com.artgallery.dao.db.tables.records.PaintingRecord;
import com.fasterxml.jackson.core.type.TypeReference;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

public class PaintingIntTest extends BaseTestSpecification {

    @Test
    public void addPainting() throws Exception {
        //given
        AddPaintingDto request = createAddPaintingDto();

        //when
        mockMvc.perform(post("/api/1/paintings/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        PaintingRecord record = dslContext.selectFrom(PAINTING).fetchOne();

        assertEquals(record.getTitle(), request.getTitle());
        assertEquals(record.getYear(), request.getYear());
        assertEquals(record.getStatus(), request.getStatus().name());
        assertEquals(record.getMovement(), request.getMovement().name());
        assertEquals(record.getEstimatedPrice(), formatBigDecimal(request.getPaintingEstimatedPrice().getEstimatedPrice()));
        assertEquals(record.getEstimatedPriceCurrency(), request.getPaintingEstimatedPrice().getCurrency().name());
    }

    @Test
    @Sql("classpath:test-data/mock-paintings.sql")
    public void getPaintings() throws Exception {
        //when
        String stringResponse = mockMvc.perform(get("/api/1/paintings")
                .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<PaintingDto> response = objectMapper.readValue(stringResponse, new TypeReference<>() {
        });

        //then
        assertEquals(response.get(0).getTitle(), "Some title");
        assertEquals(response.get(0).getYear(), 1234L);
        assertEquals(response.get(0).getMovement(), MovementDto.ART_DECO);
        assertEquals(response.get(0).getStatus(), StatusDto.SOLD);
        assertEquals(response.get(0).getPaintingEstimatedPrice().getEstimatedPrice(), formatBigDecimal(BigDecimal.valueOf(10000.00)));
        assertEquals(response.get(0).getPaintingEstimatedPrice().getCurrency(), CurrencyDto.PLN);
    }

    @Test
    @Sql("classpath:test-data/mock-paintings.sql")
    public void deletePainting() throws Exception {
        //when
        mockMvc.perform(delete("/api/1/paintings/999")
                .contentType("application/json"))
            .andExpect(status().isOk());

        //then
        PaintingRecord record = dslContext.selectFrom(PAINTING).fetchOne();

        assertNull(record);
    }

    @Test
    @Sql("classpath:test-data/mock-paintings.sql")
    public void patchPainting() throws Exception {
        //given
        EditPaintingDto request = createEditPaintingDto();

        //when
        mockMvc.perform(patch("/api/1/paintings/999")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        PaintingRecord record = dslContext.selectFrom(PAINTING).fetchOne();

        assertEquals(record.getTitle(), request.getTitle());
        assertEquals(record.getYear(), request.getYear());
        assertEquals(record.getStatus(), request.getStatus().name());
        assertEquals(record.getMovement(), request.getMovement().name());
        assertEquals(record.getEstimatedPrice(), formatBigDecimal(request.getPaintingEstimatedPrice().getEstimatedPrice()));
        assertEquals(record.getEstimatedPriceCurrency(), request.getPaintingEstimatedPrice().getCurrency().name());
    }

    private AddPaintingDto createAddPaintingDto() {
        AddPaintingDto request = new AddPaintingDto();
        request.setTitle("Some title");
        request.setYear(1234L);
        request.setStatus(StatusDto.SOLD);
        request.setMovement(MovementDto.ART_DECO);
        request.setPaintingEstimatedPrice(createPaintingEstimatedPriceDto());
        return request;
    }

    private EditPaintingDto createEditPaintingDto() {
        EditPaintingDto request = new EditPaintingDto();
        request.setTitle("Some brand new fantastic title");
        request.setYear(5678L);
        request.setStatus(StatusDto.OWNED);
        request.setMovement(MovementDto.BAROQUE);
        request.setPaintingEstimatedPrice(createPaintingEstimatedPriceDto());
        return request;
    }

    private PaintingEstimatedPriceDto createPaintingEstimatedPriceDto() {
        PaintingEstimatedPriceDto estimatedPriceDto = new PaintingEstimatedPriceDto();
        estimatedPriceDto.setEstimatedPrice(formatBigDecimal(BigDecimal.valueOf(10000.00)));
        estimatedPriceDto.setCurrency(CurrencyDto.PLN);
        return estimatedPriceDto;
    }
}
