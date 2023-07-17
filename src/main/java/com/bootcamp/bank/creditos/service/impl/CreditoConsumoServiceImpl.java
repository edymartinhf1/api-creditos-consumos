package com.bootcamp.bank.creditos.service.impl;

import com.bootcamp.bank.creditos.model.dao.CargoConsumoDao;
import com.bootcamp.bank.creditos.model.dao.repository.CreditoConsumosRepository;
import com.bootcamp.bank.creditos.service.CreditoConsumoService;
import com.bootcamp.bank.creditos.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditoConsumoServiceImpl implements CreditoConsumoService {

    private final CreditoConsumosRepository creditoConsumosRepository;

    @Override
    public Mono<CargoConsumoDao> save(CargoConsumoDao operationCtaDao) {
        operationCtaDao = asignarValoresCargo.apply(operationCtaDao);
        return creditoConsumosRepository.save(operationCtaDao);
    }

    @Override
    public Flux<CargoConsumoDao> findByIdCliente(String idCliente) {
        return creditoConsumosRepository.findByIdCliente(idCliente);
    }

    @Override
    public Flux<CargoConsumoDao> findByNumeroCredito(String numeroCredito) {
        return creditoConsumosRepository.findByNumeroCredito(numeroCredito);
    }

    @Override
    public Flux<CargoConsumoDao> findCargosByNumeroCreditoAndBetweenDates(String numeroCredito, String fechaInicial, String fechaFinal) {
        LocalDateTime fecInicial =  Util.getLocalDatefromString(fechaInicial);
        LocalDateTime fecFinal = Util.getLocalDatefromString(fechaFinal);
        return creditoConsumosRepository.findByNumeroCreditoAndFechaConsumoBetween(numeroCredito,fecInicial,fecFinal);
    }


    Function<CargoConsumoDao,CargoConsumoDao> asignarValoresCargo = car -> {
        LocalDateTime fecha = LocalDateTime.now();
        car.setFechaConsumo(fecha);

        car.setFechaConsumoT(Util.getCurrentDateAsString("dd/MM/yyyy"));
        return car;
    };
}
