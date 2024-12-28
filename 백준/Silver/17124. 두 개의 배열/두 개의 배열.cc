#define fastio ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
#include <iostream>
#include <algorithm>
#include <cstring>
#include <cmath>
using namespace std;
using ll = long long;
int t, n, m;
ll a[1000002], b[1000002], ans;
void init() {
	memset(a, 0, sizeof(a));
	memset(b, 0, sizeof(b));
	ans = 0;
}

int main() {
	fastio;

	cin >> t;
	while (t--) {
		init();
		cin >> n >> m;
		for (int i = 1; i <= n; i++) cin >> a[i];
		for (int j = 1; j <= m; j++) cin >> b[j];

		sort(b + 1, b + m + 1);

		for (int i = 1; i <= n; i++) {
			ll num = 1000000009;
			ll cur = a[i];
			ll gap = 1000000009;
			int s = 1;
			int e = m;

			while (s <= e) {
				int mid = (s + e) / 2;

				ll value = abs(cur - b[mid]);

				if (value < gap) {
					gap = value;
					num = b[mid];
				}

				else if (value == gap) { // 추가한 부분
					if (num > b[mid]) num = b[mid];
				}

				if (value == 0) break;

				if (cur - b[mid] > 0) s = mid + 1;
				else e = mid - 1;
			}
			ans += num;
		}

		cout << ans << "\n";
	}

	return 0;
}