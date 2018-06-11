/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mntgeneration.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 * Class which generates the final MNT file by loading the 
 * @author jose.alvarez.villar
 */
public class EmployeeTemplateFiller {

    public static Boolean generateFile(Map<String, Object> map) {
        Configuration cfg = new Configuration();
        try {
            Template template = cfg.getTemplate("src/sources/employee.flt");
            Writer out = new OutputStreamWriter(System.out);
            StringBuilder fileName = getFileName(map);
            Writer fileOut = new FileWriter(new File(fileName.toString()));
            template.process(map, fileOut);
            out.flush();
        } catch (IOException | TemplateException ex) {
            return false;
        }
        return true;
    }

    private static StringBuilder getFileName(Map<String, Object> map) {
        StringBuilder fileName = new StringBuilder(PREFIX_FILE_NAME);
        fileName.append(map.get(FILE_NAME));
        fileName.append(EXTENSION_FILE_NAME);
        return fileName;
    }
    
    private static final String PREFIX_FILE_NAME = "EM";
    private static final String FILE_NAME = "party_idTextField";
    private static final String EXTENSION_FILE_NAME = ".MNT";

}
