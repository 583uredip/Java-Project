
#include<iostream>
using namespace std;
int row,column;
bool draw=false;

char broad[3][3]={{'1','2','3'},{'4','5','6'},{'7','8','9'}};
char turn='X';
void display_broad()
{
system("cls");

cout<<"              !!Tick Cross Game!!"<<endl;
cout << "             --------------------    " << endl;
cout<<endl;
cout << " \t*Player:1[X]" << endl;
cout << "\t*Player:2[O]" << endl;
cout<<endl;
cout << "  \t\t     |      | " <<endl;
cout << "  \t\t  "<<broad[0][0]<<"  |  "<<broad[0][1]<<"   |"<<broad[0][2]<<" "<<endl;
cout << "  \t\t_____|______|______"<< endl;
cout << "  \t\t     |      |" <<endl;
cout << "  \t\t  "<<broad[1][0]<<"  |  "<<broad[1][1]<<"   |"<<broad[1][2]<<" "<<endl;
cout << "  \t\t_____|______|______"<< endl;
cout << "  \t\t     |      |" <<endl;
cout << "  \t\t  "<<broad[2][0]<<"  |  "<<broad[2][1]<<"   |"<<broad[2][2]<<" "<<endl;
cout << "  \t\t     |      |" <<endl;
cout<<endl;
}

void player_turn()
{

int choice;

if(turn=='X')
{cout << "\tPlayer:1 [X] Turn:";}
if(turn=='O')
{cout << "\tPlayer:2 [O] Turn:";}

cin >> choice;

switch(choice)
{
case 1:row=0; column=0;break;
case 2:row=0; column=1;break;
case 3:row=0; column=2;break;
case 4:row=1; column=0;break;
case 5:row=1; column=1;break;
case 6:row=1; column=2;break;
case 7:row=2; column=0;break;
case 8:row=2; column=1;break;
case 9:row=2; column=2;break;
default:
cout << "Invalid Choice" << endl;
break;
}
if(turn=='X'&& broad[row][column]!='X'&& broad[row][column]!='O')
{
broad[row][column]='X';
turn='O';}
else if(turn=='O'&& broad[row][column]!='X'&& broad[row][column]!='O')
{
broad[row][column]='O';
turn='X';}
else
{
    cout<<"Box already filled!\n Plesse try again!!\n\n";
    player_turn();
}



display_broad();
}
bool gameover()
{
    for(int i=0;i<3;i++)
    if(broad[i][0]==broad[i][1]&&broad[i][1]==broad[i][2]||broad[0][i]==broad[1][i]&&broad[0][i]==broad[2][i])
        return false;

        if(broad[0][0]==broad[1][1]&&broad[0][0]==broad[2][2]||broad[0][2]==broad[1][1]&&broad[0][2]==broad[2][0])
        return false;
    for(int i=0;i<3;i++)
    for(int j=0;j<3;j++)
    if(broad[i][j]!='X'&& broad[i][j]!='O')
    return true;

     draw=true;
    return false;




}

int main ()
{

while(gameover())
{

display_broad();
player_turn();
gameover();

}
 if(turn=='X'&&draw==false)
 cout<<"Player 2 [O] Wins!!Congratulation\n";
else if(turn=='O'&&draw==false)
 cout<<"Player 1 [X] Wins!!Congratulation\n";
 else
    cout<<"Game Draw!!\n";
}

