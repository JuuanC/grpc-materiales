package demo.materiales.resource;

import demo.materiales.dto.InsumoDTO;
import demo.materiales.model.Insumo;
import demo.materiales.service.InsumoService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/insumo")
public class InsumoResource {

    @Inject
    InsumoService insumoService;

    @GET
    @Path("/getDetail/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public InsumoDTO getDetail(@PathParam("id") int id){
        return insumoService.getDetail(id);
    }

    @GET
    @Path("/getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Insumo getById(@PathParam("id") int id){
        return insumoService.getById(id);
    }
}
