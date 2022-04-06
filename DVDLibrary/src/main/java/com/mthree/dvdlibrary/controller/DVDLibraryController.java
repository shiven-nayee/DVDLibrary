/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.controller;

/**
 *
 * @author Jeonghoon
 */
public class DVDLibraryController {

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
        return 10;
    }

    void addDVD() {
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
