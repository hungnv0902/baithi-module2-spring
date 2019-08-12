package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    @Min(0)
    private Float dientich;
    @NotNull
    @Min(0)
    private Long danso;
    @NotNull
    @Min(0)
    private Float gdp;
    @NotEmpty
    private String mota;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(@NotEmpty String name, @NotNull @Min(0) Float dientich, @NotNull @Min(0) Long danso, @NotNull @Min(0) Float gdp, @NotEmpty String mota, Country country) {
        this.name = name;
        this.dientich = dientich;
        this.danso = danso;
        this.gdp = gdp;
        this.mota = mota;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDientich() {
        return dientich;
    }

    public void setDientich(Float dientich) {
        this.dientich = dientich;
    }

    public Long getDanso() {
        return danso;
    }

    public void setDanso(Long danso) {
        this.danso = danso;
    }

    public Float getGdp() {
        return gdp;
    }

    public void setGdp(Float gdp) {
        this.gdp = gdp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
