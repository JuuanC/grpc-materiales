package demo.materiales.resource;

import demo.materiales.model.Usuario;
import demo.materiales.service.UsuarioGRPCService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuario")
public class UsuarioGRPCResource {

    @Inject
    UsuarioGRPCService usuarioGRPCService;

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listUsuario(){
        return usuarioGRPCService.listUsuario();
    }

    @GET
    @Path("getById/{usuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getById(@PathParam("usuario") String usuario){
        return usuarioGRPCService.getByUsuario(usuario);
    }

}
