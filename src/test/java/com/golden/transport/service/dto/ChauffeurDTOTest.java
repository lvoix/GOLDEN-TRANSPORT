package com.golden.transport.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.golden.transport.util.TestUtil;

public class ChauffeurDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ChauffeurDTO.class);
        ChauffeurDTO chauffeurDTO1 = new ChauffeurDTO();
        chauffeurDTO1.setId(1L);
        ChauffeurDTO chauffeurDTO2 = new ChauffeurDTO();
        assertThat(chauffeurDTO1).isNotEqualTo(chauffeurDTO2);
        chauffeurDTO2.setId(chauffeurDTO1.getId());
        assertThat(chauffeurDTO1).isEqualTo(chauffeurDTO2);
        chauffeurDTO2.setId(2L);
        assertThat(chauffeurDTO1).isNotEqualTo(chauffeurDTO2);
        chauffeurDTO1.setId(null);
        assertThat(chauffeurDTO1).isNotEqualTo(chauffeurDTO2);
    }
}
