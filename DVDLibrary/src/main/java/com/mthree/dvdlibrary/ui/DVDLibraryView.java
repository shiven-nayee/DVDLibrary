/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.ui;

import com.mthree.dvdlibrary.dto.DVD;

import java.util.List;

/**
 *
 * @author Jeonghoon
 */
public class DVDLibraryView {
    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Create a DVD");
        io.print("2. Delete a DVD");
        io.print("3. Update a DVD");
        io.print("4. List DVDs");
        io.print("5. View a DVD");
        io.print("6. Search for DVD");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter Release Date");
        String rating = io.readString("Please enter Rating");
        String directorName = io.readString("Please enter Director Name");
        String studio = io.readString("Please enter Studio");
        String userRating = io.readString("Please enter User Rating");
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setRating(rating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserRating(userRating);
        return currentDVD;
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String studentInfo = String.format("#%s : %s %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getRating());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public DVD displayEditDVDMenu(DVD dvdForEditing) {
        io.print("Edit Menu");
        io.print("1. Change Title");
        io.print("2. Change Release Date");
        io.print("3. Change Rating");
        io.print("4. Change Director Name");
        io.print("5. Change Studio");
        io.print("6. Change User Rating");
        io.print("7. Exit");

        int userChoice = io.readInt("Please select from the above choices.", 1, 7);

        switch (userChoice) {
            case 1:
                String title = io.readString("Please enter new title");
                dvdForEditing.setTitle(title);
                break;
        }

        return dvdForEditing;
    }

    public String getUpdatedTitle() {
        return io.readString("Please enter new title.");
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public void displayEditDVDBanner () {
        io.print("=== Edit DVD ===");
    }

    public void displaySearchDVDBanner () {
        io.print("=== Search DVD ===");
    }

    public String getDVDTitle() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayRemoveDVDBanner() {
        io.print("=== Remove DVD ===");
    }

    public void displayEditResult(DVD dvd) {
        if(dvd != null){
            io.print("DVD successfully updated.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveResult(DVD dvd) {
        if(dvd != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
