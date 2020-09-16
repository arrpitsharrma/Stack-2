class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack();
        int prev = 0; int curr = 0;
        int[] res = new int[n];
        for(String log : logs){
            String[] info = log.split(":");
            if(info[1].equals("start")){
                curr = Integer.parseInt(info[2]);
                if(!st.isEmpty())
                    res[st.peek()] += curr - prev;
                st.push(Integer.parseInt(info[0]));
                prev = curr;
            }
            else{
                curr = Integer.parseInt(info[2]);
                if(!st.isEmpty())
                    res[st.pop()] += curr - prev + 1;
                prev = curr+1;
            }
        }
        return res;
    }
}
