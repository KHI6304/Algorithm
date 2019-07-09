package com.ex;

import java.util.Arrays;
import java.util.Scanner;
 
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner("6 11\r\n" + 
                "0 1 3\r\n" + 
                "0 2 5\r\n" + 
                "1 2 2\r\n" + 
                "1 3 6\r\n" + 
                "2 1 1\r\n" + 
                "2 4 6\r\n" + 
                "2 3 4\r\n" + 
                "3 4 2\r\n" + 
                "3 5 3\r\n" + 
                "4 0 3\r\n" + 
                "4 5 6");
        int V = sc.nextInt();
        int E = sc.nextInt();
        int[][] adj = new int[V][V];
        for(int i = 0; i < E; i++) {
            //유향그래프.
            adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }
        //각 정점까지의 최단거리가 저장될 배열
        int[] dist = new int[V];
        //방문체크배열
        boolean[] visited = new boolean[V];
         
         
        //첫번째 노드를 방문하고, 첫번째노드로부터 경로가 있는 간선은 경로비용을 dist에 써주고 없는 곳은 무한대를 적어주자.
        visited[0] = true;
        for(int i = 1; i < V; i++) {
            dist[i] = adj[0][i];
            if(adj[0][i] == 0)
                dist[i] = Integer.MAX_VALUE;
        }
        //출발정점은 최단거리가 0으로 이미 됐으니 하나 빼고 V-1개에 대해서 최단거리를 찾자.
        for(int i = 0; i < V-1; i++) {
            int min = 0;//젤가까운 친구의 정점번호를 저장할 변수
            int minVal = Integer.MAX_VALUE;
            for(int j = 0; j < V; j++) {
                //아직 방문 안했으면서,  dist가 젤 작은 값을 찾자.
                // !visited[j]        minVal > dist[j]
                if( !visited[j] && minVal > dist[j] ) {
                    min = j;
                    minVal = dist[j];
                }
            }
            //dist중에 젤 작았던 min으로부터 출발해서 갈 수 있는 경로비용과 기존에 알고있던 경로비용 중 작은값으로 dist업데이트
            for(int j = 0; j < V; j++) {
                if( adj[min][j] != 0 && dist[j] > dist[min] + adj[min][j] ) {
                    dist[j] = dist[min] + adj[min][j];
                }
            }
            visited[min] = true;
        }
        System.out.println(Arrays.toString(dist));
    }
}