package number_of_students_doing_homework_at_a_given_time_1450;

public class Main {

    public static void main(String args[]) {

    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int counter = 0;

        for (int i = 0; i < endTime.length; i++) {

            if (startTime[i] <= queryTime && queryTime <= endTime[i])
                counter++;

        }
        return counter;
    }
}
