package enggaarden.app.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Subscription {

    /*
    Fields
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payDay;

    /*
    Constructors
     */
    public Subscription()
    {
    }
    public Subscription(Date payDay)
    {
        this.payDay = payDay;
    }


    /*
    Getters
     */
    public boolean isPaid()
    {
        return(payDay!=null);
    }
    public Date getPayDay()
    {
        return payDay;
    }
    public String getSqlDate()
    {
        DateFormat correctFormat = new SimpleDateFormat("yyyy-MM-dd");
        return correctFormat.format(this.payDay);
    }


    /*
    Setters
     */
    public void setPayDay(Date payDay)
    {
        this.payDay = payDay;
    }
}
