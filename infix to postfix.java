import java.io.*;
class conversion
{
char a[];
int sp,n;
  conversion(int nn)
  {
      n=nn;
      a = new char[n]; 
      for(int i=0;i<n;i++)
      a[i]=0;
      sp=-1;
  }
  void push(char item)
  {
      sp++;
      a[sp]=item;
  }
  char pop()
  {
      char v;
      v=a[sp];
      sp--;
      return v;
  }
  char peek()
  {
      return(a[sp]);
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
  int priority(char x)
  {
      if(x=='+'||x=='-')
      return 1;
      if(x=='*'||x=='/')
      return 2;
      return 0;
  }
  public static void main(String args[]) throws IOException
  {
      int l,i=0;String str1,str2,postfix,prefix;char ch,x;postfix="";prefix="";str2="";
      InputStreamReader read = new InputStreamReader(System.in);
      BufferedReader in = new BufferedReader(read);
      System.out.println("Enter the Infix expression");
      str1=in.readLine();
      l=str1.length();
      conversion st= new conversion(l);
      for(i=0;i<l;i++)
      {
          ch=str1.charAt(i);
          if(Character.isLetterOrDigit(ch)==true)
           postfix=postfix+ch;
          else if(ch=='(')
          {
           st.push(ch);
          }
          else if(ch==')')
          {
           while(st.underflow()==false && st.peek()!='(')
           postfix=postfix+st.pop();
           st.pop();
          }
          else
          {
           while(st.underflow()==false &&(st.peek()!='(' ) && (st.priority(ch)<=st.priority(st.peek())))
           postfix=postfix+st.pop();
           st.push(ch);
          }
      }
      while(st.underflow()==false)
      {    postfix=postfix+st.pop();
           System.out.print("Postfix Expression : ");
           System.out.println(postfix);
      }
  }
}