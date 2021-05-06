package demo.materiales.service;

import demo.materiales.model.Partida;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import ssaver.gob.mx.financieros.catalogos.EmptyGRPC;
import ssaver.gob.mx.financieros.catalogos.PartidaGRPC;
import ssaver.gob.mx.financieros.catalogos.PartidaMethodGrpc;
import ssaver.gob.mx.financieros.catalogos.idPartidaGRPC;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FinancierosGRPCService {

    @Inject
    @GrpcService("financieros")
    PartidaMethodGrpc.PartidaMethodBlockingStub partidaMethodBlockingStub;

    public List<Partida> listPartidas(){
        List<PartidaGRPC> partidaGRPCS = partidaMethodBlockingStub.getPartidas(EmptyGRPC.newBuilder().build()).getPartidasList();

        List<Partida> partidaList = new ArrayList<>();
        partidaGRPCS.forEach( partidaGRPC -> {
            Partida partida1 = new Partida(partidaGRPC.getIdPartida(), partidaGRPC.getClave(),
                    partidaGRPC.getDescripcion(), partidaGRPC.getUsuario());

            partidaList.add(partida1);
        });
        return partidaList;
    }

    public Partida getById(int id){
        PartidaGRPC partidaGRPC = partidaMethodBlockingStub.getPartidaById(idPartidaGRPC.newBuilder().setIdPartida(id).build());

        Partida partida = new Partida(partidaGRPC.getIdPartida(), partidaGRPC.getClave()
                , partidaGRPC.getDescripcion(), partidaGRPC.getUsuario());

        return partida;
    }
}
