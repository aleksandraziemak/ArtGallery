package com.artgallery;

import com.artgallery.config.PostgresqlContainerWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.jooq.DSLContext;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ActiveProfiles("e2e")
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BaseTestSpecification {

    @ClassRule
    public static PostgreSQLContainer postgresqlContainer = PostgresqlContainerWrapper.getContainer();

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public ObjectMapper objectMapper;

    @Autowired
    public DSLContext dslContext;

    @Autowired
    public MockRestServiceServer mockServer;

    protected BigDecimal formatBigDecimal(BigDecimal value) {
        return value.setScale(2, RoundingMode.CEILING);
    }
}
