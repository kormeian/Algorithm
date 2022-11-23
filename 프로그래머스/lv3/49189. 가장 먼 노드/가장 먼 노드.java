import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<edge.length;i++){
            list.add(new ArrayList<Integer>());
        }
        int a, b;
        
        for(int[] node : edge){
            a=node[0];
            b=node[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int[] count=new int[n+1];
        boolean[] visited=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[0]=visited[1]=true;
        int now;
        while(!q.isEmpty()){
            now=q.poll();
            for(int v:list.get(now)){
                if(!visited[v]){
                    count[v]=count[now]+1;
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
        int max=0;
        for(int cnt:count){
            if(max<cnt){
                max=cnt;
                answer=1;
            }
            else if(max==cnt) answer++;
        }
        return answer;
    }
}