/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mthree.dvdlibrary.dao;

import java.util.List;

import com.mthree.dvdlibrary.dto.DVD;

/**
 *
 * @author Jeonghoon
 */
public interface DVDLibraryDao {
    // Adds a DVD to the library
    DVD addDVD(DVD d);
    
    // Remove DVD
    DVD removeDVD(String title);

    // Edit DVD information
    DVD editDVD(String title, DVD newInfo);

    // Returns all the DVDS
    List<DVD> listDVDs();
    
    // Returns one DVD
    DVD getDVD(String title);
    
    // Search if DVD exists
    boolean searchDVD(String title);

    void getDVDInformation(String title);
}
