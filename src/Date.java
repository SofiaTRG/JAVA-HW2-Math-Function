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
        String dayString = "";
        String monthString = "";
        if (day < 10) {
            dayString += "0";
        } if (month < 10) {
            monthString += "0";
        }
        String yearString = addZerosYear(year);
        return dayString + "/" + monthString + "/" + yearString;
    }

    private String addZerosYear(int year) {
        String stringYear = "";
        int WANTED_Length = 4;
        int zeros = WANTED_Length - String.valueOf(year).length();
        for (int i = 0; i < WANTED_Length; i++) {
            stringYear += "0";
        }
        return stringYear + year;
    }

    @Override
    public int hashCode() {

        return day + 12*month + 365*year;
    }

    @Override
    public boolean equals(Object otherDate) {
        return this.toString().equals(otherDate.toString());
    }
}
