/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mthree.dvdlibrary.dto.DVD;

/**
 *
 * @author Jeonghoon
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private Map<String, DVD> DVDLibrary = new HashMap<>();

    @Override
    public DVD addDVD(DVD d) {
        DVDLibrary.put(d.getTitle(), d);
        return d;
    }

    @Override
    public List<DVD> listDVDs() {
        System.out.println("DVDs in the list");
        Set<String> AllTitles = DVDLibrary.keySet();
        for(String title : AllTitles) {
            System.out.println(title);
        }
        return null;
    }
    
    @Override
    public DVD getDVD(String title) {
        return DVDLibrary.get(title);
    }
    
    @Override
    public DVD removeDVD(String title) {
        return DVDLibrary.remove(title);
    }
    
    @Override
    public boolean searchDVD(String title) {
        return DVDLibrary.containsKey(title);
    }
    
    @Override
    public DVD editDVD(String title, DVD newInfo) {
        removeDVD(title);
        addDVD(newInfo);
        return null;
    }

    @Override
    public void getDVDInformation(String title) {
        DVD d = DVDLibrary.get(title);
        System.out.println("Title: " + d.getTitle());
        System.out.println("Director: " + d.getDirectorName());
        System.out.println("Rating: " + d.getRating());
        System.out.println("Studio: " + d.getStudio());
        System.out.println("User rating: " + d.getUserRating());
    }
}
