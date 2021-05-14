package com.cbs.jdbc_hibernate.exapmles.web_services.lesson1.xml.XMLParser;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

public class XmlParser {
    private String xml;

    public XmlParser(String path) {
        byte[] buf = null;
        RandomAccessFile file =  null;
        try {
            // RandomAccessFile, конструктор принимает 2 параметра, путь и имя файлового потока
            file = new RandomAccessFile(path, "r");
            buf = new byte[(int) file.length()];
            file.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            xml = new String(buf, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


    // Метод определения "catalog/book/author"
    public String get(String path) {
        // Разбиваем /
        String[] parts = path.split("/");
        String newXml = xml;

        for (String s : parts) {
            String toFind = "<" + s + ">";
            // start начинается с 1 символа найденного тега
            int start = newXml.indexOf(toFind);
            if (start < 0) {
                return null;
            } else {
                start += toFind.length();
            }

            // Находим закрывающийся тег
            int end = newXml.lastIndexOf("</" + s + ">");
            if (end < 0) {
                return null;
            }
            // Вырезаем найденную строку
            newXml = newXml.substring(start, end);
        }

        return newXml;
    }
}
