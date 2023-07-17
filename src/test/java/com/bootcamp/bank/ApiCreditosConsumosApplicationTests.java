package com.bootcamp.bank;

import com.bootcamp.bank.creditos.service.CreditoConsumoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ApiCreditosConsumosApplicationTests {
	@Autowired
	private CreditoConsumoService creditoConsumoService;

	@Test
	void contextLoads() {
		assertThat(creditoConsumoService).isNotNull();
	}

}
