/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.dao.DVDLibraryDaoException;
import com.mthree.dvdlibrary.dto.DVD;
import com.mthree.dvdlibrary.ui.DVDLibraryView;
import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author Jeonghoon
 */
public class DVDLibraryController {

    // for testing
    UserIO io = new UserIOConsoleImpl();
    DVDLibraryView view = new DVDLibraryView();

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
        return view.printMenuAndGetSelection();
    }

    // for exception testing.
    void addDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        view.displayCreateSuccessBanner();
    }

    void removeDVD() {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitle();
//        view.displayRemoveResult(removedDVD);
    }

    void editDVDInformation() {
        view.displayEditDVDBanner();
        String title = view.getDVDTitle();
        view.displayEditDVDMenu();
//        view.displayEditResult(editedDVD);
    }

    void listDVDs() {
        view.displayDisplayAllBanner();
//        List<DVD> dvdList = dao.getAllDVDs();
//        view.displayDVDList(dvdList);
    }

    void displayDVDInformation() {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitle();
    }

    void searchDVDByTitle() {
        view.displaySearchDVDBanner();
        String title = view.getDVDTitle();
    }

    private void unknownCommand() {
        System.out.println("Unknown Command");
    }

    private void exitMessage() {
        System.out.println("Bye!!!");
    }
}
