package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Masha", now, now, 150);
        Employee worker3 = new Employee("Nina", now, now, 90);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        Report hr = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(hr.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportAccounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 75000);
        store.add(worker);
        Report accounting = new ReportAccounting(store);
        double salaryUSD = worker.getSalary() / ReportAccounting.RATE;
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(salaryUSD).append(";")
                .append(System.lineSeparator());
        assertThat(accounting.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportHTML() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 75000);
        store.add(worker);
        Report engine = new ReportHTML(store);
        StringBuilder expect = new StringBuilder()
                .append("""
                        <html>
                        <head>
                        <title>Name; Hired; Fired; Salary;</title>
                        </head>
                        <body>
                        """)
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("""
                        </body>
                        </html>
                        """);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 75000);
        store.add(worker);
        Report personJson = new ReportJson(store);
        final String expect =
                "["
                        + "{\"name\":\""
                        + worker.getName()
                        + "\",\"hired\":"
                        + "{\"year\":"
                        + now.get(Calendar.YEAR)
                        + ",\"month\":"
                        + now.get(Calendar.MONTH)
                        + ",\"dayOfMonth\":"
                        + now.get(Calendar.DAY_OF_MONTH)
                        + ",\"hourOfDay\":"
                        + now.get(Calendar.HOUR_OF_DAY)
                        + ",\"minute\":"
                        + now.get(Calendar.MINUTE)
                        + ",\"second\":"
                        + now.get(Calendar.SECOND)
                        + "},\"fired\":"
                        + "{\"year\":"
                        + now.get(Calendar.YEAR)
                        + ",\"month\":"
                        + now.get(Calendar.MONTH)
                        + ",\"dayOfMonth\":"
                        + now.get(Calendar.DAY_OF_MONTH)
                        + ",\"hourOfDay\":"
                        + now.get(Calendar.HOUR_OF_DAY)
                        + ",\"minute\":"
                        + now.get(Calendar.MINUTE)
                        + ",\"second\":"
                        + now.get(Calendar.SECOND)
                        + "},"
                        + "\"salary\":"
                        + worker.getSalary()
                        + "}"
                        + "]";
        assertThat(personJson.generate(em -> true), is(expect));
    }

    @Test
    public void whenReportXml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Employee worker = new Employee("Ivan", now, now, 75000);
        store.add(worker);
        Report personXml = new ReportXml(store);
        String expect =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                        + "\n<employees>\n"
                        + "    <employee>\n"
                        + "        <name>" + worker.getName() + "</name>\n"
                        + "        <hired>" + dateFormat.format(now.getTime()) + "</hired>\n"
                        + "        <fired>" + dateFormat.format(now.getTime()) + "</fired>\n"
                        + "        <salary>" + worker.getSalary() + "</salary>\n"
                        + "    </employee>\n"
                        + "</employees>\n";
        assertThat(personXml.generate(em -> true), is(expect));
    }
}