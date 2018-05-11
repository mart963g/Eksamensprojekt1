package enggaarden.app.models;

import java.sql.Date;

public class Subscription {
    private Date payDay;

    public Subscription()
    {
    }

    public Subscription(Date payDay)
    {
        this.payDay = payDay;
    }



    //  Getters and setters
    public boolean isPaid()
    {
        return(payDay!=null);
    }
    public Date getPayDay()
    {
        return payDay;
    }
    public void setPayDay(Date payDay)
    {
        this.payDay = payDay;
    }
}
