package com.bootcamp.bank.creditos.service;

import com.bootcamp.bank.creditos.model.dao.CargoConsumoDao;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CreditoConsumoService {
    Mono<CargoConsumoDao> save(CargoConsumoDao operationCtaDao);

    Flux<CargoConsumoDao> findByIdCliente(String idCliente);

    Flux<CargoConsumoDao> findByNumeroCredito(String numeroCredito);

    Flux<CargoConsumoDao> findCargosByNumeroCreditoAndBetweenDates(String numeroCredito,String fechaInicial, String fechaFinal);

    Flux<CargoConsumoDao> findMovsByIdClienteAndNumeroTarjetaCredito(String idCliente, String numeroTarjetaCredito);
}
