package com.golden.transport.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TragetMapperTest {

    private TragetMapper tragetMapper;

    @BeforeEach
    public void setUp() {
        tragetMapper = new TragetMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(tragetMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(tragetMapper.fromId(null)).isNull();
    }
}
