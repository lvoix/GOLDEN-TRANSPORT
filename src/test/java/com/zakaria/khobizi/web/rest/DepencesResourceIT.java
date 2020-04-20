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
import com.zakaria.khobizi.domain.Depences;
import com.zakaria.khobizi.repository.DepencesRepository;
import com.zakaria.khobizi.rest.DepencesResource;
import com.zakaria.khobizi.service.DepencesService;
import com.zakaria.khobizi.service.dto.DepencesDTO;
import com.zakaria.khobizi.service.mapper.DepencesMapper;
import com.zakaria.khobizi.util.TestUtil;

/**
 * Integration tests for the {@link DepencesResource} REST controller.
 */
@SpringBootTest(classes = DemoApplication.class)

@AutoConfigureMockMvc 
public class DepencesResourceIT {

    @Autowired
    private DepencesRepository depencesRepository;

    @Autowired
    private DepencesMapper depencesMapper;

    @Autowired
    private DepencesService depencesService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDepencesMockMvc;

    private Depences depences;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Depences createEntity(EntityManager em) {
        Depences depences = new Depences();
        return depences;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Depences createUpdatedEntity(EntityManager em) {
        Depences depences = new Depences();
        return depences;
    }

    @BeforeEach
    public void initTest() {
        depences = createEntity(em);
    }

    @Test
    @Transactional
    public void createDepences() throws Exception {
        int databaseSizeBeforeCreate = depencesRepository.findAll().size();

        // Create the Depences
        DepencesDTO depencesDTO = depencesMapper.toDto(depences);
        restDepencesMockMvc.perform(post("/api/depences")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(depencesDTO)))
            .andExpect(status().isCreated());

        // Validate the Depences in the database
        List<Depences> depencesList = depencesRepository.findAll();
        assertThat(depencesList).hasSize(databaseSizeBeforeCreate + 1);
        Depences testDepences = depencesList.get(depencesList.size() - 1);
    }

    @Test
    @Transactional
    public void createDepencesWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = depencesRepository.findAll().size();

        // Create the Depences with an existing ID
        depences.setId(1L);
        DepencesDTO depencesDTO = depencesMapper.toDto(depences);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDepencesMockMvc.perform(post("/api/depences")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(depencesDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Depences in the database
        List<Depences> depencesList = depencesRepository.findAll();
        assertThat(depencesList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllDepences() throws Exception {
        // Initialize the database
        depencesRepository.saveAndFlush(depences);

        // Get all the depencesList
        restDepencesMockMvc.perform(get("/api/depences?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(depences.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getDepences() throws Exception {
        // Initialize the database
        depencesRepository.saveAndFlush(depences);

        // Get the depences
        restDepencesMockMvc.perform(get("/api/depences/{id}", depences.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(depences.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingDepences() throws Exception {
        // Get the depences
        restDepencesMockMvc.perform(get("/api/depences/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDepences() throws Exception {
        // Initialize the database
        depencesRepository.saveAndFlush(depences);

        int databaseSizeBeforeUpdate = depencesRepository.findAll().size();

        // Update the depences
        Depences updatedDepences = depencesRepository.findById(depences.getId()).get();
        // Disconnect from session so that the updates on updatedDepences are not directly saved in db
        em.detach(updatedDepences);
        DepencesDTO depencesDTO = depencesMapper.toDto(updatedDepences);

        restDepencesMockMvc.perform(put("/api/depences")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(depencesDTO)))
            .andExpect(status().isOk());

        // Validate the Depences in the database
        List<Depences> depencesList = depencesRepository.findAll();
        assertThat(depencesList).hasSize(databaseSizeBeforeUpdate);
        Depences testDepences = depencesList.get(depencesList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingDepences() throws Exception {
        int databaseSizeBeforeUpdate = depencesRepository.findAll().size();

        // Create the Depences
        DepencesDTO depencesDTO = depencesMapper.toDto(depences);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDepencesMockMvc.perform(put("/api/depences")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(depencesDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Depences in the database
        List<Depences> depencesList = depencesRepository.findAll();
        assertThat(depencesList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteDepences() throws Exception {
        // Initialize the database
        depencesRepository.saveAndFlush(depences);

        int databaseSizeBeforeDelete = depencesRepository.findAll().size();

        // Delete the depences
        restDepencesMockMvc.perform(delete("/api/depences/{id}", depences.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Depences> depencesList = depencesRepository.findAll();
        assertThat(depencesList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
