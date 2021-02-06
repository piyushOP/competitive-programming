#include<bits/stdc++.h>
#include<iostream>
using namespace std;


int minCoins(int coins[], int total){
	int dp[100] = {0};

	for(int i=1;i<=total;i++){
		int minCoin=10000;
		for(int coin : coins){
			if(coin >= i){
				minCoin = min(minCoin, dp[i-coin]);
			}
		}

		dp[i] = minCoin;
	}

	return dp[total];
}



int main(){
	int coins[] = {1,3,5};
	int total = 8;
	cout<<minCoins(coins,total)<<endl;

	return 0;
}

