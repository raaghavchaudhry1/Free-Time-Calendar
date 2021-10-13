public class OneOffEvent extends CalendarEvent {
    private float date;     // month.day

    public OneOffEvent(String name, float start, float end, float date) {
        super(name, start, end);
        this.date = date;
    }

    public float getDate(){
        return this.date;
    }

    public void setDate(float date){
        this.date = date;
    }
}