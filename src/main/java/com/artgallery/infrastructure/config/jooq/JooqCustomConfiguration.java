package com.artgallery.infrastructure.config.jooq;

import org.jooq.conf.RenderQuotedNames;
import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqCustomConfiguration {

    @Bean
    public DefaultConfigurationCustomizer jooqConfigurationCustomizer() {
        return c -> c.settings().withRenderQuotedNames(RenderQuotedNames.EXPLICIT_DEFAULT_UNQUOTED);
    }
}
