package com.devhouseagency.toyrobot;

import java.util.ArrayList;
import java.util.List;

public class History {
    private final List<String> moves = List.of(
            "forward",
            "back",
            "left",
            "right",
            "sprint"
    );

    private final List<String> history;

    public History() {
        this.history = new ArrayList<>();
    }

    public void addToHistory(String instruction) {
        history.add(instruction);
    }

    public List<String> getHistory() {
        return history;
    }

    public List<String> getReplayableHistory() {
        return history.stream()
                .filter(command -> moves.contains(command.split(" ")[0]))
                .toList();
    }
}
