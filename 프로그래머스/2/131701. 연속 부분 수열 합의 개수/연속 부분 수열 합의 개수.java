import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int[] numbers = new int[elements.length * 2];
        
        for (int i = 0; i < elements.length; i++) {
            int temp = elements[i];
            numbers[i] = temp;
            numbers[i+elements.length] = temp;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= elements.length; i++) {
            // i -> 갯수 늘리기, j -> 반복수
            for (int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(numbers, j, j+i).sum());
            }
        }
        
        return set.size();
    }
}