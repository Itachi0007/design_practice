import managers.SprintManager;
import managers.TicketManager;
import models.SubTask;
import models.Ticket;
import models.TicketStatus;
import models.TicketType;

public class Driver {
    public static void main(String[] args) {
        TicketManager ticketManager = new TicketManager();

        // Testing story Ticket
        Ticket storyTicket = ticketManager.createTicket("Implement login feature", TicketType.STORY);
        System.out.println(storyTicket);
        // Valid Status Updates
        ticketManager.updateTicketStatus(storyTicket.getId(), TicketStatus.IN_PROGRESS);
        ticketManager.updateTicketStatus(storyTicket.getId(), TicketStatus.TESTING);
        ticketManager.updateTicketStatus(storyTicket.getId(), TicketStatus.IN_REVIEW);
        ticketManager.updateTicketStatus(storyTicket.getId(), TicketStatus.DEPLOYED);
        // Invalid Status Update (Trying to revert status)
        ticketManager.updateTicketStatus(storyTicket.getId(), TicketStatus.TESTING);
        // Story Ticket completed
        System.out.println(storyTicket);


        // Using EPIC ticket to test subtask flow for 2 cases on same parent
        Ticket epicTicket = ticketManager.createTicket("Revamp UI", TicketType.EPIC);
        Ticket onCallTicket = ticketManager.createTicket("Fix production issue", TicketType.ON_CALL);

        SubTask subTaskEpic = new SubTask("Design Login UI", "Create UI for login page", epicTicket);
        SubTask subTaskOnCall = new SubTask("Implement API", "Develop backend API for login", onCallTicket);

        System.out.println("\nInitiating SubTasks:");
        System.out.println(subTaskEpic);
        System.out.println(subTaskOnCall);

        System.out.println("\nUpdating SubTask Status:");
        subTaskEpic.updateStatus(TicketStatus.IN_PROGRESS);
        subTaskOnCall.updateStatus(TicketStatus.IN_PROGRESS);
        // Testing fail case as we cant update EPIC subtask to TESTING
        System.out.println("\nTesting the EPIC subtask as per its flow:");
        subTaskEpic.updateStatus(TicketStatus.RESOLVED);
        subTaskEpic.updateStatus(TicketStatus.TESTING);
        subTaskOnCall.updateStatus(TicketStatus.RESOLVED);
        System.out.println(subTaskEpic);
        System.out.println(subTaskOnCall);

        System.out.println("\nCompleting the EPIC subtask as per its flow:");
        subTaskEpic.updateStatus(TicketStatus.COMPLETED);
        // Subtask testing completed
    }
}