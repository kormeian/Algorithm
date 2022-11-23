#include <bits/stdc++.h>
 
using namespace std;
 
string solution(vector<int> numbers, string hand) {
    string answer = "";
    int left = 4, right = 4;
    for(int num : numbers)
    {
        if(num%3==1)
        {
            answer+="L";
            left = (num/3)+1;
        }
        else if(num && num%3==0)
        {
            answer+="R";
            right = num/3;
        }
        else
        {
            int tl=0,tr=0;
            int now=8;
            if(num%3==2) now=(num/3)+5;
            
            if(left>4) tl=std::abs(now-left);
            else tl=std::abs(now-left-4)+1;
            
            if(right>4) tr=std::abs(now-right);
            else tr=std::abs(now-right-4)+1;
            
            if(tl<tr)
            {
                answer+="L";
                left=now;
            }
            else if(tl>tr || hand=="right")
            {
                answer+="R";
                right=now;
            }
            else
            {
                answer+="L";
                left=now;
            }
        }
    }
    return answer;
}