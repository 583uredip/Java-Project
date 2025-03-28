#include<iostream>
#include<string>
using namespace std;
class Solution
{
public:
 string ip(string address)
 {
    string result;
    for(char ch:address)
    {
        if(ch=='.')
        {
            result+="[.]";
        }
        else
        {
            result+=ch;
        }
    }
    return result;
 }

};
int main()
{
    Solution solution;
    string ipaddress;
    cout << "Enter IPv4 address: ";
    getline(cin,ipaddress);
    string answer=solution.ip(ipaddress);
    cout << "Defanged IP: " <<answer<< endl;
    return 0;

}