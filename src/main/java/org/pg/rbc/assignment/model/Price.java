package org.pg.rbc.assignment.model;

import org.pg.rbc.assignment.utils.MathUtils;

import java.text.DecimalFormat;

public class Price implements Comparable<Price> {

    public static double KG_TO_LB = 2.20462;
    public static DecimalFormat formatDecimal = new DecimalFormat("##.00");

    private double value;
    private String type="";
    private Unit unit;


    public Price(double value, String type, Unit unit) {
        if (unit == Unit.HNDGR) {
            this.value = 10*value;
            this.unit = Unit.KG;
        }
        else {
            this.value = value;
            this.unit = unit;
        }
        this.type = type;

    }

    public Price(double value, Unit unit) {
        this(value, "",unit);
    }

    public String getType() {
        return type;
    }

    public Unit getUnit() {
        return unit;
    }

    public double getValue() {
        return MathUtils.roundDouble(value,2);
    }

    public String getValueAsString() {
        return formatDecimal.format(value);
    }

    public double getPricePer(Unit unit) {
        if ((this.unit == Unit.EA) && (unit == Unit.EA)) return value;
        else if ((this.unit == Unit.EA) && (unit != Unit.EA)) throw new RuntimeException("Unable to convert price per unit into price per Kg or Lb");
        else if ((this.unit == Unit.KG) && (unit == Unit.KG)) return value;
        else if ((this.unit == Unit.KG) && (unit == Unit.LB)) return value / KG_TO_LB;
        else if ((this.unit == Unit.KG) && (unit == Unit.HNDML)) throw new RuntimeException("Unable to convert Kg into mL");
        else if ((this.unit == Unit.LB) && (unit == Unit.LB)) return value;
        else if ((this.unit == Unit.LB) && (unit == Unit.KG)) return value * KG_TO_LB;
        else if ((this.unit == Unit.LB) && (unit == Unit.HNDML)) throw new RuntimeException("Unable to convert LB into mL");
        else if ((this.unit == Unit.HNDML) && (unit == Unit.HNDML)) return value;
        else throw new RuntimeException("Unable to convert "+this.unit.toString()+" into "+unit.toString());
    }

    @Override
    public int compareTo(Price p) {
        double compare = p.getPricePer(this.unit);
        if ( value < compare ) return -1;
        else if ( value == compare ) return 0;
        else return 1;
    }
}
