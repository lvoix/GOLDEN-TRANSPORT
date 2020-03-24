package com.zakaria.khobizi.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.zakaria.khobizi.util.TestUtil;

public class TragetDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TragetDTO.class);
        TragetDTO tragetDTO1 = new TragetDTO();
        tragetDTO1.setId(1L);
        TragetDTO tragetDTO2 = new TragetDTO();
        assertThat(tragetDTO1).isNotEqualTo(tragetDTO2);
        tragetDTO2.setId(tragetDTO1.getId());
        assertThat(tragetDTO1).isEqualTo(tragetDTO2);
        tragetDTO2.setId(2L);
        assertThat(tragetDTO1).isNotEqualTo(tragetDTO2);
        tragetDTO1.setId(null);
        assertThat(tragetDTO1).isNotEqualTo(tragetDTO2);
    }
}
