package org.pg.rbc.assignment.model;

import java.util.List;

public class Product implements Comparable<Product> {
    private String id;
    private int productIndex;
    //private String salesText;
    //private String salesEnds;
    //private String productEyeBrow;
    private String productBrand;
    private String productName;
    private String productSize;
    //private String productText;
    private Price sellingPriceNow; // unit always Unit.EA
    //private Price sellingPiceWas; // unit always Unit.EA
    private List<Price> comparisonPrices;

    /*
    public Product(String id, int productIndex, String salesText, String salesEnds, String productEyeBrow, String productBrand, String productName, String productSize, String productText, Price sellingPriceNow, Price sellingPiceWas, List<Price> comparisonPrices) {
        this.id = id;
        this.productIndex = productIndex;
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
     */

    public Product(String id, int productIndex, String productBrand, String productName, String productSize, Price sellingPriceNow, List<Price> comparisonPrices) {
        this.id = id;
        this.productIndex = productIndex;
        this.productBrand = productBrand;
        this.productName = productName;
        this.productSize = productSize;
        this.sellingPriceNow = sellingPriceNow;
        this.comparisonPrices = comparisonPrices;
    }

    @Override
    public int compareTo(Product p) {
        return this.sellingPriceNow.compareTo(p.getSellingPriceNow());
    }

    public String getId() {
        return id;
    }

    public int getProductIndex() {
        return productIndex;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public Price getSellingPriceNow() {
        return sellingPriceNow;
    }

    public List<Price> getComparisonPrices() {
        return comparisonPrices;
    }
}
