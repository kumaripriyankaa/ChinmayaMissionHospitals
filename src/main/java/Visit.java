import java.time.LocalDate;

public class Visit {

    private LocalDate date;

    public Visit(String dates) {
        this.date = LocalDate.parse(dates);
    }
@Override
public String toString(){
return "main.java.AdmissionDates{"+"date="+date+"}";

    }

    public LocalDate getDate() {
        return date;
    }
}
