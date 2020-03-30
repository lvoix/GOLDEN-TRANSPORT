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
import com.golden.transport.domain.Entite;
import com.golden.transport.repository.EntiteRepository;
import com.golden.transport.rest.EntiteResource;
import com.golden.transport.service.EntiteService;
import com.golden.transport.service.dto.EntiteDTO;
import com.golden.transport.service.mapper.EntiteMapper;

/**
 * Integration tests for the {@link EntiteResource} REST controller.
 */
@SpringBootTest(classes = DemoApplication.class)

@AutoConfigureMockMvc 
public class EntiteResourceIT {

    @Autowired
    private EntiteRepository entiteRepository;

    @Autowired
    private EntiteMapper entiteMapper;

    @Autowired
    private EntiteService entiteService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restEntiteMockMvc;

    private Entite entite;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Entite createEntity(EntityManager em) {
        Entite entite = new Entite();
        return entite;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Entite createUpdatedEntity(EntityManager em) {
        Entite entite = new Entite();
        return entite;
    }

    @BeforeEach
    public void initTest() {
        entite = createEntity(em);
    }

    @Test
    @Transactional
    public void createEntite() throws Exception {
        int databaseSizeBeforeCreate = entiteRepository.findAll().size();

        // Create the Entite
        EntiteDTO entiteDTO = entiteMapper.toDto(entite);
        restEntiteMockMvc.perform(post("/api/entites")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(entiteDTO)))
            .andExpect(status().isCreated());

        // Validate the Entite in the database
        List<Entite> entiteList = entiteRepository.findAll();
        assertThat(entiteList).hasSize(databaseSizeBeforeCreate + 1);
        Entite testEntite = entiteList.get(entiteList.size() - 1);
    }

    @Test
    @Transactional
    public void createEntiteWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = entiteRepository.findAll().size();

        // Create the Entite with an existing ID
        entite.setId(1L);
        EntiteDTO entiteDTO = entiteMapper.toDto(entite);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEntiteMockMvc.perform(post("/api/entites")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(entiteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Entite in the database
        List<Entite> entiteList = entiteRepository.findAll();
        assertThat(entiteList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllEntites() throws Exception {
        // Initialize the database
        entiteRepository.saveAndFlush(entite);

        // Get all the EntiteList
        restEntiteMockMvc.perform(get("/api/entites?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(entite.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getEntite() throws Exception {
        // Initialize the database
        entiteRepository.saveAndFlush(entite);

        // Get the Entite
        restEntiteMockMvc.perform(get("/api/entites/{id}", entite.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(entite.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingEntite() throws Exception {
        // Get the Entite
        restEntiteMockMvc.perform(get("/api/entites/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEntite() throws Exception {
        // Initialize the database
        entiteRepository.saveAndFlush(entite);

        int databaseSizeBeforeUpdate = entiteRepository.findAll().size();

        // Update the Entite
        Entite updatedEntite = entiteRepository.findById(entite.getId()).get();
        // Disconnect from session so that the updates on updatedEntite are not directly saved in db
        em.detach(updatedEntite);
        EntiteDTO entiteDTO = entiteMapper.toDto(updatedEntite);

        restEntiteMockMvc.perform(put("/api/entites")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(entiteDTO)))
            .andExpect(status().isOk());

        // Validate the Entite in the database
        List<Entite> entiteList = entiteRepository.findAll();
        assertThat(entiteList).hasSize(databaseSizeBeforeUpdate);
        Entite testEntite = entiteList.get(entiteList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingEntite() throws Exception {
        int databaseSizeBeforeUpdate = entiteRepository.findAll().size();

        // Create the Entite
        EntiteDTO entiteDTO = entiteMapper.toDto(entite);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restEntiteMockMvc.perform(put("/api/entites")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(entiteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Entite in the database
        List<Entite> entiteList = entiteRepository.findAll();
        assertThat(entiteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteEntite() throws Exception {
        // Initialize the database
        entiteRepository.saveAndFlush(entite);

        int databaseSizeBeforeDelete = entiteRepository.findAll().size();

        // Delete the Entite
        restEntiteMockMvc.perform(delete("/api/entites/{id}", entite.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Entite> entiteList = entiteRepository.findAll();
        assertThat(entiteList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
