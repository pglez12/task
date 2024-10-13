package com.ejemplo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Juego entity
 * 
 * @author Grupo1
 * @version 1.4
 * @date 09-10-2024
 */

@Entity
@Table(name = "juegos")
public class Juego {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rank;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;

    @Column(name = "na_sales")
    private double naSales;

    @Column(name = "eu_sales")
    private double euSales;

    @Column(name = "jp_sales")
    private double jpSales;

    @Column(name = "other_sales")
    private double otherSales;

    @Column(name = "global_sales")
    private double globalSales;

    public Juego() {}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getNaSales() {
        return naSales;
    }

    public void setNaSales(double naSales) {
        this.naSales = naSales;
    }

    public double getEuSales() {
        return euSales;
    }

    public void setEuSales(double euSales) {
        this.euSales = euSales;
    }

    public double getJpSales() {
        return jpSales;
    }

    public void setJpSales(double jpSales) {
        this.jpSales = jpSales;
    }

    public double getOtherSales() {
        return otherSales;
    }

    public void setOtherSales(double otherSales) {
        this.otherSales = otherSales;
    }

    public double getGlobalSales() {
        return globalSales;
    }

    public void setGlobalSales(double globalSales) {
        this.globalSales = globalSales;
    }

    @Override
    public String toString() {
        return "Juego{" + "id=" + id + ", rank=" + rank + ", name='" + name + '\'' +
                ", platform='" + platform + '\'' + ", year=" + year + ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' + ", naSales=" + naSales + ", euSales=" + euSales +
                ", jpSales=" + jpSales + ", otherSales=" + otherSales + ", globalSales=" + globalSales + '}';
    }
}
