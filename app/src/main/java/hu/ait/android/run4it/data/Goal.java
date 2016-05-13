package hu.ait.android.run4it.data;

public class Goal {

    String goal;
    boolean completed;

    public Goal(){}

    public Goal(String g) {
        this.goal = g;
        this.completed = false;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
