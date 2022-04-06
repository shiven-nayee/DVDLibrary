/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mthree.dvdlibrary;

import com.mthree.dvdlibrary.controller.DVDLibraryController;
import com.mthree.dvdlibrary.dao.DVDLibraryDao;
import com.mthree.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.mthree.dvdlibrary.ui.DVDLibraryView;
import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author Jeonghoon
 */
public class DVDLibrary {

    public static void main(String[] args) {
        UserIO consoleIo = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(consoleIo);
        DVDLibraryDao dao = new DVDLibraryDaoFileImpl();

        DVDLibraryController controller = new DVDLibraryController(dao, view);

        controller.run();
    }
}
