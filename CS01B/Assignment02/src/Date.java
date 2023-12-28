
/**
 * @version 1.0 7-18-2020
 * @author Andrew Li
 * <br>
 * Purpose: Date class contains all of the data in order to make a date object. Using the data given to the constructor, <br>
 * calling the overridden toString() method will format the values into a date. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-18-2020 <br>
 * Programmer: Andrew Li
 */

public class Date implements Comparable<Date>, Cloneable
{
    private int month, day, year;

    // default constructor
    public Date()
    {
        month = 1;
        day = 1;
        year = 1970;
    }

    // non-default constructor
    public Date(int month, int day, int year)
    {
        if (month <= 12 && month >= 1)
        {
            this.month = month;
        } else
        {
            this.month = 1;
        }
        if (day >= 1 && day <= 31)
        {
            this.day = day;
        } else
        {
            this.day = 1;
        }
        if (year >= 1970)
        {
            this.year = year;
        } else
        {
            this.year = 1970;
        }
    }
    
    // copy constructor 
    public Date(Date date)
    {
        month = date.month;
        day = date.day;
        year = date.year; 
    }

    public String toString()
    {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    public boolean equals(Date date)
    {
        return this.month == date.month && this.day == date.day && this.year == date.year;
    }
    
    public Date clone() throws CloneNotSupportedException 
    {
        return (Date) super.clone(); 
    }

    public int compareTo(Date o)
    {
        if (this.equals(o))
        {
            return 0; 
        }
        if (o.year > this.year)
        {
            return 1;
        }
        if (o.year < this.year)
        {
            return -1; 
        }
        if (o.year == this.year)
        {
            if (o.month > this.month)
            {
                return 1; 
            }
            if (o.month < this.month)
            {
                return -1; 
            }
            if (o.month == this.month)
            {
                if (o.day > this.day)
                {
                    return 1; 
                } else
                {
                    return -1; 
                }
            }
        }
        return 0; 
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    public int getYear()
    {
        return year; 
    }
    
    public void monthTo(int mon)
    {
        month = mon; 
    }
    
    public void dayTo(int day)
    {
        this.day = day; 
    }
    
    public void yearTo(int yr)
    {
        year = yr; 
    }
}
