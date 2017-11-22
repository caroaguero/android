package gmalv.cr.fi.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Administrador on 9/11/2015.
 */
public class GeneralFunctions
{
    private double kelvinDegree = 273.15;
    private NumberFormat formatter = new DecimalFormat("#0");

    public String ConvertUnixTimeToDate(Long unixDate)
    {
        Date date = new Date(unixDate * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-6"));
        return sdf.format(date);
    }

    public long ConvertDateToUnixTime(Date date)
    {
        long unixDate;
        unixDate = date.getTime() / 1000;
        return unixDate;
    }

    public String ConvertToCelsiusDegrees(double value)
    {
        String result;
        result = String.valueOf(Double.parseDouble(formatter.format(value - kelvinDegree))) + " °C" ;
        return result;
    }

    public String ConvertToSpeed(double value)
    {
        String result;
        result = String.valueOf( Double.parseDouble(formatter.format( value * 10 )) ) + " Km/h" ;
        return result;
    }

    public String ConvertToPercentage(double value)
    {
        String result;
        result = String.valueOf( Double.parseDouble(formatter.format( value )) ) + " %" ;
        return result;
    }


}
