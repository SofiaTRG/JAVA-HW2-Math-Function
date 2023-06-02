public class DateTime extends Date {
    static int day;
    static int month;
    static int year;
    static int minutes;
    static int hours;

    public DateTime(int day, int month, int year, int minutes, int hours) {
        super(day, month, year);
        if (minutes < 0 || minutes > 59) {
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        } if (hours < 0 || hours > 23) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
    }

    @Override
    public String toString() {
        String hoursString = "";
        String minutesString = "";
        if (hours < 10) {
            hoursString = "0" + hours;
        } else {
            hoursString = String.valueOf(hours);
        } if (minutes < 10) {
            minutesString = "0" + minutes;
        } else {
            minutesString = String.valueOf(minutes);
        }
        return super.toString() + " " + hoursString + ":" + minutesString;
    }

    @Override
    public int hashCode() {
        return (new Date(day, month, year).hashCode())*1440 + 60*hours + minutes;
    }

    @Override
    public boolean equals(Object otherDateTime) {
        return this.toString().equals(otherDateTime.toString());
    }

    public static void setHour(int hours) {
        DateTime.hours = hours;
    }

    public static void setMinute(int minutes) {
        DateTime.minutes = minutes;
    }

    public static void setMonth(int month) {
        DateTime.month = month;
    }
}
