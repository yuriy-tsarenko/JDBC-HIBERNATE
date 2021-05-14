package com.cbs.jdbc_hibernate.exapmles.web_services.lesson1.xml.JAXB.toJAVA;

import com.cbs.jdbc_hibernate.exapmles.web_services.lesson1.xml.JAXB.toXML.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ConvertFromXml {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\IT\\IdeaProjects\\java_professional\\src\\main\\"
                    + "java\\com\\java_professional\\tsarenko\\classwork\\lesson8\\xml\\JAXB\\employee.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Employee e = (Employee) jaxbUnmarshaller.unmarshal(file);
            System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
