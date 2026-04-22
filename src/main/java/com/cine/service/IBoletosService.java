package com.cine.service;

import com.cine.model.request.BoletosRequest;
import com.cine.model.response.BoletosResponse;
import java.util.List;

public interface IBoletosService {
    List<BoletosResponse> obtenerTodos();
    BoletosResponse guardarBoleto(BoletosRequest request);
}