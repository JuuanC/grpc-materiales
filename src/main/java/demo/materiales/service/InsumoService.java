package demo.materiales.service;

import demo.materiales.dto.InsumoDTO;
import demo.materiales.model.Insumo;
import demo.materiales.model.Partida;
import demo.materiales.model.Usuario;
import demo.materiales.repository.InsumoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class InsumoService {

    @Inject
    InsumoRepository insumoRepository;

    @Inject
    FinancierosGRPCService financierosGRPCService;

    @Inject
    UsuarioGRPCService usuarioGRPCService;

    public Insumo getById(int id) {
        Insumo insumo = insumoRepository.findById((long) id);

        return insumo;
    }

    public InsumoDTO getDetail(int id) {

        Insumo insumo = insumoRepository.findById((long) id);

        Usuario usuario = usuarioGRPCService.getByUsuario(insumo.getUsuario());

        Partida partida = financierosGRPCService.getById(insumo.getIdPartida());

        InsumoDTO insumoDTO = new InsumoDTO(insumo.getDescripcion(), insumo.getClave(),
                partida.getDescripción(), usuario.getNombre().concat(" ").concat(usuario.getApellidoPaterno()).concat(" ").concat(usuario.getApellidoMaterno()));

        return insumoDTO;
    }
}
