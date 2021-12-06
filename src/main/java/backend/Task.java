package backend;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.fortuna.ical4j.model.DateTime;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements TaskInterface, Serializable {
    private String title;
    private String description;
    private LocalDateTime startDT;
    private LocalDateTime endDT;
    private boolean finished;
    private final int id;

    @JsonCreator
    public Task(@JsonProperty("id") int id, @JsonProperty("title") String title, @JsonProperty("description") String description) {
        this.title = title;
        this.description = description;
        this.startDT = LocalDateTime.now();
        this.endDT = null;
        this.finished = false;
        this.id = id;
    }

    public String toString() {
        return this.title + ":" + "\n" + this.description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDateTime getStartDT() {
        return this.startDT;
    }

    public LocalDateTime getEndDT() {
        return this.endDT;
    }

    public void editStartDT(LocalDateTime newStartDT) {
       this.startDT = newStartDT;
    }

    public void editEndDT(LocalDateTime newEndDT) {
        this.endDT = newEndDT;
        this.finished = true;
    }

    public void editTitle(String newTitle) {
        this.title = newTitle;
    }

    public void editDescription(String newDesc) {
        this.description = newDesc;
    }

    public int getID() {
        return this.id;
    }

    public boolean isClosed() {
        return this.finished;
    }

    @Override
    public int compareTo(TaskInterface other){
        /* Compares 2 tasks based on their start times
        Returns -1 if current task starts earlier than other task
                1 if current task starts later than other task
                0 if 2 tasks have the same start time */
        if (this.getStartDT().isBefore(other.getStartDT())){
            return -1;
        }
        else if (this.getStartDT().isAfter(other.getStartDT())){
            return 1;
        }
        else{
            return 0;
        }
    }

}
