package models;

import models.TicketInstances.StoryTicket;

import java.util.ArrayList;
import java.util.List;


public class Sprint {
    private List<StoryTicket> stories;

    public Sprint() {
        this.stories = new ArrayList<>();
    }

    public void addStory(StoryTicket story) {
        stories.add(story);
    }

    public void removeStory(int storyId) {
        stories.removeIf(story -> story.getId() == storyId);
    }

    public List<StoryTicket> getStories() {
        return stories;
    }

    @Override
    public String toString() {
        return "models.Sprint{" + "stories=" + stories + '}';
    }
}