package com.zakaria.khobizi.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BeneficiaireMapperTest {

    private BeneficiaireMapper beneficiaireMapper;

    @BeforeEach
    public void setUp() {
        beneficiaireMapper = new BeneficiaireMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(beneficiaireMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(beneficiaireMapper.fromId(null)).isNull();
    }
}
