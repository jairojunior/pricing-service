package com.oilmeister.pricing.domain;

import java.math.BigDecimal;

public enum QuantityDiscountRate {

	SMALL(42, BigDecimal.ZERO), MEDIUM(420, new BigDecimal(5)), BIG(4200, BigDecimal.TEN);

	private Integer numberOfGallons;
	private BigDecimal discountRate;

	QuantityDiscountRate(Integer numberOfGallons, BigDecimal discountRate) {
		this.numberOfGallons = numberOfGallons;
		this.discountRate = discountRate.setScale(4, BigDecimal.ROUND_UP);
	}

	public static BigDecimal discountFor(Integer quantity) {
		BigDecimal discount = BigDecimal.ZERO;

		if (quantity >= BIG.getNumberOfGallons()) {
			discount = BIG.getDiscountRate();
		} else if (quantity >= MEDIUM.getNumberOfGallons()) {
			discount = MEDIUM.getDiscountRate();
		}

		return discount;
	}

	public Integer getNumberOfGallons() {
		return numberOfGallons;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}
}
