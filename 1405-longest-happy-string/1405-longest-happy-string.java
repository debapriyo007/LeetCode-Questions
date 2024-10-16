class Pair implements Comparable<Pair>{
    int occ;
    char ch;
    
    Pair(int occ, char ch){
        this.occ = occ;
        this.ch = ch;
    }
    @Override
    public int compareTo(Pair p2){
        return p2.occ - this.occ; //decending order.
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        if (a > 0) pq.add(new Pair(a, 'a'));
        if (b > 0) pq.add(new Pair(b, 'b'));
        if (c > 0) pq.add(new Pair(c, 'c'));
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int FistOcc = p.occ;
            char firstCh = p.ch;
            
            int n = sb.length();
            if(n >= 2 && sb.charAt(n-1) == firstCh && sb.charAt(n-2) == firstCh){
                //we are getting 3 cons elem.
                //now check for snd highest.
                if(pq.isEmpty())break; //if not there break.
                Pair p2 = pq.poll();
                sb.append(p2.ch);
                p2.occ --;
                if(p2.occ > 0){
                    pq.offer(new Pair(p2.occ, p2.ch));
                }
            }else{
                sb.append(firstCh);
                FistOcc--;
            }
            if(FistOcc > 0){
               pq.offer(new Pair(FistOcc, firstCh)); 
            }
        }
        return sb.toString();
    }
}