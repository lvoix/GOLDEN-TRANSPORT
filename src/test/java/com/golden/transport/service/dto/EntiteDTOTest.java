package com.golden.transport.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.golden.transport.util.TestUtil;

public class EntiteDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EntiteDTO.class);
        EntiteDTO entiteDTO1 = new EntiteDTO();
        entiteDTO1.setId(1L);
        EntiteDTO entiteDTO2 = new EntiteDTO();
        assertThat(entiteDTO1).isNotEqualTo(entiteDTO2);
        entiteDTO2.setId(entiteDTO1.getId());
        assertThat(entiteDTO1).isEqualTo(entiteDTO2);
        entiteDTO2.setId(2L);
        assertThat(entiteDTO1).isNotEqualTo(entiteDTO2);
        entiteDTO1.setId(null);
        assertThat(entiteDTO1).isNotEqualTo(entiteDTO2);
    }
}
