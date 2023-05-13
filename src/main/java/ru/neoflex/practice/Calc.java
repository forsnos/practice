package ru.neoflex.practice;

import jakarta.persistence.*;

@Entity
@Table(name = "calc")
public class Calc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "summandOne")
    private int summandOne;

    @Column(name = "summandTwo")
    private int summandTwo;

    @Column(name = "result")
    private long result;

    @Column(name = "calcOperator")
    private CalcOperator calcOperator;

    public Calc() {}

    public Calc(int summandOne, int summandTwo, long result, CalcOperator calcOperator) {
        this.summandOne = summandOne;
        this.summandTwo = summandTwo;
        this.result = result;
        this.calcOperator = calcOperator;
    }
    public long getId() {
        return id;
    }
    public int getSummandOne() {
        return summandOne;
    }
    public int getSummandTwo() {
        return summandTwo;
    }
    public CalcOperator getCalcOperator() {
        return calcOperator;
    }
}