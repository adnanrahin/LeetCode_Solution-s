package my_calender_I;

import java.util.ArrayList;
import java.util.List;

public class Main {
}


class MyCalendar {

    List<Interval> timeInterval;

    public MyCalendar() {
        timeInterval = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        if (timeInterval.size() == 0) {
            timeInterval.add(new Interval(start, end));
            return true;
        } else {
            if (timeInterval.get(timeInterval.size() - 1).end > end) return false;
            else timeInterval.add(new Interval(start, end));
        }
        return true;
    }

    public class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
