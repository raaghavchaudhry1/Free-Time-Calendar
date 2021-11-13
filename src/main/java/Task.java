import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements Serializable {
    private String title;
    private String description;
    private LocalDateTime startDT;
    private LocalDateTime endDT;
    private boolean finished;
    private final int id;

    public Task(int id, String title, String description) {
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

}
