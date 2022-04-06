/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.dao.DVDLibraryDao;
import com.mthree.dvdlibrary.dto.DVD;
import com.mthree.dvdlibrary.ui.DVDLibraryView;

/**
 *
 * @author Jeonghoon
 */
public class DVDLibraryController {
    private DVDLibraryView view;
    private DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection;

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
    }


    int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDVD() {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        view.displayCreateSuccessBanner();
    }

    private void removeDVD() {
        view.displayRemoveDVDBanner();
        String title = view.getDVDTitle();
//        view.displayRemoveResult(removedDVD);
    }

    private void editDVDInformation() {
        view.displayEditDVDBanner();
        String title = view.getDVDTitle();
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
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
