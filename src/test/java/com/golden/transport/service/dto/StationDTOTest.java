package com.golden.transport.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.golden.transport.util.TestUtil;

public class StationDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StationDTO.class);
        StationDTO stationDTO1 = new StationDTO();
        stationDTO1.setId(1L);
        StationDTO stationDTO2 = new StationDTO();
        assertThat(stationDTO1).isNotEqualTo(stationDTO2);
        stationDTO2.setId(stationDTO1.getId());
        assertThat(stationDTO1).isEqualTo(stationDTO2);
        stationDTO2.setId(2L);
        assertThat(stationDTO1).isNotEqualTo(stationDTO2);
        stationDTO1.setId(null);
        assertThat(stationDTO1).isNotEqualTo(stationDTO2);
    }
}