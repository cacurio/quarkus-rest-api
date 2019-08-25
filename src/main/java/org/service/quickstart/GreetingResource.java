package org.service.quickstart;

import org.service.quickstart.entity.Developer;
import org.service.quickstart.repository.DeveloperRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@Path("/dev")
public class GreetingResource {

    @Inject
    DeveloperRepository developerRepository;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDev(Developer developer) {
         developerRepository.create(developer);
         return Response.created(URI.create("/dev" + developer.getId()))
                 .build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> getDev(){
        return developerRepository.findAllRecords();
    }

    @GET
    @Path("{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer getById(@PathParam("id") Long id){
        return developerRepository.findById(id);
    }

    @GET
    @Path("{name}/name")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer findById(@PathParam("name") String name){
        return developerRepository.findByName(name);
    }

    @GET
    @Path("{name}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer findByNameAndAge(@NotNull @PathParam("name") String name, @PathParam("age") Integer age){
        return developerRepository.findByNameAndAge(name, age);
    }


}