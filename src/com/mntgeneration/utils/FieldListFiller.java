package com.mntgeneration.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.DefaultListModel;

/**
 * Class which reads the name of the fields from a text file in order to populate a JList with them.
 * The fields will be inserted in a TreeSet since We want the fields to be sorted by name.
 * @author jose.alvarez.villar
 */
public class FieldListFiller {
    private static final HashMap<String, String> pairFieldOriginFile = new HashMap ();
    
    public static DefaultListModel<String> getFields(String filename) {
        TreeSet<String> fieldsToReturn = new TreeSet<>();

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();

        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            fieldsToReturn = stream
                    .collect(Collectors.toCollection(TreeSet::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        fieldsToReturn.forEach(defaultListModel::addElement);
        for (String field: fieldsToReturn) {
            defaultListModel.addElement(field);
            pairFieldOriginFile.put(field, filename);
        }
        
        return defaultListModel;
    }
    
    public static String getOriginOfField (String field) {
        return pairFieldOriginFile.get(field);
    }
   
}
