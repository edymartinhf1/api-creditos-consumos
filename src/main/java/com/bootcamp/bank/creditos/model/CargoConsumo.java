package com.bootcamp.bank.creditos.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CargoConsumo {
    private String idCliente;
    private String numeroCredito;
    private String numeroTarjetaCredito;
    private LocalDateTime fechaConsumo;
    private String fechaConsumoT;
    private Double importe;

}