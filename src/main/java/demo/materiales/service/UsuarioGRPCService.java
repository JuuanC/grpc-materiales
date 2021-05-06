package demo.materiales.service;

import demo.materiales.model.Usuario;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import ssaver.gob.mx.humanos.catalogos.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuarioGRPCService {

    @Inject
    @GrpcService("usuario")
    UsuarioMethodGrpc.UsuarioMethodBlockingStub usuarioMethodBlockingStub;

    public List<Usuario> listUsuario(){
        List<UsuarioGRPC> usuarioGRPCS = usuarioMethodBlockingStub.getUsuariosGRPC(EmptyGRPC.newBuilder().build()).getUsuariosList();

        List<Usuario> usuarioList = new ArrayList<>();

        usuarioGRPCS.forEach( usuarioGRPC -> {
            Usuario usuario = new Usuario(usuarioGRPC.getIdUsuario(), usuarioGRPC.getNombre(),
                    usuarioGRPC.getApellidoPaterno(), usuarioGRPC.getApellidoMaterno(), usuarioGRPC.getNombreUsuario());

            usuarioList.add(usuario);
        });
        return usuarioList;
    }

    public Usuario getByUsuario(String usuario){
        UsuarioGRPC usuarioGRPC = usuarioMethodBlockingStub.getUsuarioByUsuario(ssaver.gob.mx.humanos.catalogos.usuario.newBuilder().setNombreUsuario(usuario).build());

        Usuario usuarioModel = new Usuario(usuarioGRPC.getIdUsuario(), usuarioGRPC.getNombre(),
                usuarioGRPC.getApellidoPaterno(), usuarioGRPC.getApellidoMaterno(), usuarioGRPC.getNombreUsuario());

        return usuarioModel;
    }
}
