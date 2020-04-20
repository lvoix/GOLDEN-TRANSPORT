package com.zakaria.khobizi.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.zakaria.khobizi.util.TestUtil;
	

public class BeneficiaireDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BeneficiaireDTO.class);
        BeneficiaireDTO beneficiaireDTO1 = new BeneficiaireDTO();
        beneficiaireDTO1.setId(1L);
        BeneficiaireDTO beneficiaireDTO2 = new BeneficiaireDTO();
        assertThat(beneficiaireDTO1).isNotEqualTo(beneficiaireDTO2);
        beneficiaireDTO2.setId(beneficiaireDTO1.getId());
        assertThat(beneficiaireDTO1).isEqualTo(beneficiaireDTO2);
        beneficiaireDTO2.setId(2L);
        assertThat(beneficiaireDTO1).isNotEqualTo(beneficiaireDTO2);
        beneficiaireDTO1.setId(null);
        assertThat(beneficiaireDTO1).isNotEqualTo(beneficiaireDTO2);
    }
}
