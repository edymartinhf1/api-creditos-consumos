package com.bootcamp.bank.creditos.model;

import lombok.Data;

@Data
public class CargoConsumoPost {
    private String idCliente;
    private String numeroCredito;
    private String numeroTarjetaCredito;
    private String fechaConsumoT;
    private Double importe;
}
