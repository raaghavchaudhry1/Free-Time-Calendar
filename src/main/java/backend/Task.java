package backend;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements Serializable {
    private String title;
    private String description;
    private LocalDateTime startDT;
    private LocalDateTime endDT;
    private boolean finished;

    @JsonCreator
    public Task(@JsonProperty("title") String title, @JsonProperty("description") String description) {
        this.title = title;
        this.description = description;
        this.startDT = LocalDateTime.now();
        this.endDT = null;
        this.finished = false;
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

    public boolean isClosed() {
        return this.finished;
    }

}
