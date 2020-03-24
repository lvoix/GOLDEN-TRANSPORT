package com.zakaria.khobizi.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.zakaria.khobizi.DemoApplication;
import com.zakaria.khobizi.domain.Vehicule;
import com.zakaria.khobizi.repository.VehiculeRepository;
import com.zakaria.khobizi.rest.VehiculeResource;
import com.zakaria.khobizi.service.VehiculeService;
import com.zakaria.khobizi.service.dto.VehiculeDTO;
import com.zakaria.khobizi.service.mapper.VehiculeMapper;
import com.zakaria.khobizi.util.TestUtil;

/**
 * Integration tests for the {@link VehiculeResource} REST controller.
 */
@SpringBootTest(classes = DemoApplication.class)

@AutoConfigureMockMvc 
public class VehiculeResourceIT {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private VehiculeMapper vehiculeMapper;

    @Autowired
    private VehiculeService vehiculeService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restVehiculeMockMvc;

    private Vehicule vehicule;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Vehicule createEntity(EntityManager em) {
        Vehicule vehicule = new Vehicule();
        return vehicule;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Vehicule createUpdatedEntity(EntityManager em) {
        Vehicule vehicule = new Vehicule();
        return vehicule;
    }

    @BeforeEach
    public void initTest() {
        vehicule = createEntity(em);
    }

    @Test
    @Transactional
    public void createVehicule() throws Exception {
        int databaseSizeBeforeCreate = vehiculeRepository.findAll().size();

        // Create the Vehicule
        VehiculeDTO vehiculeDTO = vehiculeMapper.toDto(vehicule);
        restVehiculeMockMvc.perform(post("/api/vehicules")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(vehiculeDTO)))
            .andExpect(status().isCreated());

        // Validate the Vehicule in the database
        List<Vehicule> vehiculeList = vehiculeRepository.findAll();
        assertThat(vehiculeList).hasSize(databaseSizeBeforeCreate + 1);
        Vehicule testVehicule = vehiculeList.get(vehiculeList.size() - 1);
    }

    @Test
    @Transactional
    public void createVehiculeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = vehiculeRepository.findAll().size();

        // Create the Vehicule with an existing ID
        vehicule.setId(1L);
        VehiculeDTO vehiculeDTO = vehiculeMapper.toDto(vehicule);

        // An entity with an existing ID cannot be created, so this API call must fail
        restVehiculeMockMvc.perform(post("/api/vehicules")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(vehiculeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Vehicule in the database
        List<Vehicule> vehiculeList = vehiculeRepository.findAll();
        assertThat(vehiculeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllVehicules() throws Exception {
        // Initialize the database
        vehiculeRepository.saveAndFlush(vehicule);

        // Get all the vehiculeList
        restVehiculeMockMvc.perform(get("/api/vehicules?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(vehicule.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getVehicule() throws Exception {
        // Initialize the database
        vehiculeRepository.saveAndFlush(vehicule);

        // Get the vehicule
        restVehiculeMockMvc.perform(get("/api/vehicules/{id}", vehicule.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(vehicule.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingVehicule() throws Exception {
        // Get the vehicule
        restVehiculeMockMvc.perform(get("/api/vehicules/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateVehicule() throws Exception {
        // Initialize the database
        vehiculeRepository.saveAndFlush(vehicule);

        int databaseSizeBeforeUpdate = vehiculeRepository.findAll().size();

        // Update the vehicule
        Vehicule updatedVehicule = vehiculeRepository.findById(vehicule.getId()).get();
        // Disconnect from session so that the updates on updatedVehicule are not directly saved in db
        em.detach(updatedVehicule);
        VehiculeDTO vehiculeDTO = vehiculeMapper.toDto(updatedVehicule);

        restVehiculeMockMvc.perform(put("/api/vehicules")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(vehiculeDTO)))
            .andExpect(status().isOk());

        // Validate the Vehicule in the database
        List<Vehicule> vehiculeList = vehiculeRepository.findAll();
        assertThat(vehiculeList).hasSize(databaseSizeBeforeUpdate);
        Vehicule testVehicule = vehiculeList.get(vehiculeList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingVehicule() throws Exception {
        int databaseSizeBeforeUpdate = vehiculeRepository.findAll().size();

        // Create the Vehicule
        VehiculeDTO vehiculeDTO = vehiculeMapper.toDto(vehicule);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVehiculeMockMvc.perform(put("/api/vehicules")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(vehiculeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Vehicule in the database
        List<Vehicule> vehiculeList = vehiculeRepository.findAll();
        assertThat(vehiculeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteVehicule() throws Exception {
        // Initialize the database
        vehiculeRepository.saveAndFlush(vehicule);

        int databaseSizeBeforeDelete = vehiculeRepository.findAll().size();

        // Delete the vehicule
        restVehiculeMockMvc.perform(delete("/api/vehicules/{id}", vehicule.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Vehicule> vehiculeList = vehiculeRepository.findAll();
        assertThat(vehiculeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
