package com.lg.anaplan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maingeoapp {
	public static void main(String[] args) {
		
		List<Country> countries = createSampleData();

        //  Most populated city of each continent
		
        Map<String, City> mostPopulatedCitiesByContinent = findMostPopulatedCitiesByContinent(countries);
        System.out.println("Most Populated City by Continent:");
        for (String continent : mostPopulatedCitiesByContinent.keySet()) {
            City city = mostPopulatedCitiesByContinent.get(continent);
            System.out.println(continent + ": " + city.getName() + " (" + city.getPopulation() + " population)");
        }
        System.out.println();
        
        

        // Find the highest-populated capital city
        
        City highestPopulatedCapitalCity = findHighestPopulatedCapitalCity(countries);
        System.out.println("Highest-Populated Capital City:");
        System.out.println(highestPopulatedCapitalCity.getName() + " (" + highestPopulatedCapitalCity.getPopulation() + " population)");
        System.out.println();
        

        // Find the highest-populated capital city of each continent
        
        Map<String, City> highestPopulatedCapitalCitiesByContinent = findHighestPopulatedCapitalCityByContinent(countries);
        System.out.println("Highest-Populated Capital City by Continent:");
        for (String continent : highestPopulatedCapitalCitiesByContinent.keySet()) {
            City city = highestPopulatedCapitalCitiesByContinent.get(continent);
            System.out.println(continent + ": " + city.getName() + " (" + city.getPopulation() + " population)");
        }
        System.out.println();
        
        

        // Sort the countries by the number of their cities in descending order
        
        List<Country> countriesSortedByCityCount = sortCountriesByCityCount(countries);
        System.out.println("Countries Sorted by City Count:");
        for (Country country : countriesSortedByCityCount) {
            System.out.println(country.getName() + ": " + country.getCities().size() + " cities");
        }
        System.out.println();
        

        // Sort the countries by their population densities in descending order ignoring zero-population countries
        
        List<Country> countriesSortedByPopulationDensity = sortCountriesByPopulationDensity(countries);
        System.out.println("Countries Sorted by Population Density (Ignoring Zero-Population Countries):");
        for (Country country : countriesSortedByPopulationDensity) {
            System.out.println(country.getName() + ": " + calculatePopulationDensity(country) + " population density");
        }
        System.out.println();
        
        

        // Find the cities with the minimum and the maximum population in countries
        
        Map<String, City> citiesWithMinMaxPopulation = findCitiesWithMinMaxPopulation(countries);
        System.out.println("City with Minimum Population: " + citiesWithMinMaxPopulation.get("min").getName()
                + " (" + citiesWithMinMaxPopulation.get("min").getPopulation() + " population)");
        System.out.println("City with Maximum Population: " + citiesWithMinMaxPopulation.get("max").getName()
                + " (" + citiesWithMinMaxPopulation.get("max").getPopulation() + " population)");
        System.out.println();
        

        // Sort the countries by their population densities in descending order ignoring zero-population countries
        List<Country> countriesSortedByPopulationDensityIgnoringZeroPopulation = sortCountriesByPopulationDensityIgnoringZeroPopulation(countries);
        System.out.println("Countries Sorted by Population Density (Ignoring Zero-Population Countries):");
        for (Country country : countriesSortedByPopulationDensityIgnoringZeroPopulation) {
            System.out.println(country.getName() + ": " + calculatePopulationDensity(country) + " population density");
        }
        System.out.println();
        
        

        // Find the richest country of each continent with respect to their GNP values
        
        Map<String, Country> richestCountriesByContinent = findRichestCountryByContinent(countries);
        System.out.println("Richest Country by Continent (GNP):");
        for (String continent : richestCountriesByContinent.keySet()) {
            Country country = richestCountriesByContinent.get(continent);
            System.out.println(continent + ": " + country.getName() + " ($" + country.getGnp() + " GNP)");
        }
        System.out.println();
        

        // Find the minimum, the maximum and the average population of world countries
        
        int minimumPopulation = findMinimumPopulation(countries);
        int maximumPopulation = findMaximumPopulation(countries);
        double averagePopulation = findAveragePopulation(countries);
        System.out.println("Minimum Population: " + minimumPopulation);
        System.out.println("Maximum Population: " + maximumPopulation);
        System.out.println("Average Population: " + averagePopulation);
    }
	

    private static List<Country> createSampleData() {
        
    	// Creating sammple data for testing.................
    	
        List<Country> countries = new ArrayList<>();

        // Country 1
        Country country1 = new Country();
        country1.setCode("INDIA");
        country1.setName("IN");
        country1.setContinent("North INDIA");
        country1.setSurfaceArea(9833520);
        country1.setPopulation(331002651);
        country1.setGnp(22635225);
        country1.setCapital(1);

        // Add cities to country 1
        List<City> cities1 = new ArrayList<>();
        City city1 = new City();
        city1.setId(1);
        city1.setName("INDIA");
        city1.setPopulation(8336817);
        city1.setCountryCode("IN");
        cities1.add(city1);

        City city2 = new City();
        city2.setId(2);
        city2.setName("NEW YORK");
        city2.setPopulation(3977683);
        city2.setCountryCode("USA");
        cities1.add(city2);

        country1.setCities(cities1);

        // Country 2
        Country country2 = new Country();
        country2.setCode("NPL");
        country2.setName("Nepal");
        country2.setContinent("Asia");
        country2.setSurfaceArea(9640011);
        country2.setPopulation(1444216107);
        country2.setGnp(15328324);
        country2.setCapital(1891);

        // Add cities to country 2
        List<City> cities2 = new ArrayList<>();
        City city3 = new City();
        city3.setId(3);
        city3.setName("Shanghai");
        city3.setPopulation(24256800);
        city3.setCountryCode("NPL");
        cities2.add(city3);

        City city4 = new City();
        city4.setId(4);
        city4.setName("Beijing");
        city4.setPopulation(21707000);
        city4.setCountryCode("NPL");
        cities2.add(city4);

        country2.setCities(cities2);

        // Add countries to the list
        countries.add(country1);
        countries.add(country2);

        return countries;
    }
    
 // Most populated city of each continent
    private static Map<String, City> findMostPopulatedCitiesByContinent(List<Country> countries) {
        Map<String, City> mostPopulatedCitiesByContinent = new HashMap<>();

        for (Country country : countries) {
            String continent = country.getContinent();
            List<City> cities = country.getCities();
            City mostPopulatedCity = null;

            for (City city : cities) {
                if (mostPopulatedCity == null || city.getPopulation() > mostPopulatedCity.getPopulation()) {
                    mostPopulatedCity = city;
                }
            }

            if (mostPopulatedCity != null) {
                mostPopulatedCitiesByContinent.put(continent, mostPopulatedCity);
            }
        }

        return mostPopulatedCitiesByContinent;
    }

    // Find the highest-populated capital city
    private static City findHighestPopulatedCapitalCity(List<Country> countries) {
        City highestPopulatedCapitalCity = null;

        for (Country country : countries) {
            int capitalId = country.getCapital();
            List<City> cities = country.getCities();

            for (City city : cities) {
                if (city.getId() == capitalId) {
                    if (highestPopulatedCapitalCity == null || city.getPopulation() > highestPopulatedCapitalCity.getPopulation()) {
                        highestPopulatedCapitalCity = city;
                    }
                    break;
                }
            }
        }

        return highestPopulatedCapitalCity;
    }

    // Find the highest-populated capital city of each continent
    private static Map<String, City> findHighestPopulatedCapitalCityByContinent(List<Country> countries) {
        Map<String, City> highestPopulatedCapitalCitiesByContinent = new HashMap<>();

        for (Country country : countries) {
            String continent = country.getContinent();
            int capitalId = country.getCapital();
            List<City> cities = country.getCities();
            City highestPopulatedCapitalCity = null;

            for (City city : cities) {
                if (city.getId() == capitalId) {
                    if (highestPopulatedCapitalCity == null || city.getPopulation() > highestPopulatedCapitalCity.getPopulation()) {
                        highestPopulatedCapitalCity = city;
                    }
                    break;
                }
            }

            if (highestPopulatedCapitalCity != null) {
                highestPopulatedCapitalCitiesByContinent.put(continent, highestPopulatedCapitalCity);
            }
        }

        return highestPopulatedCapitalCitiesByContinent;
    }

    // Sort the countries by the number of their cities in descending order
    private static List<Country> sortCountriesByCityCount(List<Country> countries) {
        List<Country> sortedCountries = new ArrayList<>(countries);

        sortedCountries.sort(Comparator.comparingInt(country -> country.getCities().size()));
        Collections.reverse(sortedCountries);

        return sortedCountries;
    }

    // Sort the countries by their population densities in descending order ignoring zero-population countries
    private static List<Country> sortCountriesByPopulationDensity(List<Country> countries) {
        List<Country> sortedCountries = new ArrayList<>(countries);

        sortedCountries.sort(Comparator.comparingDouble(Maingeoapp::calculatePopulationDensity));
        Collections.reverse(sortedCountries);

        return sortedCountries;
    }

    // Method to calculate population density
    private static double calculatePopulationDensity(Country country) {
        if (country.getPopulation() != 0 && country.getSurfaceArea() != 0) {
            return country.getPopulation() / country.getSurfaceArea();
        }
        return 0;
    }

    //Find the cities with the minimum and the maximum population in countries
    private static Map<String, City> findCitiesWithMinMaxPopulation(List<Country> countries) {
        Map<String, City> citiesWithMinMaxPopulation = new HashMap<>();
        City cityWithMinPopulation = null;
        City cityWithMaxPopulation = null;

        for (Country country : countries) {
            List<City> cities = country.getCities();

            for (City city : cities) {
                if (cityWithMinPopulation == null || city.getPopulation() < cityWithMinPopulation.getPopulation()) {
                    cityWithMinPopulation = city;
                }

                if (cityWithMaxPopulation == null || city.getPopulation() > cityWithMaxPopulation.getPopulation()) {
                    cityWithMaxPopulation = city;
                }
            }
        }

        citiesWithMinMaxPopulation.put("min", cityWithMinPopulation);
        citiesWithMinMaxPopulation.put("max", cityWithMaxPopulation);

        return citiesWithMinMaxPopulation;
    }

    //Sort the countries by their population densities in descending order ignoring zero-population countries
    private static List<Country> sortCountriesByPopulationDensityIgnoringZeroPopulation(List<Country> countries) {
        List<Country> sortedCountries = new ArrayList<>(countries);

        sortedCountries.sort(Comparator.comparingDouble(Maingeoapp::calculatePopulationDensity).reversed());
        sortedCountries.removeIf(country -> country.getPopulation() == 0);

        return sortedCountries;
    }

    // Richest country of each continent with respect to their GNP values
    private static Map<String, Country> findRichestCountryByContinent(List<Country> countries) {
        Map<String, Country> richestCountriesByContinent = new HashMap<>();

        for (Country country : countries) {
            String continent = country.getContinent();
            Country richestCountry = richestCountriesByContinent.get(continent);

            if (richestCountry == null || country.getGnp() > richestCountry.getGnp()) {
                richestCountriesByContinent.put(continent, country);
            }
        }

        return richestCountriesByContinent;
    }

    //Maximum and the average population of world countries
    private static int findMinimumPopulation(List<Country> countries) {
        int minimumPopulation = Integer.MAX_VALUE;

        for (Country country : countries) {
            int population = country.getPopulation();
            if (population < minimumPopulation) {
                minimumPopulation = population;
            }
        }

        return minimumPopulation;
    }

    private static int findMaximumPopulation(List<Country> countries) {
        int maximumPopulation = Integer.MIN_VALUE;

        for (Country country : countries) {
            int population = country.getPopulation();
            if (population > maximumPopulation) {
                maximumPopulation = population;
            }
        }

        return maximumPopulation;
    }

    private static double findAveragePopulation(List<Country> countries) {
        int totalPopulation = 0;
        int countryCount = countries.size();

        for (Country country : countries) {
            totalPopulation += country.getPopulation();
        }

        return (double) totalPopulation / countryCount;
    }
}


