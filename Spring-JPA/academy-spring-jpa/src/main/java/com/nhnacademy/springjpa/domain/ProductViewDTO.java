package com.nhnacademy.springjpa.domain;

import java.math.BigDecimal;

public interface ProductViewDTO {
     String getModelName();
     String getProductImage();
     BigDecimal getUnitCost();
     String getDescription();
}
