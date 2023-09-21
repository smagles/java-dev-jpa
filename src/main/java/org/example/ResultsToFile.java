package org.example;

import org.example.services.JpaCriteriaService;
import org.example.services.MemberInfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultsToFile {
    public static void writeResultsToFile(List<MemberInfo> results, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (MemberInfo result : results) {
                bufferedWriter.write("ID: " + result.getId());
                bufferedWriter.newLine();
                bufferedWriter.write("Name: " + result.getName());
                bufferedWriter.newLine();
                bufferedWriter.write("Email: " + result.getEmail());
                bufferedWriter.newLine();
                bufferedWriter.write("Address: " + result.getBuildingAddress());
                bufferedWriter.newLine();
                bufferedWriter.write("Flat number: " + result.getFlatNumber());
                bufferedWriter.newLine();
                bufferedWriter.write("Square: " + result.getFlatSquare());
                bufferedWriter.newLine();
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JpaCriteriaService criteriaExample = new JpaCriteriaService();
        List<MemberInfo> results = criteriaExample.findMembersWithoutEntranceRights();

        String fileName = "file.txt";

        writeResultsToFile(results, fileName);
    }
}
