package com.bootcamp.bank.creditos.model.dao.repository;

import com.bootcamp.bank.creditos.model.dao.CargoConsumoDao;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Repository
public interface CreditoConsumosRepository extends ReactiveMongoRepository<CargoConsumoDao,String> {

    @Query("{'idCliente':?0}")
    Flux<CargoConsumoDao> findByIdCliente(String idCliente);
    @Query("{'numeroCredito':?0}")
    Flux<CargoConsumoDao> findByNumeroCredito(String numeroCredito);

    Flux<CargoConsumoDao> findByNumeroCreditoAndFechaConsumoBetween(String numeroCuenta, LocalDateTime fechaInicial, LocalDateTime fechaFinal);


}