package com.cbs.jdbc_hibernate.exapmles.web_services.lesson1.xml.XMLParser;

import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Считываем файл.xml
        XmlParser xml = new XmlParser("D:\\IT\\IdeaProjects\\java_professional\\src\\main\\java\\com\\"
                + "java_professional\\tsarenko\\classwork\\lesson8\\xml\\XMLParser\\2.xml");

        // Указываем путь, что будем считывать с файла xml
        String value = xml.get("catalog/book/author");
        System.out.println(value);
    }
}
