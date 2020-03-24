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
import com.zakaria.khobizi.domain.Traget;
import com.zakaria.khobizi.repository.TragetRepository;
import com.zakaria.khobizi.rest.TragetResource;
import com.zakaria.khobizi.service.TragetService;
import com.zakaria.khobizi.service.dto.TragetDTO;
import com.zakaria.khobizi.service.mapper.TragetMapper;
import com.zakaria.khobizi.util.TestUtil;

/**
 * Integration tests for the {@link TragetResource} REST controller.
 */
@SpringBootTest(classes = DemoApplication.class)

@AutoConfigureMockMvc 
public class TragetResourceIT {

    @Autowired
    private TragetRepository tragetRepository;

    @Autowired
    private TragetMapper tragetMapper;

    @Autowired
    private TragetService tragetService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTragetMockMvc;

    private Traget traget;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Traget createEntity(EntityManager em) {
        Traget traget = new Traget();
        return traget;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Traget createUpdatedEntity(EntityManager em) {
        Traget traget = new Traget();
        return traget;
    }

    @BeforeEach
    public void initTest() {
        traget = createEntity(em);
    }

    @Test
    @Transactional
    public void createTraget() throws Exception {
        int databaseSizeBeforeCreate = tragetRepository.findAll().size();

        // Create the Traget
        TragetDTO tragetDTO = tragetMapper.toDto(traget);
        restTragetMockMvc.perform(post("/api/tragets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tragetDTO)))
            .andExpect(status().isCreated());

        // Validate the Traget in the database
        List<Traget> tragetList = tragetRepository.findAll();
        assertThat(tragetList).hasSize(databaseSizeBeforeCreate + 1);
        Traget testTraget = tragetList.get(tragetList.size() - 1);
    }

    @Test
    @Transactional
    public void createTragetWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = tragetRepository.findAll().size();

        // Create the Traget with an existing ID
        traget.setId(1L);
        TragetDTO tragetDTO = tragetMapper.toDto(traget);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTragetMockMvc.perform(post("/api/tragets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tragetDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Traget in the database
        List<Traget> tragetList = tragetRepository.findAll();
        assertThat(tragetList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllTragets() throws Exception {
        // Initialize the database
        tragetRepository.saveAndFlush(traget);

        // Get all the tragetList
        restTragetMockMvc.perform(get("/api/tragets?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(traget.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getTraget() throws Exception {
        // Initialize the database
        tragetRepository.saveAndFlush(traget);

        // Get the traget
        restTragetMockMvc.perform(get("/api/tragets/{id}", traget.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(traget.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingTraget() throws Exception {
        // Get the traget
        restTragetMockMvc.perform(get("/api/tragets/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTraget() throws Exception {
        // Initialize the database
        tragetRepository.saveAndFlush(traget);

        int databaseSizeBeforeUpdate = tragetRepository.findAll().size();

        // Update the traget
        Traget updatedTraget = tragetRepository.findById(traget.getId()).get();
        // Disconnect from session so that the updates on updatedTraget are not directly saved in db
        em.detach(updatedTraget);
        TragetDTO tragetDTO = tragetMapper.toDto(updatedTraget);

        restTragetMockMvc.perform(put("/api/tragets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tragetDTO)))
            .andExpect(status().isOk());

        // Validate the Traget in the database
        List<Traget> tragetList = tragetRepository.findAll();
        assertThat(tragetList).hasSize(databaseSizeBeforeUpdate);
        Traget testTraget = tragetList.get(tragetList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingTraget() throws Exception {
        int databaseSizeBeforeUpdate = tragetRepository.findAll().size();

        // Create the Traget
        TragetDTO tragetDTO = tragetMapper.toDto(traget);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTragetMockMvc.perform(put("/api/tragets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(tragetDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Traget in the database
        List<Traget> tragetList = tragetRepository.findAll();
        assertThat(tragetList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTraget() throws Exception {
        // Initialize the database
        tragetRepository.saveAndFlush(traget);

        int databaseSizeBeforeDelete = tragetRepository.findAll().size();

        // Delete the traget
        restTragetMockMvc.perform(delete("/api/tragets/{id}", traget.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Traget> tragetList = tragetRepository.findAll();
        assertThat(tragetList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
