package com.artgallery.config;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresqlContainerWrapper extends PostgreSQLContainer<PostgresqlContainerWrapper> {
    private static final String IMAGE_VERSION = "postgres:13.7";

    private static PostgresqlContainerWrapper container;

    private PostgresqlContainerWrapper() {
        super(IMAGE_VERSION);
    }

    public static PostgresqlContainerWrapper getContainer() {
        if (container == null) {
            container = new PostgresqlContainerWrapper().withReuse(true);
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        //do nothing, JVM handles shut down
    }
}
