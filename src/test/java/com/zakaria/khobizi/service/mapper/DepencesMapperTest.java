package com.zakaria.khobizi.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DepencesMapperTest {

    private DepencesMapper depencesMapper;

    @BeforeEach
    public void setUp() {
        depencesMapper = new DepencesMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(depencesMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(depencesMapper.fromId(null)).isNull();
    }
}
