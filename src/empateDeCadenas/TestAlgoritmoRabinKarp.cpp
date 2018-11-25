#include <bits/stdc++.h>

using namespace std;

vector <int> rabinKarp(string const& s, string const& t) {
    const int p = 31;
    const int m = 1e9 + 9;
    vector <long long> p_pow(max(s.size(), t.size()));
    // Se calculan las potencias
    cout << "Potencias: " << endl;
    p_pow[0] = 1;
    cout << p_pow[0] << " ";
    for (size_t i = 1; i < p_pow.size(); i++) {
        p_pow[i] = (p_pow[i-1] * p) % m;
        cout << p_pow[i] << " ";
    }
    cout << endl;
    cout << "Hashes del texto: " << endl;
    // Se calcula el hash para todos los prefijos del texto t
    vector <long long> h(t.size()+1, 0);
    for (size_t i = 0; i < t.size(); i++) {
        h[i + 1] = (h[i] + (t[i] - 'a' + 1) * p_pow[i]) % m;
        cout << h[i + 1] << " ";
    }
    cout << endl;
    cout << "Hash del patrón: " << endl;
    // Ahora el hash del patrón, el hash de la palabra completa
    long long h_s = 0;
    for (size_t i = 0; i < s.size(); i++) {
        h_s = (h_s + (s[i] - 'a' + 1) * p_pow[i]) % m;
    }
    cout << h_s << endl;
    // Se busca el número de ocurrencias
    vector <int> occurences;
    for (size_t i = 0; i + s.size() - 1 < t.size(); i++) {
        long long cur_h = (h[i+s.size()] + m - h[i]) % m;
        if(cur_h == h_s * p_pow[i] % m) {
            occurences.push_back(i);
        }
    }
    return occurences;
}

int main(int argc, char const *argv[]) {
    string s;
    string t;

    cout << "Escribe el texto: ";
    cin >> t;
    cout << "Escribe el patrón: ";
    cin >> s;
    vector <int> ans = rabinKarp(s, t);
    cout << "Ocurrencias: " << ans.size() << endl;
    for (int i = 0; i < (int)ans.size(); i++) {
        for (int j = 0; j < (int)t.size(); j++) {
            if(ans[i] == j) cout << "[" << t[j];
            else if(j == ans[i] + (int)s.size()-1) cout << t[j] << "]";
            else cout << t[j];
        }
        cout << endl;
    }
    return 0;
}
