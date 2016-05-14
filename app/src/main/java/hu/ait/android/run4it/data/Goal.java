package hu.ait.android.run4it.data;

import com.orm.SugarRecord;

public class Goal extends SugarRecord {

    WorkoutMeasure m;
    TimePeriod tp;
    int number;
    int timeNumber;
    boolean completed;

    public Goal(){}

    public Goal(WorkoutMeasure measure, TimePeriod time, int n, int tn) {
        this.m = measure;
        this.tp = time;
        this.number = n;
        this.timeNumber = tn;
        this.completed = false;
    }

    public WorkoutMeasure getM() {
        return m;
    }

    public void setM(WorkoutMeasure m) {
        this.m = m;
    }

    public TimePeriod getTp() {
        return tp;
    }

    public void setTp(TimePeriod tp) {
        this.tp = tp;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTimeNumber() {
        return timeNumber;
    }

    public void setTimeNumber(int timeNumber) {
        this.timeNumber = timeNumber;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
