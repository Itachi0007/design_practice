public class Ticket {
    private Boolean status;
    private Integer priority;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Ticket(Boolean status, Integer priority) {
        this.status = status;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "status=" + status +
                ", priority=" + priority +
                '}';
    }
}
