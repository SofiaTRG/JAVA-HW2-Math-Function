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
        return super.toString() + " " + hours + ":" + minutes;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object otherDateTime) {
        return this.hashCode() == otherDateTime.hashCode();
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
