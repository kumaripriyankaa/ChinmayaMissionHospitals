import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class ChinmayaTest {
    Hospital hospitalChinmaya;
    Visitor v1, v2, v3, v4, v5;


    @BeforeClass
    public void registerVistors() {
        hospitalChinmaya = new Hospital("Bangalore");

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
    }

    @Test
    public void Testcase1_AllVisitors(){
        List<Visitor>visitorList= hospitalChinmaya.getVisitorList();
        Assert.assertEquals(visitorList.size(),5);
    }
    @Test
    public void Testcase2_LocalVisitors(){
        List<Visitor>visitorList= hospitalChinmaya.getVisitorList();
        long count =visitorList.stream().filter(visitor -> visitor.getVisitorLocation()
                .equalsIgnoreCase(hospitalChinmaya.getHospitalLocation())).count();
        Assert.assertEquals(count,3);

    }
    @Test
    public void Testcase3_OutsideVisitors(){
        List<Visitor>visitorList= hospitalChinmaya.getVisitorList();
        long count =visitorList.stream().filter(visitor -> !visitor.getVisitorLocation()
                .equalsIgnoreCase(hospitalChinmaya.getHospitalLocation())).count();
        Assert.assertEquals(count,2);
    }
   /* @Test
    public void Testcase4_VerifyAnyVisitorLocation(){
        Boolean isLocalVisitor =v4.getVisitorLocation().equalsIgnoreCase("Bangalore");
        Assert.assertEquals(java.util.Optional.of(isLocalVisitor),java.util.Optional.of(false));

    }

    */
   @Test
   public void Testcase4_LocalVisitorsinaMonth(){

       long count =hospitalChinmaya.getCountofLocalVisitor(LocalDate.parse("2021-08-25"),LocalDate.parse("2021-09-25"));
       Assert.assertEquals(count,1);
   }
    @Test
    public void Testcase5_OutsideVisitorsinaMonth(){
        long count =hospitalChinmaya.getCountofOutsideVisitor(LocalDate.parse("2021-08-25"),LocalDate.parse("2021-09-25"));
        Assert.assertEquals(count,2);
    }

    @Test
    public void Testcase6_LocalVisitorPercentinaMonth(){
       Assert.assertEquals(hospitalChinmaya
               .getlocalVisitorPercent(LocalDate.parse("2021-08-25"),LocalDate.parse("2021-09-25")),33);
    }

    @Test
    public void Testcase7_OutsideVisitorPercentinaMonth(){
        Assert.assertEquals(hospitalChinmaya
                .getOutsideVisitorPercent(LocalDate.parse("2021-08-25"),LocalDate.parse("2021-09-25")),66);
    }
}