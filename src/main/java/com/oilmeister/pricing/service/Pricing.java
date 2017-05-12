package com.oilmeister.pricing.service;

import java.math.BigDecimal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.oilmeister.pricing.domain.ProductType;
import com.oilmeister.pricing.domain.QuantityDiscountRate;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Pricing {

	@WebMethod
	public BigDecimal calculateFor(@WebParam(name = "productType") ProductType type,
			@WebParam(name = "quantity") Integer quantity) {
		BigDecimal discount = QuantityDiscountRate.discountFor(quantity);
		BigDecimal basePrice = type.getPricePerGallon().multiply(new BigDecimal(quantity)).setScale(4,
				BigDecimal.ROUND_UP);

		if (discount.equals(BigDecimal.ZERO)) {
			return basePrice;
		} else {
			return basePrice.multiply(discount);
		}

	}

}