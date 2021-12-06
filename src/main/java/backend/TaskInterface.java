package backend;

import java.time.LocalDateTime;

public interface TaskInterface extends Comparable<TaskInterface>{
    public String toString();

    public String getTitle();

    public String getDescription();

    public LocalDateTime getStartDT();

    public LocalDateTime getEndDT();

    public void editStartDT(LocalDateTime newStartDT);

    public void editEndDT(LocalDateTime newEndDT);

    public void editTitle(String newTitle);

    public void editDescription(String newDesc);

    public int getID();

    public boolean isClosed();
}
