package com.golden.transport.web.rest;

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

import com.golden.transport.service.dto.ConducteurDTO;
import com.golden.transport.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.golden.transport.DemoApplication;
import com.golden.transport.domain.Conducteur;
import com.golden.transport.repository.ConducteurRepository;
import com.golden.transport.rest.ConducteurResource;
import com.golden.transport.service.ConducteurService;
import com.golden.transport.service.mapper.ConducteurMapper;

/**
 * Integration tests for the {@link ConducteurResource} REST controller.
 */
@SpringBootTest(classes = DemoApplication.class)

@AutoConfigureMockMvc 
public class ConducteurResourceIT {

    @Autowired
    private ConducteurRepository conducteurRepository;

    @Autowired
    private ConducteurMapper conducteurMapper;

    @Autowired
    private ConducteurService conducteurService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restConducteurMockMvc;

    private Conducteur conducteur;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Conducteur createEntity(EntityManager em) {
        Conducteur conducteur = new Conducteur();
        return conducteur;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Conducteur createUpdatedEntity(EntityManager em) {
        Conducteur conducteur = new Conducteur();
        return conducteur;
    }

    @BeforeEach
    public void initTest() {
        conducteur = createEntity(em);
    }

    @Test
    @Transactional
    public void createConducteur() throws Exception {
        int databaseSizeBeforeCreate = conducteurRepository.findAll().size();

        // Create the Conducteur
        ConducteurDTO conducteurDTO = conducteurMapper.toDto(conducteur);
        restConducteurMockMvc.perform(post("/api/conducteurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(conducteurDTO)))
            .andExpect(status().isCreated());

        // Validate the Conducteur in the database
        List<Conducteur> conducteurList = conducteurRepository.findAll();
        assertThat(conducteurList).hasSize(databaseSizeBeforeCreate + 1);
        Conducteur testConducteur = conducteurList.get(conducteurList.size() - 1);
    }

    @Test
    @Transactional
    public void createConducteurWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = conducteurRepository.findAll().size();

        // Create the Conducteur with an existing ID
        conducteur.setId(1L);
        ConducteurDTO conducteurDTO = conducteurMapper.toDto(conducteur);

        // An entity with an existing ID cannot be created, so this API call must fail
        restConducteurMockMvc.perform(post("/api/conducteurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(conducteurDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Conducteur in the database
        List<Conducteur> conducteurList = conducteurRepository.findAll();
        assertThat(conducteurList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllConducteurs() throws Exception {
        // Initialize the database
        conducteurRepository.saveAndFlush(conducteur);

        // Get all the ConducteurList
        restConducteurMockMvc.perform(get("/api/conducteurs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(conducteur.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getConducteur() throws Exception {
        // Initialize the database
        conducteurRepository.saveAndFlush(conducteur);

        // Get the Conducteur
        restConducteurMockMvc.perform(get("/api/conducteurs/{id}", conducteur.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(conducteur.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingConducteur() throws Exception {
        // Get the Conducteur
        restConducteurMockMvc.perform(get("/api/conducteurs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateConducteur() throws Exception {
        // Initialize the database
        conducteurRepository.saveAndFlush(conducteur);

        int databaseSizeBeforeUpdate = conducteurRepository.findAll().size();

        // Update the Conducteur
        Conducteur updatedConducteur = conducteurRepository.findById(conducteur.getId()).get();
        // Disconnect from session so that the updates on updatedConducteur are not directly saved in db
        em.detach(updatedConducteur);
        ConducteurDTO conducteurDTO = conducteurMapper.toDto(updatedConducteur);

        restConducteurMockMvc.perform(put("/api/conducteurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(conducteurDTO)))
            .andExpect(status().isOk());

        // Validate the Conducteur in the database
        List<Conducteur> conducteurList = conducteurRepository.findAll();
        assertThat(conducteurList).hasSize(databaseSizeBeforeUpdate);
        Conducteur testConducteur = conducteurList.get(conducteurList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingConducteur() throws Exception {
        int databaseSizeBeforeUpdate = conducteurRepository.findAll().size();

        // Create the Conducteur
        ConducteurDTO conducteurDTO = conducteurMapper.toDto(conducteur);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restConducteurMockMvc.perform(put("/api/conducteurs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(conducteurDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Conducteur in the database
        List<Conducteur> conducteurList = conducteurRepository.findAll();
        assertThat(conducteurList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteConducteur() throws Exception {
        // Initialize the database
        conducteurRepository.saveAndFlush(conducteur);

        int databaseSizeBeforeDelete = conducteurRepository.findAll().size();

        // Delete the Conducteur
        restConducteurMockMvc.perform(delete("/api/conducteurs/{id}", conducteur.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Conducteur> conducteurList = conducteurRepository.findAll();
        assertThat(conducteurList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
