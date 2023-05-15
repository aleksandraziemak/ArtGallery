package com.artgallery.collectionentry;

import static com.artgallery.dao.db.Tables.COLLECTION_ENTRY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.artgallery.BaseTestSpecification;
import com.artgallery.api.collectionentry.AddCollectionEntryDto;
import com.artgallery.api.collectionentry.CollectionEntryDto;
import com.artgallery.api.collectionentry.EditCollectionEntryDto;
import com.artgallery.dao.db.tables.records.CollectionEntryRecord;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

public class CollectionEntryIntTest extends BaseTestSpecification {

    @Test
    @Sql("classpath:test-data/mock-collection-entry-add.sql")
    public void addCollectionEntry() throws Exception {
        //given
        AddCollectionEntryDto request = createAddCollectionEntryDto();

        //when
        mockMvc.perform(post("/api/1/collectionEntry/add")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        CollectionEntryRecord record = dslContext.selectFrom(COLLECTION_ENTRY).fetchOne();

        assertEquals(record.getPaintingId(), request.getPaintingId());
        assertEquals(record.getAuthorId(), request.getAuthorId());
        assertEquals(record.getCuratorId(), request.getCuratorId());
    }

    @Test
    @Sql("classpath:test-data/mock-collection-entry.sql")
    public void getCollectionEntry() throws Exception {
        //when
        String stringResponse = mockMvc.perform(get("/api/1/collectionEntry")
                .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<CollectionEntryDto> response = objectMapper.readValue(stringResponse, new TypeReference<>() {
        });

        //then
        assertEquals(response.get(0).getPaintingDto().getId(), 998);
        assertEquals(response.get(0).getAuthorDto().getId(), 998);
        assertEquals(response.get(0).getCuratorDto().getId(), 998);
    }

    @Test
    @Sql("classpath:test-data/mock-collection-entry.sql")
    public void deleteCollectionEntry() throws Exception {
        //when
        mockMvc.perform(delete("/api/1/collectionEntry/999")
                .contentType("application/json"))
            .andExpect(status().isOk());

        //then
        CollectionEntryRecord record = dslContext.selectFrom(COLLECTION_ENTRY).fetchOne();

        assertNull(record);
    }

    @Test
    @Sql("classpath:test-data/mock-collection-entry.sql")
    public void patchCollectionEntry() throws Exception {
        //given
        EditCollectionEntryDto request = createEditCollectionEntry();

        //when
        mockMvc.perform(patch("/api/1/collectionEntry/999")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        //then
        CollectionEntryRecord record = dslContext.selectFrom(COLLECTION_ENTRY).fetchOne();

        assertEquals(record.getPaintingId(), request.getPaintingId());
        assertEquals(record.getAuthorId(), request.getAuthorId());
        assertEquals(record.getCuratorId(), request.getCuratorId());
    }

    private AddCollectionEntryDto createAddCollectionEntryDto() {
        AddCollectionEntryDto request = new AddCollectionEntryDto();
        request.setPaintingId(998L);
        request.setAuthorId(998L);
        request.setCuratorId(998L);
        return request;
    }

    private EditCollectionEntryDto createEditCollectionEntry() {
        EditCollectionEntryDto request = new EditCollectionEntryDto();
        request.setPaintingId(999L);
        request.setAuthorId(999L);
        request.setCuratorId(999L);
        return request;
    }
}
