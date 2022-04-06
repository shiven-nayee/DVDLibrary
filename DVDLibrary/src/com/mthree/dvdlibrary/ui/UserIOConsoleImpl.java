package com.mthree.dvdlibrary.ui;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jeonghoon
 */
public class UserIOConsoleImpl implements UserIO {

    final private Scanner sc;

    public UserIOConsoleImpl() {
        sc = new Scanner(System.in);
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        int userInput;

        while (true) {
            System.out.println(prompt);

            try {
                userInput = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format. Please try again!");
            }
        }
        return userInput;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int userInput;

        while (true) {
            userInput = readInt(prompt);
            if (min <= userInput && userInput <= max) {
                break;
            } else {
                System.out.format("Invalid value: Please enter the value between %d and %d\n", min, max);
            }
        }
        return userInput;
    }

    @Override
    public double readDouble(String prompt) {
        double userInput;

        while (true) {
            System.out.println(prompt);

            try {
                userInput = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format. Please try again!");
            }
        }
        return userInput;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double userInput;

        while (true) {
            userInput = readDouble(prompt);
            if (min <= userInput && userInput <= max) {
                break;
            } else {
                System.out.format("Invalid value: Please enter the value between %f and %f\n", min, max);
            }
        }
        return userInput;
    }

    @Override
    public float readFloat(String prompt) {
        float userInput;

        while (true) {
            System.out.println(prompt);

            try {
                userInput = Float.parseFloat(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format. Please try again!");
            }
        }
        return userInput;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float userInput;

        while (true) {
            userInput = readFloat(prompt);
            if (min <= userInput && userInput <= max) {
                break;
            } else {
                System.out.format("Invalid value: Please enter the value between %f and %f\n", min, max);
            }
        }
        return userInput;
    }

    @Override
    public long readLong(String prompt) {
        long userInput;

        while (true) {
            System.out.println(prompt);

            try {
                userInput = Long.parseLong(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format. Please try again!");
            }
        }
        return userInput;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long userInput;

        while (true) {
            userInput = readLong(prompt);
            if (min <= userInput && userInput <= max) {
                break;
            } else {
                System.out.format("Invalid value: Please enter the value between %d and %d\n", min, max);
            }
        }
        return userInput;
    }
}
