public class Date {
    static int day;
    static int month;
    static int year;

    public Date(int year, int month, int day) {
        if (day < 1 || day > 31) { // Ask metargel if magic number
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

    @Override
    public String toString() { // ask for validation
        String dayString = String.format("%02d", day);
        String monthString = String.format("%02d", month);
        String yearString = String.format("%04d", year);
        return dayString + "/" + monthString + "/" + yearString;
    }

    @Override
    public int hashCode() {

        return day + 12*month + 365*year;
    }

    @Override
    public boolean equals(Object otherDate) {
        if (otherDate != null) {
            return this.toString().equals(otherDate.toString());
        }
        return false;
    }
    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            this.month = 1;
        } else {
            this.month = month;
        }
    }
}
