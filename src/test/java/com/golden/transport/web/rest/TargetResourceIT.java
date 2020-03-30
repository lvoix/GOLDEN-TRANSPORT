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

import com.golden.transport.service.dto.TargetDTO;
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
import com.golden.transport.domain.Target;
import com.golden.transport.repository.TargetRepository;
import com.golden.transport.rest.TargetResource;
import com.golden.transport.service.TargetService;
import com.golden.transport.service.mapper.TargetMapper;

/**
 * Integration tests for the {@link TargetResource} REST controller.
 */
@SpringBootTest(classes = DemoApplication.class)

@AutoConfigureMockMvc 
public class TargetResourceIT {

    @Autowired
    private TargetRepository targetRepository;

    @Autowired
    private TargetMapper targetMapper;

    @Autowired
    private TargetService targetService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTargetMockMvc;

    private Target target;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Target createEntity(EntityManager em) {
        Target target = new Target();
        return target;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Target createUpdatedEntity(EntityManager em) {
        Target target = new Target();
        return target;
    }

    @BeforeEach
    public void initTest() {
        target = createEntity(em);
    }

    @Test
    @Transactional
    public void createTarget() throws Exception {
        int databaseSizeBeforeCreate = targetRepository.findAll().size();

        // Create the Target
        TargetDTO targetDTO = targetMapper.toDto(target);
        restTargetMockMvc.perform(post("/api/targets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(targetDTO)))
            .andExpect(status().isCreated());

        // Validate the Target in the database
        List<Target> TargetList = targetRepository.findAll();
        assertThat(TargetList).hasSize(databaseSizeBeforeCreate + 1);
        Target testTarget = TargetList.get(TargetList.size() - 1);
    }

    @Test
    @Transactional
    public void createTargetWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = targetRepository.findAll().size();

        // Create the Target with an existing ID
        target.setId(1L);
        TargetDTO targetDTO = targetMapper.toDto(target);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTargetMockMvc.perform(post("/api/targets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(targetDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Target in the database
        List<Target> targetList = targetRepository.findAll();
        assertThat(targetList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllTargets() throws Exception {
        // Initialize the database
        targetRepository.saveAndFlush(target);

        // Get all the TargetList
        restTargetMockMvc.perform(get("/api/targets?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(target.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getTarget() throws Exception {
        // Initialize the database
        targetRepository.saveAndFlush(target);

        // Get the Target
        restTargetMockMvc.perform(get("/api/targets/{id}", target.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(target.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingTarget() throws Exception {
        // Get the Target
        restTargetMockMvc.perform(get("/api/targets/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTarget() throws Exception {
        // Initialize the database
        targetRepository.saveAndFlush(target);

        int databaseSizeBeforeUpdate = targetRepository.findAll().size();

        // Update the Target
        Target updatedTarget = targetRepository.findById(target.getId()).get();
        // Disconnect from session so that the updates on updatedTarget are not directly saved in db
        em.detach(updatedTarget);
        TargetDTO targetDTO = targetMapper.toDto(updatedTarget);

        restTargetMockMvc.perform(put("/api/targets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(targetDTO)))
            .andExpect(status().isOk());

        // Validate the Target in the database
        List<Target> targetList = targetRepository.findAll();
        assertThat(targetList).hasSize(databaseSizeBeforeUpdate);
        Target testTarget = targetList.get(targetList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingTarget() throws Exception {
        int databaseSizeBeforeUpdate = targetRepository.findAll().size();

        // Create the Target
        TargetDTO targetDTO = targetMapper.toDto(target);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restTargetMockMvc.perform(put("/api/targets")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(targetDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Target in the database
        List<Target> targetList = targetRepository.findAll();
        assertThat(targetList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTarget() throws Exception {
        // Initialize the database
        targetRepository.saveAndFlush(target);

        int databaseSizeBeforeDelete = targetRepository.findAll().size();

        // Delete the Target
        restTargetMockMvc.perform(delete("/api/targets/{id}", target.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Target> targetList = targetRepository.findAll();
        assertThat(targetList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
