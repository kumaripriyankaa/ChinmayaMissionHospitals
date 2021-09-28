
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Visitor {
    private String visitorID;
    private String visitorName;
    private String visitorLocation;
    private List<Visit> dateOfVisitList;

    @Override
    public String toString(){
        return "main.java.Visitor{"+"VisitorID =" +visitorID
                + ",VisitorName =" +visitorName+'\''+ ",VisitorLocation =" +visitorLocation+ '\''
                +"Admission Date=" + dateOfVisitList + '}';
    }

    public Visitor(String visitorID, String visitorName,String visitorLocation) {
        this.visitorID=visitorID;
        this.visitorName=visitorName;
        this.visitorLocation=visitorLocation;
        dateOfVisitList=new ArrayList<>();
    }

    public List<Visit> getAllVisits() {
        return dateOfVisitList;
    }
    public String getVisitorLocation(){
        return visitorLocation;
    }
    public List<Visit> addDateOfVisitor(Visit admissionDate){
        dateOfVisitList.add(admissionDate);
        return dateOfVisitList;
    }

    private List<LocalDate>  VisitDate(){
        return getAllVisits().stream().map(Visit::getDate).collect(Collectors.toList());
    }
    public boolean isVisitInRange(LocalDate startDate,LocalDate endDate){
        List<LocalDate>localDate=VisitDate().stream().filter(date->date.isAfter(startDate)&&date.isBefore(endDate)).collect(Collectors.toList());
        return localDate.size()>0;
    }

}
