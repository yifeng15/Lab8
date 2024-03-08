package com.example.lab8;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest{
    /**
     * create a mocklist for my citylist
     * @return
     */
    private CustomList list;


    public CustomList mockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */

    @Test
    public void addCityTest(){
        list = mockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void deleteCityTest(){
        list = mockCityList();
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    void testDeleteException() {
        list = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });
    }

    @Test
    void testHasCity() {
        list = mockCityList();
        City city = new City("Edmonton", "Alberta");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    void testCountCities() {
        list = mockCityList();
        assertEquals(list.getCount(), 0);

        int expectedCount = 10;
        for (int i=0; i<expectedCount; i++) {
            list.addCity(new City("A", "B"));
        }

        assertEquals(list.getCount(), expectedCount);
    }
}
