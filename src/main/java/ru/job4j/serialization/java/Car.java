package ru.job4j.serialization.java;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    int age;
    boolean automaticTransmission;
    private Documents documents;

    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private  String[] description;

    public Car() {
    }

    public Car(int age, boolean automaticTransmission, Documents documents, String... description) {
        this.age = age;
        this.automaticTransmission = automaticTransmission;
        this.documents = documents;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{"
                + "age=" + age
                + ", automaticTransmission=" + automaticTransmission
                + ", documents=" + documents
                + ", description=" + Arrays.toString(description)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car(2, true, new Documents("11-111", "WYGD14YTK0085"), "Ford Focus", "red");
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(Car.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(car, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
           Car result = (Car) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
