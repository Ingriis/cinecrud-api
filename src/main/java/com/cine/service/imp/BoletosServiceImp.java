package com.cine.service.imp;

import com.cine.entity.Boletos;
import com.cine.model.request.BoletosRequest;
import com.cine.model.response.BoletosResponse;
import com.cine.repository.IBoletoRepository;
import com.cine.service.IBoletosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoletosServiceImp implements IBoletosService {

    @Autowired
    private IBoletoRepository boletoRepository;

    @Override
    public List<BoletosResponse> obtenerTodos() {
        List<BoletosResponse> responseList = new ArrayList<>();
        List<Boletos> boletos = boletoRepository.findAll();

        for (Boletos b : boletos) {
            responseList.add(mapToResponse(b));
        }
        return responseList;
    }

    @Override
    public BoletosResponse guardarBoleto(BoletosRequest request) {
        Boletos boleto = new Boletos();
        boleto.setNombreCliente(request.getNombreCliente());
        boleto.setPeliculaId(request.getPeliculaId());
        boleto.setCantidad(request.getCantidad());
        boleto.setAsientos(request.getAsientos());
        boleto.setPrecioUnitario(request.getPrecioUnitario());
        boleto.setTotal(request.getTotal());
        boleto.setMetodoPago(request.getMetodoPago());
        boleto.setFecha(LocalDateTime.now());

        Boletos boletoSaved = boletoRepository.save(boleto);

        return mapToResponse(boletoSaved);
    }

    private BoletosResponse mapToResponse(Boletos entity) {
        BoletosResponse response = new BoletosResponse();
        response.setId(entity.getId());
        response.setNombreCliente(entity.getNombreCliente());
        response.setPeliculaId(entity.getPeliculaId());
        response.setCantidad(entity.getCantidad());
        response.setAsientos(entity.getAsientos());
        response.setPrecioUnitario(entity.getPrecioUnitario());
        response.setTotal(entity.getTotal());
        response.setMetodoPago(entity.getMetodoPago());
        response.setFecha(entity.getFecha());
        return response;
    }
}