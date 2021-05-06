package demo.materiales.resource;

import demo.materiales.model.Partida;
import demo.materiales.service.FinancierosGRPCService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/financieros")
public class FinancierosGRPCResource {

    @Inject
    FinancierosGRPCService financierosGRPCService;

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Partida> listPartidas(){
        return financierosGRPCService.listPartidas();
    }

    @GET
    @Path("getById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Partida getById(@PathParam("id") int id){
        return financierosGRPCService.getById(id);
    }
}
