package com.golden.transport.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BeneficiaireMapperTest {

    private EntiteMapper entiteMapper;

    @BeforeEach
    public void setUp() {
        entiteMapper = new EntiteMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(entiteMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(entiteMapper.fromId(null)).isNull();
    }
}
