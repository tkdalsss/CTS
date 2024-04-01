public class Clothes {
  public static int solution(String[][] clothes) {
    int answer = 1;

    // 의상 종류별로 해시맵 저장
    HashMap<String, Integer> map = new HashMap<>();
    for (String[] cloth : clothes) {
      map.put(cloth[1], map.getorDefault(cloth[1], 0) + 1);
    }

    // 종류별로 조합 맞추기
    Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Integer> entry = iter.next();
      answer *= entry.getValue() + 1;
    }

    return answer - 1;
  }

  public static void main(String[] args) {
    String[][] clothes = {
        // [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban",
        // "headgear"]]
        { "yellow_hat", "headgear" },
        { "blue_sunglasses", "eyewear" },
        { "green_turban", "headgear" }
    };
    System.out.println(solution(clothes));
  }
}
