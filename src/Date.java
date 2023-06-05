/**
 * this class represents the date, with day, month and year
 */
public class Date {
    static int day;
    static int month;
    static int year;

     /**
     * Constructs a Date object with the year, month, and day
     * @param year  the year value
     * @param month the month value
     * @param day   the day value
     */
    public Date(int year, int month, int day) {
        /** check if the outputs are correct */
        if (day < 1 || day > 31) {
            this.day = 1;
        } else {
            this.day = day;
        }
        if (month < 1 || month > 12) {
            this.month = 1;
        } else {
            this.month = month;
        }
        if (year < -9999 || year > 9999) {
            this.year = 0;
        } else {
            this.year = year;
        }
    }

    /**
     * convert the date abject into string
     * @return string in format DD/MM/YYYY
     */
    @Override
    public String toString() {
        String dayString = String.format("%02d", day);
        String monthString = String.format("%02d", month);
        String yearString = String.format("%04d", year);
        return dayString + "/" + monthString + "/" + yearString;
    }

    /**
     * converts the date into days only
     * @return the number of overall days
     */
    @Override
    public int hashCode() {
        return day + 12*month + 365*year;
    }

    /**
     * checks if to dates are same by checking their strings.
     * @param otherDate
     * @return
     */
    @Override
    public boolean equals(Object otherDate) {
        /** if object is null */
        if (otherDate != null) {
            return this.toString().equals(otherDate.toString());
        }
        return false;
    }

    /**
     * set for month
     * @param month the new value of month
     */
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            this.month = 1;
        } else {
            this.month = month;
        }
    }
}
