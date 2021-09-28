import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Hospital hospitalChinmaya = new Hospital("Bangalore");
        Visitor v1 = new Visitor("Visit01", "Veena", "Bangalore");
        v1.addDateOfVisitor(new Visit("2021-05-22"));
        hospitalChinmaya.addVisitors(v1);

        Visitor v2 = new Visitor("Visit02", "Varun", "Mysore");
        v2.addDateOfVisitor(new Visit("2021-09-24"));
        hospitalChinmaya.addVisitors(v2);

        Visitor v3 = new Visitor("Visit03", "Rohit", "Bangalore");
        v3.addDateOfVisitor(new Visit("2021-06-27"));
        v3.addDateOfVisitor(new Visit("2021-06-29"));
        hospitalChinmaya.addVisitors(v3);

        Visitor v4 = new Visitor("Visit04", "Huma", "Pondicherry");
        v4.addDateOfVisitor(new Visit("2021-08-28"));
        hospitalChinmaya.addVisitors(v4);

        Visitor v5 = new Visitor("Visit05", "Suraj", "Bangalore");
        v1.addDateOfVisitor(new Visit("2021-09-24"));
        hospitalChinmaya.addVisitors(v5);


        System.out.println(("In last one Month " + hospitalChinmaya
                .getCountofAllVisitor(LocalDate.parse("2021-09-01"), LocalDate.parse("2021-09-30"))
                + " Visitors registration are" + hospitalChinmaya
                .getlocalVisitorPercent(LocalDate.parse("2021-09-01"), LocalDate.parse("2021-09-30")) + "% from Bangalore and "
                + hospitalChinmaya.getOutsideVisitorPercent(LocalDate.parse("2021-09-01"), LocalDate.parse("2021-09-30"))
                + "% are outsiders"));

    }
}
