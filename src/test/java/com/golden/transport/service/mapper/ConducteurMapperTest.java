package com.golden.transport.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ConducteurMapperTest {

    private ConducteurMapper conducteurMapper;

    @BeforeEach
    public void setUp() {
        conducteurMapper = new ConducteurMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(conducteurMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(conducteurMapper.fromId(null)).isNull();
    }
}
