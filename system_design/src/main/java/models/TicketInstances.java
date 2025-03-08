package models;

import managers.SprintManager;

public class TicketInstances {
    public static class StoryTicket extends Ticket {
        SprintManager sprintManager;
        public StoryTicket(String title) {
            super(title, TicketType.STORY);
        }
    }

    public static class EpicTicket extends Ticket {
        public EpicTicket(String title) {
            super(title, TicketType.EPIC);
        }
    }

    public static class OnCallTicket extends Ticket {
        public OnCallTicket(String title) {
            super(title, TicketType.ON_CALL);
        }
    }
}