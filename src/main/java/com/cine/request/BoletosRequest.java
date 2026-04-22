package com.cine.model.request;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class BoletosRequest {
    private String nombreCliente;
    private String peliculaId;
    private Integer cantidad;
    private String asientos;
    private BigDecimal precioUnitario;
    private BigDecimal total;
    private String metodoPago;
}
