/**
 * @author : donggun.chung
 * @date : 2020.02.07
 * @site : BOJ
 * @prob_Info : 1260 DFS와 BFS
 * @time : 12ms
 * @memory : 5948KB
 */

#include <iostream>
#include <vector>
#include <queue>
#define N 1000
#define M 10000
using namespace std;

void dfs(int current);
void bfs(int start);

int n, m;
vector<vector<int>> graph;
vector<bool> visited;

int main()
{
	int start ,src, des;
	cin >> n >> m >> start;

    graph.assign(n + 1 , vector<int>(n + 1, 0));
    visited.assign(n + 1, false);

    for (int index = 0; index < m; index++) {
		cin >> src >> des;

        graph[src][des] = graph[des][src] = 1;
	}

    dfs(start);
    cout << endl;
    bfs(start);
}

void dfs(int current) {
    visited[current] = true;

    cout << current << " ";

    for(int index = 1; index <= n; index++) {
        if(graph[current][index] == 1 && !visited[index]) {
            dfs(index);
        }        
    }
}

void bfs(int start) {
    queue<int> q;

    visited.assign(n + 1, false);
    visited[start] = true;
    q.push(start);

    while(!q.empty()) {
        int current = q.front();
        q.pop();

        cout << current << " ";

        for(int index = 1; index <= n; index++) {
            if(graph[current][index] == 1 && !visited[index]) {
                visited[index] = true;
                q.push(index);
            }
        }
    }

    cout << endl;
}