package com.golden.transport.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.golden.transport.util.TestUtil;

public class DepencesDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DepencesDTO.class);
        DepencesDTO depencesDTO1 = new DepencesDTO();
        depencesDTO1.setId(1L);
        DepencesDTO depencesDTO2 = new DepencesDTO();
        assertThat(depencesDTO1).isNotEqualTo(depencesDTO2);
        depencesDTO2.setId(depencesDTO1.getId());
        assertThat(depencesDTO1).isEqualTo(depencesDTO2);
        depencesDTO2.setId(2L);
        assertThat(depencesDTO1).isNotEqualTo(depencesDTO2);
        depencesDTO1.setId(null);
        assertThat(depencesDTO1).isNotEqualTo(depencesDTO2);
    }
}
