public class DateTime extends Date {
    static int day;
    static int month;
    static int year;
    static int minutes;
    static int hours;

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

    @Override
    public String toString() {
        String hoursString = String.format("%02d", hours);
        String minutesString = String.format("%02d", minutes);
        return super.toString() + " " + hoursString + ":" + minutesString;
    }

    @Override
    public int hashCode() {
        return (new Date(day, month, year).hashCode()) * 1440 + 60 * hours + minutes;
    }

    @Override
    public boolean equals(Object otherDateTime) {
        if (otherDateTime != null) {
            return this.toString().equals(otherDateTime.toString());
        }
        return false;
    }

    public void setHour(int hours) {
        if (hours < 0 || hours > 23) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
    }

    public void setMinute(int minutes) {
        if (minutes < 0 || minutes > 59) {
            this.minutes = 0;
        } else {
            this.minutes = minutes;
        }
    }
}
