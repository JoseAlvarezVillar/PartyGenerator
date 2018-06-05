package com.mntgeneration.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.DefaultListModel;

public class FieldListFiller {

    public static DefaultListModel<String> getFields() {
        String filename = ".//src//sources//fields.txt";
        TreeSet<String> fieldsToReturn = new TreeSet<>();

        DefaultListModel<String> test = new DefaultListModel<>();

        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            fieldsToReturn = stream.
                    collect(Collectors.toCollection(TreeSet::new));
        } catch (IOException e) {
            e.printStackTrace();
        }

        fieldsToReturn.forEach(test::addElement);
        return test;
    }

}
