package com.cine.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "boletos")
public class Boletos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombreCliente;

    @Column(name = "pelicula_id", nullable = false)
    private String peliculaId;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "asientos", nullable = false)
    private String asientos;

    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "metodo_pago")
    private String metodoPago;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
}