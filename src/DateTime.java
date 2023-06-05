/**
 * a son class of Date. in additional of day, month and year it has also minutes and hours
 */
public class DateTime extends Date {
    static int day;
    static int month;
    static int year;
    static int minutes;
    static int hours;

    /**
     * Constructs with the year, month, day, minutes, and hours.
     * @param year    the year value
     * @param month   the month value
     * @param day     the day value
     * @param minutes the minutes value
     * @param hours   the hours value
     */
    public DateTime(int year, int month, int day, int minutes, int hours) {
        super(year, month, day);
        if (minutes < 0 || minutes > 59) {
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }
        if (hours < 0 || hours > 23) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
    }

    /**
     * convert the date abject into string
     * @return string in format DD/MM/YYYY hh:mm
     */
    @Override
    public String toString() {
        String hoursString = String.format("%02d", hours);
        String minutesString = String.format("%02d", minutes);
        return super.toString() + " " + hoursString + ":" + minutesString;
    }

    /**
     * converts the date into minutes only
     * @return the number of overall minutes
     */
    @Override
    public int hashCode() {
        return (new Date(day, month, year).hashCode()) * 1440 + 60 * hours + minutes;
    }

    /**
     * checks if to dateTimes are same by checking their strings.
     * @param otherDateTime the other datetime object
     * @return true if both datetimes are equals, else otherwise
     */
    @Override
    public boolean equals(Object otherDateTime) {
        if (otherDateTime != null) {
            return this.toString().equals(otherDateTime.toString());
        }
        return false;
    }

    /**
     * sets the hour of the DateTime object.
     * @param hours the new hour value
     */
    public void setHour(int hours) {
        if (hours < 0 || hours > 23) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
    }

    /**
     * sets the minute of the DateTime object.
     * @param minutes the new minute value
     */
    public void setMinute(int minutes) {
        if (minutes < 0 || minutes > 59) {
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }
    }
}
