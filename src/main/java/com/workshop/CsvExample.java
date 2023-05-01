package com.workshop;

import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvExample {

    //CSV stands for "Comma Separated Values," which is a common file format used for storing and exchanging data in a tabular form.
    //CSV files are essentially plain text files that contain rows of data, with each row representing a record and each field separated by comma.

    public static void addDataToCSV(List<Student> listData) throws IOException {
        CSVWriter write = new CSVWriter(new FileWriter("/home/akhil/IdeaProjects/Workshop5/CSVFile/csvfile.csv"));
        ArrayList<String[]> csvData = new ArrayList<String[]>();
        csvData.add(new String[] { "StudentId", "StudentName", "StudentScore"});
        for (Student contact : listData) {
            csvData.add(new String[] {contact.getStudentId(), contact.getStudentName(), contact.getStudentScore()});
        }
        write.writeAll(csvData);
        write.flush(); //Flushes the buffer and writes the data to the file immediately
        write.close();
    }
    public static void readCsvFile() {
        String csvFile = "/home/akhil/IdeaProjects/Workshop5/CSVFile/csvfile.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            String line = br.readLine();
            while (line != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> studentData = new ArrayList<>();
        studentData.add(new Student("1","Akhil","80.34"));
        studentData.add(new Student("2","Pavan","87.76"));
        studentData.add(new Student("3","Arpit","98.78"));
        try{
            addDataToCSV(studentData);
        }catch (IOException e){
            e.printStackTrace();
        }
        readCsvFile();
    }
}
