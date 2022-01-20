/*

Time complexity: O(n) -> n is the length of the string s
Space complexity: O(m) -> m is the length of the longest substring without repeating characters

*/

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int headPointer = 0;
        int tailPointer = 0;
        int maxLength = 0;
        
        Map<Character, Integer> chars = new HashMap<>();
        
        while(tailPointer < s.length()){
            char tailChar = s.charAt(tailPointer);
            if(!chars.containsKey(tailChar)){
                maxLength = Math.max(maxLength, tailPointer - headPointer + 1);
                chars.put(tailChar, tailPointer);
                tailPointer++;
            }
            else{
                int headUpperLimit = chars.get(tailChar) + 1;
                while(headPointer < headUpperLimit){
                    chars.remove(s.charAt(headPointer));
                    headPointer++;
                }
                chars.put(tailChar, tailPointer);
                tailPointer++;
            }
        }
        
        return maxLength;
    }
}
