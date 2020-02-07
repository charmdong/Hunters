/**
 * @author : donggun.chung
 * @date : 2020.02.07
 * @site : BOJ
 * @prob_Info : 2606 바이러스
 * @time : 0ms
 * @memory : 1988KB
 */

#include <iostream>
#include <queue>

using namespace std;

int n, m;
vector<vector<int>> graph;
vector<bool> visited;

int solution(int start = 1);

int main()
{
    int src, des;

    cin >> n;
    cin >> m;

    graph.assign(n + 1, vector<int>());
    visited.assign(n + 1, false);

    for(int index = 0; index < m; index++) {
        cin >> src >> des;

        graph[src].push_back(des);
        graph[des].push_back(src);
    }

    cout << solution() << endl;

    return 0;
}

int solution(int start) {
    int answer = 0;

    queue<int> q;

    visited[start] = true;
    q.push(start);

    while(!q.empty()) {
        int current = q.front();
        q.pop();

        for(int index = 0; index < graph[current].size(); index++) {
            int next = graph[current][index];

            if(!visited[next]) {
                visited[next] = true;
                q.push(next);
                answer++;
            }
        }
    }

    return answer;
}