import java.io.*;
class evaluation
{
    int a[];
    int sp,n;
    evaluation(int nn)
    {
        n=nn;
        a = new int[n]; 
        for(int i=0;i<n;i++)
        a[i]=0;
        sp=-1;
    }
    void push(int item)
    {
        sp++;
        a[sp]=item;
    }
    int pop()
    {
        int v;
        v=a[sp];
        sp--;
        return v;
    }
    boolean underflow()
    {
        if(sp==-1)
        return true;
        else 
        return false;
    }
    boolean overflow()
    {
        if(sp==(n-1))
        return true;
        else
        return false;
    }
    public static void main(String args[]) throws IOException
    {
        int l,i;String str;
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        System.out.println("Enter the POSTFIX expression to be evaluated");
        str=in.readLine();
        l=str.length();
        evaluation st= new evaluation(l);
        for(i=0;i<l;i++)
        {
            char ch=str.charAt(i);
            if((st.overflow()==false) && (Character.isDigit(ch)==true))
            st.push(Character.getNumericValue(ch));
            else
            {
                if(st.underflow()==false)
                {
                    int v1=st.pop();
                    int v2=st.pop();
                    switch(ch)
                    {
                        case '+':
                        st.push(v2+v1);
                        break;
                        case '-':
                        st.push(v2-v1);
                        break;
                        case '*':
                        st.push(v2*v1);
                        break;
                        case '/':
                        st.push(v2/v1);
                        break;
                    }
                }
            }
        }
        System.out.print("Output : ");
        System.out.println(st.pop());
    }
}