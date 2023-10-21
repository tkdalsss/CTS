package CTS.Java.Programmers;

public class DistanceCheck {
  private static final int dx[] = { 0, -1, 1, 0 };
  private static final int dy[] = { -1, 0, 0, 1 };

  private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
    for (int d = 0; d < 4; d++) {
      if (d == exclude)
        continue;

      int nx = x + dx[d];
      int ny = y + dy[d];

      if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
        continue;
      if (room[ny][nx] == 'P')
        return true;
    }
    return false;
  }

  private boolean isDistanced(char[][] room, int x, int y) {
    for (int d = 0; d < 4; d++) {
      int nx = x + dx[d];
      int ny = y + dy[d];

      // 범위 벗어나는지 체크
      if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length)
        continue;

      // 다음 자리가 P인지 O인지 체크하고
      switch (room[ny][nx]) {
        case 'P': // 바로 옆에 있으면 거리두기가 되지 않았으므로 false
          return false;
        case 'O': // 자리가 있는데 그 옆에 사람이 있으면 거리두지가 되지 않은 것이므로 false
          if (isNextToVolunteer(room, nx, ny, 3 - d))
            return false;
          break;
      }
    }
    return true;
  }

  private boolean isDistanced(char[][] room) {
    // 거리두기가 잘 되었는지 확인
    for (int y = 0; y < room.length; y++) {
      for (int x = 0; x < room[y].length; x++) {
        if (room[y][x] != 'P')
          continue;
        if (!isDistanced(room, x, y))
          return false;
      }
    }
    return true;
  }

  public int[] solution(String[][] places) {
    int[] answer = new int[places.length];
    for (int i = 0; i < answer.length; i++) {
      String[] place = places[i];
      char[][] room = new char[place.length][];
      for (int j = 0; j < room.length; j++) {
        room[j] = place[j].toCharArray();
      }
      if (isDistanced(room)) {
        answer[i] = 1;
      } else {
        answer[i] = 0;
      }
    }
    return answer;
  }

}
