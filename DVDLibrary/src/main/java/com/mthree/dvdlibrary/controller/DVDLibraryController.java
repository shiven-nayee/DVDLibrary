/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.dao.DVDLibraryDaoException;
import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author Jeonghoon
 */
public class DVDLibraryController {

    // for testing
    UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection;

        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVDInformation();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        displayDVDInformation();
                        break;
                    case 6:
                        searchDVDByTitle();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            System.out.println(e.getMessage());
        }
    }

    int getMenuSelection() {
//        return 10;
        // for testing
        return io.readInt("please enter input");
    }

    // for exception testing.
    void addDVD() throws DVDLibraryDaoException {
        System.out.println("ADD DVD");
    }

    void removeDVD() {
        System.out.println("REMOVE DVE");
    }

    void editDVDInformation() {
        System.out.println("EDIT DVD INFO.");
    }

    void listDVDs() {
        System.out.println("LIST DVDs");
    }

    void displayDVDInformation() {
        System.out.println("DISPLAY DVD");
    }

    void searchDVDByTitle() {
        System.out.println("Search DVD");
    }

    private void unknownCommand() {
        System.out.println("Unknown Command");
    }

    private void exitMessage() {
        System.out.println("Bye!!!");
    }
}
