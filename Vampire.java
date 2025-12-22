import java.util.*;
class Vampire
{
    public static void main(String[] a) 
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Number : ");
        long n=s.nextLong();
        String t=""+n;
        if (t.length()%2!=0) 
        {
            System.out.println("INVALID!! Please input even digits number");
            return;
        }
        int l=t.length()/2;
        long x=(long)Math.pow(10,l-1);
        long y=(long)Math.pow(10,l);
        boolean f=false;
        for(long i=x;i<y;i++) 
        {
            if (n%i==0) 
            {
                long j=n/i;
                if(i<=j&&j>=x&&j<y&&!(i%10==0&&j%10==0)) 
                {
                    if(check(n,i,j)) 
                    {
                        if(!f) 
                        {
                            System.out.println(n+" is vampire number");
                            System.out.println("Combination :");
                            f=true;
                        }
                        System.out.println(i+" * "+j);
                    }
                }
            }
        }
        if (!f&&t.length()%2==0)
            System.out.println(n+" is not vampire number");
    }
    static boolean check(long n,long i,long j) 
    {
        int c[]=new int[10];
        String a=""+n,b=""+i+j;
        if(a.length()!=b.length()) 
            return false;
        for(int k=0;k<a.length();k++) 
            c[a.charAt(k)-'0']++;
        for(int k=0;k<b.length();k++) 
            c[b.charAt(k)-'0']--;
        for(int k=0;k<10;k++) 
            if (c[k] != 0) 
                return false;
        return true;
    }
}