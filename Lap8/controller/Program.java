package Lap8.controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Lap8.common.Algorithm;
import Lap8.view.Menu;
public class Program extends Menu<String> {

    Algorithm al = new Algorithm();
    static String[] mc = {"Normalize text", "Exit"};

    public Program() {
        super("Normalize Text Menu", mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> {
                readAndWrite();
            }
            default ->
                System.out.println("Please, enter again");
        }
    }

    public void readAndWrite() {
        try {
            int countLine = al.countLine();
            int count = 1;
            FileReader fr = new FileReader("D:\\LAB211\\Lap8\\data\\input.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("D:\\LAB211\\Lap8\\data\\output.txt");
            String line;
            //write until end file
            while ((line = br.readLine()) != null) {
                //check line empty
                if (al.isLineEmpty(line)) {
                    continue;
                }
                line = al.formatOneSpace(line);
                line = al.formatSpecialCharacters(line);
                line = al.afterDotUpperCase(line);
                line = al.noSpaceQuotes(line);
                line = al.firstUpercase(line);
                line = al.lastAddDot(line);
                fw.write(line);
                if (count < countLine) {
                    fw.write(System.getProperty("line.separator"));
                }
                count++;
            }
            fr.close();
            fw.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
