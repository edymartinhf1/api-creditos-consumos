package com.bootcamp.bank.creditos.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("cargosconsumo")
public class CargoConsumoDao {
    @Id
    private String id;
    private String idCliente;
    private String numeroCredito;
    private LocalDateTime fechaConsumo;
    private String fechaConsumoT;
    private String numeroTarjetaCredito;
    private Double importe;
}