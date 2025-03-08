package utils;

import models.TicketStatus;
import models.TicketType;

import java.util.HashMap;
import java.util.Map;

public class FlowStatus {
    private static final Map<TicketType, Map<TicketStatus, TicketStatus>> statusMap = new HashMap<>();

    static {
        statusMap.put(TicketType.STORY, Map.of(
                TicketStatus.OPEN, TicketStatus.IN_PROGRESS,
                TicketStatus.IN_PROGRESS, TicketStatus.TESTING,
                TicketStatus.TESTING, TicketStatus.IN_REVIEW,
                TicketStatus.IN_REVIEW, TicketStatus.DEPLOYED
        ));

        statusMap.put(TicketType.EPIC, Map.of(
                TicketStatus.OPEN, TicketStatus.IN_PROGRESS,
                TicketStatus.IN_PROGRESS, TicketStatus.COMPLETED
        ));

        statusMap.put(TicketType.ON_CALL, Map.of(
                TicketStatus.OPEN, TicketStatus.IN_PROGRESS,
                TicketStatus.IN_PROGRESS, TicketStatus.RESOLVED
        ));
    }

    public static boolean isValidTransition(TicketType type, TicketStatus current, TicketStatus next) {
        return statusMap.containsKey(type) && statusMap.get(type).get(current) == next;
    }
}