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

    public int printEditMenuAndGetSelection() {
        io.print("Edit Menu");
        io.print("1. Change Title");
        io.print("2. Change Release Date");
        io.print("3. Change Rating");
        io.print("4. Change Director Name");
        io.print("5. Change Studio");
        io.print("6. Change User Rating");
        io.print("7. Save & Exit");
        io.print("8. Exit without save");

        return io.readInt("Please select from the above choices.", 1, 8);
    }

    public boolean displayEditDVDMenu(DVD dvdForEditing) {
        boolean keepGoing = true;

        int userChoice = 8;
        while (keepGoing) {
            userChoice = printEditMenuAndGetSelection();

            switch (userChoice) {
                case 1:
                    io.print("Old title: " + dvdForEditing.getTitle());
                    String newTitle = io.readString("Please enter new title");
                    dvdForEditing.setTitle(newTitle);
                    break;
                case 2:
                    io.print("Old release: " + dvdForEditing.getReleaseDate());
                    String newDate = io.readString("Please enter new release date");
                    dvdForEditing.setReleaseDate(newDate);
                    break;
                case 3:
                    io.print("Old MPAA rating: " + dvdForEditing.getRating());
                    String newRating = io.readString("Please enter new rating");
                    dvdForEditing.setRating(newRating);
                    break;
                case 4:
                    io.print("Old director's name: " + dvdForEditing.getDirectorName());
                    String newDirector = io.readString("Please enter new director name");
                    dvdForEditing.setTitle(newDirector);
                    break;
                case 5:
                    io.print("Old studio: " + dvdForEditing.getStudio());
                    String newStudio = io.readString("Please enter new studio");
                    dvdForEditing.setStudio(newStudio);
                    break;
                case 6:
                    io.print("Old user note: " + dvdForEditing.getUserRating());
                    String newUserRating = io.readString("Please enter new user rating");
                    dvdForEditing.setUserRating(newUserRating);
                    break;
                case 7:
                case 8:
                    keepGoing = false;
                    break;
                default:
                    break;
            }
        }

        return userChoice == 7;     // 7 : Save changes and Exit
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
