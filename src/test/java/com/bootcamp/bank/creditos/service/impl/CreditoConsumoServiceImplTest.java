package com.bootcamp.bank.creditos.service.impl;

import com.bootcamp.bank.creditos.model.dao.CargoConsumoDao;
import com.bootcamp.bank.creditos.model.dao.repository.CreditoConsumosRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@Log4j2
class CreditoConsumoServiceImplTest {


    @Mock
    private CreditoConsumosRepository creditoConsumosRepository;

    @InjectMocks
    private CreditoConsumoServiceImpl creditoConsumoService;

    @Test
    void save() {
        CargoConsumoDao expected = new CargoConsumoDao();
        expected.setId("1");
        expected.setNumeroTarjetaCredito("004-00564554");
        expected.setNumeroCredito("003-0045");

        CargoConsumoDao cargoConsumo = new CargoConsumoDao();
        cargoConsumo.setId("1");
        cargoConsumo.setNumeroTarjetaCredito("004-00564554");
        cargoConsumo.setNumeroCredito("003-0045");

        Mockito.when( creditoConsumosRepository.save(Mockito.any(CargoConsumoDao.class)) )
                .thenReturn( Mono.just(cargoConsumo) );
        log.info("step 1 "+cargoConsumo.toString());

        CargoConsumoDao cargoActualiza=new CargoConsumoDao();
        cargoActualiza.setId("1");
        cargoActualiza.setNumeroCredito("003-0045");
        cargoActualiza.setNumeroTarjetaCredito("004-00564554");

        Mono<CargoConsumoDao> pago0 = creditoConsumosRepository.save(cargoActualiza);
        CargoConsumoDao cargosConsumo=pago0.block();
        log.info("step 2 "+cargoConsumo.toString());

        Assertions.assertEquals(expected.getId(),cargosConsumo.getId());
        Assertions.assertEquals(expected.getNumeroTarjetaCredito(),cargosConsumo.getNumeroTarjetaCredito());
        Assertions.assertEquals(expected.getNumeroCredito(),cargosConsumo.getNumeroCredito());
    }

    @Test
    void findByIdCliente() {
        CargoConsumoDao espero = new CargoConsumoDao();
        espero.setId("1");
        espero.setIdCliente("123456");
        espero.setNumeroCredito("003-004545");;
        espero.setNumeroTarjetaCredito("004-0056488");


        CargoConsumoDao cargoConsumo = new CargoConsumoDao();
        cargoConsumo.setId("1");
        cargoConsumo.setIdCliente("123456");
        cargoConsumo.setNumeroCredito("003-004545");;
        cargoConsumo.setNumeroTarjetaCredito("004-0056488");

        Mockito.when( creditoConsumosRepository.findByIdCliente("123456") )
                .thenReturn(Flux.just(cargoConsumo));

        Flux<CargoConsumoDao> cargos = creditoConsumosRepository.findByIdCliente("123456");

        List<CargoConsumoDao> cargosList = cargos.collectList().block();
        log.info("  "+cargosList.toString());
        CargoConsumoDao cargo= cargosList.get(0);
        Assertions.assertEquals(espero.getId(),cargo.getId());
        Assertions.assertEquals(espero.getNumeroTarjetaCredito(),cargo.getNumeroTarjetaCredito());
        Assertions.assertEquals(espero.getNumeroCredito(),cargo.getNumeroCredito());
    }

    @Test
    void findByNumeroCredito() {
    }

    @Test
    void findCargosByNumeroCreditoAndBetweenDates() {
    }

    @Test
    void findMovsByIdClienteAndNumeroTarjetaCredito() {
    }
}