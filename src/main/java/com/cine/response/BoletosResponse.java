package com.cine.model.response;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BoletosResponse {
    private UUID id;
    private String nombreCliente;
    private String peliculaId;
    private Integer cantidad;
    private String asientos;
    private BigDecimal precioUnitario;
    private BigDecimal total;
    private String metodoPago;
    private LocalDateTime fecha;
}
