package com.bootcamp.bank.creditos.controller;

import com.bootcamp.bank.creditos.model.CargoConsumo;
import com.bootcamp.bank.creditos.model.CargoConsumoPost;
import com.bootcamp.bank.creditos.model.dao.CargoConsumoDao;
import com.bootcamp.bank.creditos.service.CreditoConsumoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase Controller Consumo Credito
 */
@RestController
@RequestMapping("/creditos/tarjetas/cargos")
@Log4j2
@RequiredArgsConstructor
public class CreditoConsumoController {


    private final CreditoConsumoService creditoConsumoService;

    /**
     * Permite cargar consumos a sus tarjetas de crédito
     * @param cargoConsumo
     * @return
     */
    @PostMapping
    public Mono<CargoConsumo> save(@RequestBody CargoConsumoPost cargoConsumo){

        return creditoConsumoService.save(fromCargoConsumoPostToCargoConsumoDao(cargoConsumo))
                .map(this::fromCargoConsumoDaoToCargoConsumoDto);
    }


    /**
     * Permite obtener consumos por cliente
     * @param idCliente
     * @return
     */
    @GetMapping("/{id}")
    public Flux<CargoConsumo> findConsumosByIdCliente(@PathVariable(name = "id") String idCliente) {
        return creditoConsumoService.findByIdCliente(idCliente).map(this::fromCargoConsumoDaoToCargoConsumoDto);

    }

    /**
     * Permite obtener consumos por numero de credito
     * @param numeroCredito
     * @return
     */
    @GetMapping("/numero-credito/{numeroCredito}")
    public Flux<CargoConsumo> findPagosByNumeroCredito(@PathVariable(name = "numeroCredito") String numeroCredito) {
        return creditoConsumoService.findByNumeroCredito(numeroCredito)
                .map(this::fromCargoConsumoDaoToCargoConsumoDto);

    }

    @GetMapping("/numerocredito/{numeroCredito}/fechainicio/{fechaInicial}/fechafin/{fechaFinal}")
    public Flux<CargoConsumo> findCargosByNumeroCreditoAndBetweenDates(
            @PathVariable(name = "numeroCredito") String numeroCredito,
            @PathVariable(name = "fechaInicial") String fechaInicial,
            @PathVariable(name = "fechaFinal") String fechaFinal
    ) {
        if (log.isDebugEnabled()) {
            log.info("numero credito " + numeroCredito);
            log.info("fecha inicial " + fechaInicial);
            log.info("fecha final " + fechaFinal);
        }
        return creditoConsumoService.findCargosByNumeroCreditoAndBetweenDates(numeroCredito,fechaInicial,fechaFinal)
                .map(this::fromCargoConsumoDaoToCargoConsumoDto);
    }

    private CargoConsumo fromCargoConsumoDaoToCargoConsumoDto(CargoConsumoDao cargoConsumoDao) {
        CargoConsumo cargoConsumo = new CargoConsumo();
        BeanUtils.copyProperties(cargoConsumoDao, cargoConsumo);
        return cargoConsumo;
    }

    private CargoConsumoDao fromCargoConsumoPostToCargoConsumoDao(CargoConsumoPost cargoCargaConsumoPost) {
        CargoConsumoDao cargaConsumoDao = new CargoConsumoDao();
        BeanUtils.copyProperties(cargoCargaConsumoPost,cargaConsumoDao);
        return cargaConsumoDao;
    }
}
