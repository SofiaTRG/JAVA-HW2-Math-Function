public class Date {
    static int day;
    static int month;
    static int year;

    public Date(int day, int month, int year) {
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
        return day + "/" + month + "/" + year;
    }

    @Override
    public int hashCode() {

        return day + 12*month + 365*year;
    }

    @Override
    public boolean equals(Object otherDate) {
        return this.toString() == otherDate.toString();
    }
}
