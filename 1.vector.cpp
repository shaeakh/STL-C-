/*bismillahir~rahmanir~rahim*/
#include <bits/stdc++.h>
using namespace std;
int main(){

    int i = 6,value,n=3;

    //vector declaration 
    vector <int> v1;                // empty vec
    vector <int> v2(4);             // 97851 97851 97851 97851 (random value)
    vector <int> v3(4,6);           // 6 6 6 6
    vector <int> v4 = {1,2,3,4};    // 1,2,3,4

    //vector assigning value

    //if the size isn't declared already
    v1.push_back(value);
    //if the size is declared already
    v2[i] = value;

    //functions
    v1.push_back(1); // adds value in the vector one after one (queue)
    v1.pop_back();   // removes value in the vector one after one (queue)
    v4.front();      // 1 -> first value of vector 
    v4.back();       // 4 -> last value of vector 
    v2.resize(n);    // vector will resize with n elements.
    v4.clear();      // vector becomes empty 
    

    return 0;
}
/* problem link: */
