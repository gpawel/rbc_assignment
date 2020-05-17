package org.pg.rbc.assignment.model;

import java.util.List;

public class Product {
    private String id;
    private String salesText;
    private String salesEnds;
    private String productEyeBrow;
    private String productBrand;
    private String productName;
    private String productSize;
    private String productText;
    private Price sellingPriceNow; // unit always Unit.EA
    private Price sellingPiceWas; // unit always Unit.EA
    private List<Price> comparisonPrices;

    public Product(String id,
                   String salesText,
                   String salesEnds,
                   String productEyeBrow,
                   String productBrand,
                   String productName,
                   String productSize,
                   String productText,
                   Price sellingPriceNow,
                   Price sellingPiceWas,
                   List<Price> comparisonPrices) {
        this.id = id;
        this.salesText = salesText;
        this.salesEnds = salesEnds;
        this.productEyeBrow = productEyeBrow;
        this.productBrand = productBrand;
        this.productName = productName;
        this.productSize = productSize;
        this.productText = productText;
        this.sellingPriceNow = sellingPriceNow;
        this.sellingPiceWas = sellingPiceWas;
        this.comparisonPrices = comparisonPrices;
    }

}
