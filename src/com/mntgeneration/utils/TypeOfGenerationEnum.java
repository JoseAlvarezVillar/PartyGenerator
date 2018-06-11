/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mntgeneration.utils;

/**
 *
 * @author jose.alvarez.villar
 */
public enum TypeOfGenerationEnum {
    CUSTOMER (".//src//sources//customer_fields.txt"),
    EMPLOYEE (".//src//sources//employee_fields.txt"),
    CUSTOMER_EMPLOYEE ("");
    
    private final String path;       

    private TypeOfGenerationEnum(String s) {
        path = s;
    }

    public boolean equalsName(String otherPath) {
        return path.equals(otherPath);
    }

    public String toString() {
       return this.path;
    }
    
    public String getPath() {
        return path;
    }
    
    public static TypeOfGenerationEnum getEnumNameByString (String value) {
        for (TypeOfGenerationEnum t : TypeOfGenerationEnum.values()) {
          if (value.equals(t.getPath())) return t;
        }
        return null;
    }    
}
