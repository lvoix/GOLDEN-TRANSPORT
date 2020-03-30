package com.golden.transport.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.golden.transport.util.TestUtil;

public class ConducteurDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConducteurDTO.class);
        ConducteurDTO conducteurDTO1 = new ConducteurDTO();
        conducteurDTO1.setId(1L);
        ConducteurDTO conducteurDTO2 = new ConducteurDTO();
        assertThat(conducteurDTO1).isNotEqualTo(conducteurDTO2);
        conducteurDTO2.setId(conducteurDTO1.getId());
        assertThat(conducteurDTO1).isEqualTo(conducteurDTO2);
        conducteurDTO2.setId(2L);
        assertThat(conducteurDTO1).isNotEqualTo(conducteurDTO2);
        conducteurDTO1.setId(null);
        assertThat(conducteurDTO1).isNotEqualTo(conducteurDTO2);
    }
}
