import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Hospital {

    private String HospitalLocation;
    private List<Visitor> visitorList;


    public Hospital(String HospitalLocation) {
        this.HospitalLocation = HospitalLocation;
        visitorList = new ArrayList<>();
    }

    //Add Visitor
    public void addVisitors(Visitor visitor) {
        visitorList.add(visitor);
    }

    public String getHospitalLocation() {
        return HospitalLocation;
    }

    public List<Visitor> getVisitorList() {
        return visitorList;
    }

    public long getCountofAllVisitor(LocalDate startDate, LocalDate endDate) {
        return this.getVisitorList().stream().filter(visitor -> visitor.isVisitInRange(startDate, endDate)).count();
    }

    public long getCountofLocalVisitor(LocalDate startDate, LocalDate endDate) {
        return this.getVisitorList().stream().filter(visitor -> visitor.getVisitorLocation().equalsIgnoreCase(HospitalLocation)
                && visitor.isVisitInRange(startDate, endDate)).count();
    }

    public long getCountofOutsideVisitor(LocalDate startDate, LocalDate endDate) {
        return this.getVisitorList().stream().filter(visitor -> !visitor.getVisitorLocation().equalsIgnoreCase(HospitalLocation)
                && visitor.isVisitInRange(startDate, endDate)).count();
    }

    public double getlocalVisitorPercent(LocalDate startDate, LocalDate endDate) {
        double localVistorPercent = ((getCountofLocalVisitor(startDate, endDate)) * 100) / getCountofAllVisitor(startDate, endDate);
        return localVistorPercent;
    }

    public double getOutsideVisitorPercent(LocalDate startDate, LocalDate endDate) {
        double outsideVisitorPercent = ((getCountofOutsideVisitor(startDate, endDate)) * 100) / getCountofAllVisitor(startDate, endDate);
        return outsideVisitorPercent;
    }
}
