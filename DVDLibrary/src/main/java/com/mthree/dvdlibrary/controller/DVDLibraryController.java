/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.dao.DVDLibraryDao;
import com.mthree.dvdlibrary.dao.DVDLibraryDaoException;
import com.mthree.dvdlibrary.dto.DVD;
import com.mthree.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

/**
 *
 * @author Jeonghoon
 */
public class DVDLibraryController {

    DVDLibraryDao dao;
    DVDLibraryView view;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

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
        dao.addDVD(newDVD);
        view.displayCreateSuccessBanner();
    }

    void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitle();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
    }

    void editDVDInformation() throws DVDLibraryDaoException {
        view.displayEditDVDBanner();
        String title = view.getDVDTitle();
        DVD dvdForEditing = dao.getDVD(title);

        view.displayDVD(dvdForEditing);
        boolean isUpdated = view.displayEditDVDMenu(dvdForEditing);

        if (isUpdated) {
            dao.removeDVD(title);
            dao.addDVD(dvdForEditing);
            view.displayEditResult(dvdForEditing);
        } else {
            view.displayEditDVDMenu(null);
        }
    }

    void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.listDVDs();
        view.displayDVDList(dvdList);
    }

    void displayDVDInformation() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getDVDTitle();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    void searchDVDByTitle() throws DVDLibraryDaoException {
        view.displaySearchDVDBanner();
        String title = view.getDVDTitle();
        DVD dvd = dao.getDVD(title);
        view.displaySearchDVDResult(dvd);
    }

    private void unknownCommand() {
        System.out.println("Unknown Command");
    }

    private void exitMessage() {
        System.out.println("Bye!!!");
    }
}
