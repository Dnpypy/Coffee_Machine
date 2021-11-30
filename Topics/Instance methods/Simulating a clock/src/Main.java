
class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (minutes == 59 && hours == 12) {
            hours = 1;
            minutes = 0;
        } else if (minutes == 59) {
            hours += 1;
            minutes = 0;
        } else {
            minutes += 1;
        }
    }
}