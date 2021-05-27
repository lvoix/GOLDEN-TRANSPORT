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

import com.golden.transport.domain.Beneficiaire;
import com.golden.transport.service.dto.BeneficiaireDTO;
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
import com.golden.transport.repository.BeneficiaireRepository;
import com.golden.transport.rest.BeneficiaireResource;
import com.golden.transport.service.BeneficiaireService;
import com.golden.transport.service.mapper.EntiteMapper;

/**
 * Integration tests for the {@link BeneficiaireResource} REST controller.
 */
@SpringBootTest(classes = DemoApplication.class)

@AutoConfigureMockMvc 
public class BeneficiaireResourceIT {

    @Autowired
    private BeneficiaireRepository beneficiaireRepository;

    @Autowired
    private EntiteMapper entiteMapper;

    @Autowired
    private BeneficiaireService beneficiaireService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restEntiteMockMvc;

    private Beneficiaire beneficiaire;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Beneficiaire createEntity(EntityManager em) {
        Beneficiaire beneficiaire = new Beneficiaire();
        return beneficiaire;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Beneficiaire createUpdatedEntity(EntityManager em) {
        Beneficiaire beneficiaire = new Beneficiaire();
        return beneficiaire;
    }

    @BeforeEach
    public void initTest() {
        beneficiaire = createEntity(em);
    }

    @Test
    @Transactional
    public void createEntite() throws Exception {
        int databaseSizeBeforeCreate = beneficiaireRepository.findAll().size();

        // Create the Beneficiaire
        BeneficiaireDTO beneficiaireDTO = entiteMapper.toDto(beneficiaire);
        restEntiteMockMvc.perform(post("/api/entites")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(beneficiaireDTO)))
            .andExpect(status().isCreated());

        // Validate the Beneficiaire in the database
        List<Beneficiaire> beneficiaireList = beneficiaireRepository.findAll();
        assertThat(beneficiaireList).hasSize(databaseSizeBeforeCreate + 1);
        Beneficiaire testBeneficiaire = beneficiaireList.get(beneficiaireList.size() - 1);
    }

    @Test
    @Transactional
    public void createEntiteWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = beneficiaireRepository.findAll().size();

        // Create the Beneficiaire with an existing ID
        beneficiaire.setId(1L);
        BeneficiaireDTO beneficiaireDTO = entiteMapper.toDto(beneficiaire);

        // An entity with an existing ID cannot be created, so this API call must fail
        restEntiteMockMvc.perform(post("/api/entites")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(beneficiaireDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Beneficiaire in the database
        List<Beneficiaire> beneficiaireList = beneficiaireRepository.findAll();
        assertThat(beneficiaireList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllEntites() throws Exception {
        // Initialize the database
        beneficiaireRepository.saveAndFlush(beneficiaire);

        // Get all the EntiteList
        restEntiteMockMvc.perform(get("/api/entites?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(beneficiaire.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getEntite() throws Exception {
        // Initialize the database
        beneficiaireRepository.saveAndFlush(beneficiaire);

        // Get the Beneficiaire
        restEntiteMockMvc.perform(get("/api/entites/{id}", beneficiaire.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(beneficiaire.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingEntite() throws Exception {
        // Get the Beneficiaire
        restEntiteMockMvc.perform(get("/api/entites/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateEntite() throws Exception {
        // Initialize the database
        beneficiaireRepository.saveAndFlush(beneficiaire);

        int databaseSizeBeforeUpdate = beneficiaireRepository.findAll().size();

        // Update the Beneficiaire
        Beneficiaire updatedBeneficiaire = beneficiaireRepository.findById(beneficiaire.getId()).get();
        // Disconnect from session so that the updates on updatedBeneficiaire are not directly saved in db
        em.detach(updatedBeneficiaire);
        BeneficiaireDTO beneficiaireDTO = entiteMapper.toDto(updatedBeneficiaire);

        restEntiteMockMvc.perform(put("/api/entites")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(beneficiaireDTO)))
            .andExpect(status().isOk());

        // Validate the Beneficiaire in the database
        List<Beneficiaire> beneficiaireList = beneficiaireRepository.findAll();
        assertThat(beneficiaireList).hasSize(databaseSizeBeforeUpdate);
        Beneficiaire testBeneficiaire = beneficiaireList.get(beneficiaireList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingEntite() throws Exception {
        int databaseSizeBeforeUpdate = beneficiaireRepository.findAll().size();

        // Create the Beneficiaire
        BeneficiaireDTO beneficiaireDTO = entiteMapper.toDto(beneficiaire);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restEntiteMockMvc.perform(put("/api/entites")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(beneficiaireDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Beneficiaire in the database
        List<Beneficiaire> beneficiaireList = beneficiaireRepository.findAll();
        assertThat(beneficiaireList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteEntite() throws Exception {
        // Initialize the database
        beneficiaireRepository.saveAndFlush(beneficiaire);

        int databaseSizeBeforeDelete = beneficiaireRepository.findAll().size();

        // Delete the Beneficiaire
        restEntiteMockMvc.perform(delete("/api/entites/{id}", beneficiaire.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Beneficiaire> beneficiaireList = beneficiaireRepository.findAll();
        assertThat(beneficiaireList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
