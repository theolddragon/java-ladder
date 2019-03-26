package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Participants {

  private List<Participant> participants;

  public Participants(List<Participant> participants) {

    if (participants == null || participants.isEmpty() || participants.size() == 1) {
      throw new IllegalArgumentException();
    }
    this.participants = participants;
  }

  public int number() {
    return participants.size();
  }

  public String names() {

    return participants.stream()
        .map(participant -> String.format("%5s", participant))
        .collect(Collectors.joining(" "));
  }

  public int position(Participant participant) {
    return participants.indexOf(participant);
  }

  public Map<Participant, Result> allMove(Results results, Lines lines) {

    Map<Participant, Result> allResults = new HashMap<>();
    participants.forEach(participant -> allResults.put(
        participant,
        results.position(lines.move(participants.indexOf(participant)))
    ));

    return allResults;
  }
}
