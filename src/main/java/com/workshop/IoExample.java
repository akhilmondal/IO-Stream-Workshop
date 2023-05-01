package com.workshop;

import java.io.*;
import java.util.ArrayList;

public class IoExample {
    /*Question: What is file IO ?
    File I/O (Input/Output) in Java refers to the process of reading data from or writing data to a file.

    Common Methods to use
    ---------------------
    1. File: Represents a file or directory in the file system.
    2. FileInputStream: Reads binary data from a file.
    3. FileOutputStream: Writes binary data to a file.
    4. FileReader: Reads character data from a file.
    5. FileWriter: Writes character data to a file.
    6. BufferedReader: Reads character data from a file with buffering for improved performance.
    7. BufferedWriter: Writes character data to a file with buffering for improved performance.
    8. PrintWriter: Prints formatted representations of objects to a text file.
    9. Scanner: Reads formatted input from a text file.
    10. RandomAccessFile: Reads and writes data to a file at a specific location.
     */


    public static void addStudentsToFile(ArrayList<Student> list) throws IOException {  //This method will right the data to a file.
        File filePath = new File("/home/akhil/IdeaProjects/Workshop5/FileIO/Demo.txt");
        FileWriter fileWriter = new FileWriter(filePath);
        for (Student details : list) {
            fileWriter.write(details+"\n");  //This line separator method will separate each entry line by line.
        }
        System.out.println("The data is written to the destination file.");
        fileWriter.close();
    }
    public static void readStudentsFromAFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/akhil/IdeaProjects/Workshop5/FileIO/Demo.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close(); //We close the file after the operation is complete to avoid resource leaks and data corruption.
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
            addStudentsToFile(studentData);
        }catch (IOException e){
            e.printStackTrace();
        }
        readStudentsFromAFile();
    }
}
