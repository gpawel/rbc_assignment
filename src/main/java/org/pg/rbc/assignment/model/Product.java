package org.pg.rbc.assignment.model;

import java.util.List;

public class Product {
    private String id;
    private int productIndex;
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



}
