/*
package com.golden.transport.rest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.core.Relation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@JsonSerialize(using = PrioritySerializer.class)
@Relation(collectionRelation = "priorities")
enum Prioritys {
        HIGH("High"),
        NORMAL("Normal"),
        LOW("Low");

        private final String description;

    Prioritys(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public static List<Prioritys> orderedValues = new ArrayList<>();

        static {
            orderedValues.addAll(Arrays.asList(Prioritys.values()));
        }
    }
@RepositoryRestController
@RequestMapping(value="/api")
public class PrioritiesResource {

    */
/*    @GetMapping(value = "/priorities", produces = MediaTypes.HAL_JSON_VALUE)
        public ResponseEntity<Resources<>> getPriorities() {
            Resource<> resources = new Resource<>(Prioritys.orderedValues);

            resources.add(linkTo(methodOn(PrioritiesResource.class).getPriorities()).withSelfRel());

            return ResponseEntity.ok(resources);
        }*//*

    @GetMapping(value = "/priorities", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity<Resources<Prioritys>> getPriorities() {
        List<Prioritys> priorities = Prioritys.orderedValues.stream()
                .map(p -> new Prioritys(p.name(), p.getDescription()))
                .collect(Collectors.toList());

        Resources<Prioritys> resources = new Resources<>(priorities);
        resources.add(linkTo(methodOn(PrioritiesResource.class).getPriorities()).withSelfRel());
        return ResponseEntity.ok(resources);
    }
    }


class PrioritySerializer extends JsonSerializer<Prioritys> {
        @Override
        public void serialize(Prioritys priority,
                              JsonGenerator generator,
                              SerializerProvider serializerProvider)
                throws IOException, JsonProcessingException {
            generator.writeStartObject();

            generator.writeFieldName("id");
            generator.writeString(priority.name());

            generator.writeFieldName("value");
            generator.writeString(priority.getDescription());

            generator.writeEndObject();
        }
    }

*/
