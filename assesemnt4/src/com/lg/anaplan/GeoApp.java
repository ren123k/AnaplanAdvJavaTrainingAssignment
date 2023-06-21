package com.lg.anaplan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GeoApp {
	public static void main(String[] args) {
		List<Country> countries = getCountries();

        //Most populated city of each continent
        Map<String, City> mostPopulatedCitiesByContinent = new HashMap<>();
        for (Country country : countries) {
            for (City city : country.getCities()) {
                String continent = country.getContinent();
                if (!mostPopulatedCitiesByContinent.containsKey(continent)
                        || city.getPopulation() > mostPopulatedCitiesByContinent.get(continent).getPopulation()) {
                    mostPopulatedCitiesByContinent.put(continent, city);
                }
            }
        }
        System.out.println("Most populated city by continent:");
        for (Map.Entry<String, City> entry : mostPopulatedCitiesByContinent.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }
        

        // 2. Find the highest-populated capital city
        City highestPopulatedCapital = null;
        for (Country country : countries) {
            if (country.getCapital() > 0) {
                City capital = getCityById(country.getCapital(), country.getCities());
                if (highestPopulatedCapital == null || capital.getPopulation() > highestPopulatedCapital.getPopulation()) {
                    highestPopulatedCapital = capital;
                }
            }
        }
        System.out.println("Highest populated capital city: " + highestPopulatedCapital.getName());
        
        

        // 3. Find the highest-populated capital city of each continent
        
        Map<String, City> highestPopulatedCapitalsByContinent = new HashMap<>();
        for (Country country : countries) {
            if (country.getCapital() > 0) {
                City capital = getCityById(country.getCapital(), country.getCities());
                String continent = country.getContinent();
                if (!highestPopulatedCapitalsByContinent.containsKey(continent)
                        || capital.getPopulation() > highestPopulatedCapitalsByContinent.get(continent).getPopulation()) {
                    highestPopulatedCapitalsByContinent.put(continent, capital);
                }
            }
        }
        System.out.println("Highest populated capital city by continent:");
        for (Map.Entry<String, City> entry : highestPopulatedCapitalsByContinent.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getName());
        }

        
        
        // 4. Sort the countries by the number of their cities in descending order
        countries.sort(Comparator.comparingInt(country -> country.getCities().size()));
        Collections.reverse(countries);
        System.out.println("Countries sorted by the number of cities (descending):");
        for (Country country : countries) {
            System.out.println(country.getName() + ": " + country.getCities().size() + " cities");
        }
    }

    // Helper method to get a city by its ID
    private static City getCityById(int cityId, List<City> cities) {
        for (City city : cities) {
            if (city.getId() == cityId) {
                return city;
            }
        }
        return null; // City not found
    }

    // To retrieve the list of countries
    private static List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        Country country1 = new Country();
        country1.setName("Country 1");
        country1.setContinent("Continent 1");
        country1.setCapital(1);
        country1.setPopulation(1000000);

        City city11 = new City();
        city11.setId(1);
        city11.setName("City 1");
        city11.setPopulation(500000);
        country1.getCities().add(city11);

        City city12 = new City();
        city12.setId(2);
        city12.setName("City 2");
        city12.setPopulation(800000);
        country1.getCities().add(city12);

        countries.add(country1);

        // Country 2
        Country country2 = new Country();
        country2.setName("Country 2");
        country2.setContinent("Continent 2");
        country2.setCapital(3);
        country2.setPopulation(2000000);

        City city21 = new City();
        city21.setId(3);
        city21.setName("City 3");
        city21.setPopulation(1200000);
        country2.getCities().add(city21);

        City city22 = new City();
        city22.setId(4);
        city22.setName("City 4");
        city22.setPopulation(1500000);
        country2.getCities().add(city22);

        countries.add(country2);

        // Add more countries and their cities...

        return countries;
	}

}
