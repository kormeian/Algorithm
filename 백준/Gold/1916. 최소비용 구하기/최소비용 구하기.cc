#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

#define INF 987654321

using namespace std;

int dist[1001];
vector<pair<int, int>> vec[100001];

void dijkstra(int start) {
	dist[start] = 0; // 처음 위치는 0

	priority_queue<pair<int, int>>pq;
	pq.push({ dist[start] , start });

	while (!pq.empty()) {
		int cur = pq.top().second; // 큐의 가장 맨 앞에 있는 정점의 번호를 담아온다.
		int distance = pq.top().first * -1; 
		pq.pop();

		// 이미 담겨 있는 것보다 distance가 크면 넘어간다.
		if (dist[cur] < distance) continue;

		// 선택한 노드의 모든 인접 노드들을 확인한다.
		for (int i = 0; i < vec[cur].size(); i++) {
			int next = vec[cur][i].first;
			int nextDistance = distance + vec[cur][i].second;

			// 다음 것과 기존의 비용과 비교
			if (nextDistance < dist[next]) {
				dist[next] = nextDistance;
				pq.push({nextDistance * -1 , next});
			}
		}
	}
}

int main() {

	ios::sync_with_stdio(0);
	cin.tie(0);

    int start, end;
	int N, M;
	cin >> N; // 정점 갯수
	cin >> M; // 간선 갯수

	for (int i = 1; i <= N; i++) 
		dist[i] = INF;

	for (int i = 0; i < M; i++) {
		int u, v, w;
		cin >> u >> v >> w;
		vec[u].push_back({ v,w });
	}

	cin >> start; // 시작점
	cin >> end; // 도착점
	
	dijkstra(start);
    
	cout << dist[end];

	return 0;
}