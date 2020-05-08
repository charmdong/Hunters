#include <iostream>
#include <queue>
#include <vector>
#define MAX 101
using namespace std;

int n, m;
int dy[4] = {-1, 1, 0, 0};
int dx[4] = {0, 0, -1, 1};

bool visited[101][101];
int map[101][101];
int res[101][101];

int solution(int y = 1, int x = 1);
bool isInMap(int y, int x);

int main()
{
    cin >> n >> m;
    for(int i=1; i<=n; i++){
        for(int j=1; j<=m; j++)
            scanf("%1d", &map[i][j]);
    }
    cout << solution() << endl;
    return 0;
}

int solution(int y, int x)
{
    queue<pair<int, int>> q;

    q.push({y, x});
    visited[y][x] = true;
    res[y][x] = 1;

    while (!q.empty())
    {
        pair<int, int> now = q.front();
        q.pop();

        if(now == make_pair(n,m)) {
            return res[n][m];
        }

        for(int i=0; i<4; i++) {
            int ny = now.first + dy[i];
            int nx = now.second + dx[i];

            if(isInMap(ny,nx)){
                if(map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    res[ny][nx] = res[now.first][now.second] + 1;
                    q.push({ny,nx});
                }
            }
        }
    }
}

bool isInMap(int y, int x)
{
    if (y >= 1 && y <= n)
    {
        if (x >= 1 && x <= m)
        {
            return true;
        }
    }

    return false;
}
