package com.oilmeister.pricing.domain;

import java.math.BigDecimal;

public enum ProductType {

	CRUDE_OIL(new BigDecimal(1.13)), NATURAL_GAS(new BigDecimal(1.57)), GASOLINE(new BigDecimal(3.10)), KEROSENE(
			new BigDecimal(2.5)), HEATING_OIL(new BigDecimal(2.3));

	private BigDecimal pricePerGallon;

	private ProductType(BigDecimal pricePerGallon) {
		this.pricePerGallon = pricePerGallon.setScale(4, BigDecimal.ROUND_UP);
	}

	public BigDecimal getPricePerGallon() {
		return pricePerGallon;
	}

}
