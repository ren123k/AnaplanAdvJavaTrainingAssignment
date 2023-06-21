package com.lg.anaplan;

import java.util.ArrayList;
import java.util.List;

public class Country {
	private String code;
	private String name;
	private String continent;
	private double surfaceArea;
	private int population;
	private double gnp;
	private int capital;
    private List<City> cities;

    // Constructor
    public Country() {
        cities = new ArrayList<>();
    }

	
	/*
	public Country(String code, String name, String continent, double surfaceArea, int population, double gnp,
			int capital, List<City> cities) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.population = population;
		this.gnp = gnp;
		this.capital = capital;
		this.cities = cities;
	}
	
	*/
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public double getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public double getGnp() {
		return gnp;
	}
	public void setGnp(double gnp) {
		this.gnp = gnp;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
	
	

}
