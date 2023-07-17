package com.bootcamp.bank.creditos.model;

import lombok.Data;

@Data
public class CargoConsumoPost {
    private String idCliente;
    private String numeroCredito;
    private String fechaConsumoT;
    private Double importe;
}
