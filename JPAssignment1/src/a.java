
class a
{
public static void main(String args[])
{
c B=new c();
gen(B);
System.out.println(B.B1[0].x);
}
static void gen(c C1)
{
C1.B1[0].x=5;//bug in the line
C1.B1[1].x=6;
C1.B1[2].x=7;
}
}

class b
{
int x;
}

class c
{
b B1[]={new b(),new b(),new b()};
}
