package com.devhouseagency.toyrobot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class History {
    private final List<String> moves;
    private static final List<String> history = new ArrayList<>();

    public History() {
        this.moves = List.of(
                "forward",
                "back",
                "left",
                "right",
                "sprint"
        );
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
                .collect(Collectors.toList());
    }
}
