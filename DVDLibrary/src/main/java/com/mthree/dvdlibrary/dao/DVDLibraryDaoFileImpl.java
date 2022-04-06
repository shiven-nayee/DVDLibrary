/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
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

    public static final String DVD_FILE = "DVDs.txt";
    public static final String DELIMITER = "::";

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

        // deserialize a String to DVD object
    private DVD unmarshallDVD(String dvdAsText) {
        // dvdAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // Star Wars::1977-05-25::PG-13::George Lucas::Lucasfilm Ltd.::Very good
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in dvdTokens.
        // Which should look like this:
        // __________________________________________________________________
        // |         |          |     |            |              |         |
        // |Star Wars|1977-05-25|PG-13|George Lucas|Lucasfilm Ltd.|Very good|
        // |         |          |     |            |              |         |
        // ------------------------------------------------------------------
        //     [0]       [1]      [2]       [3]         [4]           [5]
        final int TITLE = 0;
        final int RELEASE_DATE = 1;
        final int MPAA_RATING = 2;
        final int DIRECTOR = 3;
        final int STUDIO = 4;
        final int USER_RATING = 5;

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        String dvdTitle = dvdTokens[TITLE];

        // Which we can then use to create a new DVD object to satisfy
        // the requirements of the DVD constructor.
        DVD dvd = new DVD(dvdTitle);

        // set other data from file
        dvd.setReleaseDate(dvdTokens[RELEASE_DATE]);
        dvd.setRating(dvdTokens[MPAA_RATING]);
        dvd.setDirectorName(dvdTokens[DIRECTOR]);
        dvd.setStudio(dvdTokens[STUDIO]);
        dvd.setUserRating(dvdTokens[USER_RATING]);

        // We have now created a student! Return it!
        return dvd;
    }

    // serialize a DVD object to String
    private String marshallDvd(DVD dvd) {
        // We need to turn a DVD object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // Star Wars::1977-05-25::PG-13::George Lucas::Lucasfilm Ltd.::Very good

        // Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer.
        // You should follow the order
        // TITLE::RELEASE_DATE::MPAA_RATING::DIRECTOR::STUDIO::USER_RATING
        String dvdAsText = dvd.getTitle() + DELIMITER;

        dvdAsText += dvd.getReleaseDate() + DELIMITER;
        dvdAsText += dvd.getRating() + DELIMITER;
        dvdAsText += dvd.getDirectorName() + DELIMITER;
        dvdAsText += dvd.getStudio() + DELIMITER;
        dvdAsText += dvd.getUserRating();

        // We have now turned a DVD object to text! Return it!
        return dvdAsText;
    }

    /**
     * Load all students from a DVD_FILE.
     *
     * @throws DVDLibraryDaoException if an error occurs loading from the file
     */
    private void loadDVD() throws DVDLibraryDaoException {
        try ( Scanner scanner = new Scanner(
                new BufferedReader(new FileReader(DVD_FILE)))) {

            String currentLine; // holding current line from the file

            DVD dvdFromFile;
            while (scanner.hasNextLine()) {
                // get the next line in the file
                currentLine = scanner.nextLine();
                // unmarshall the line into a DVD
                dvdFromFile = unmarshallDVD(currentLine);

                // Put dvd into the map using DVD title as the key
//                dvds.put(dvdFromFile.getTitle(), dvdFromFile);
            }
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load dvd data into memory.", e);
        }
    }

    /**
     * Writes all DVDs out to a DVD_FILE. See unmarshallDVD for file format.
     *
     * @throws ClassRosterDaoException if an error occurs writing to the file
     */
    private void writeDVDs() throws DVDLibraryDaoException {
        try ( PrintWriter out = new PrintWriter(new FileWriter(DVD_FILE))) {
            // Write out the dvd objects to the dvd file.
            String dvdAsText;
//            List<DVD> dvdList = this.getAllDVDs();
            // for testing
            // SHOULD REMOVE ....
            List<DVD> dvdList = new ArrayList<>();

            for (DVD aDVD : dvdList) {
                // turn a Student into a String
                dvdAsText = marshallDvd(aDVD);
                // write the Student object to the file
                out.println(dvdAsText);
                // force PrintWriter to write line to the file
//                 out.flush();
            }
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }
    }
}
