
//extend front and back
/*
class Solution {
  public String longestPalindrome(String s) {
      int n=s.length();
      int max=0;
      String longestPalin ="";
      for(int i=0;i<n;i++){
          String s1 = checkpalin(s,i,i);
          String s2="";
          if(i+1<n){
              s2= checkpalin(s,i,i+1);
          }
          if(s1.length()>s2.length() && s1.length()>max){
              max=s1.length();
              longestPalin=s1;
          }else if(s2.length()>s1.length() && s2.length()>max){
              max=s2.length();
              longestPalin=s2;
          }
      }
      return longestPalin;
  }

  private String checkpalin(String in, int l, int h){
      while(l>=0 && h<in.length() && in.charAt(l)==in.charAt(h) ){
          l--;
          h++;
      }        
      return in.substring(l+1,h);        
  }
}
*/

/*
class Solution {
  public String longestPalindrome(String s) {
      int n=s.length();
      int max=0;
      int ldist=0;
      int rdist=0;
      for(int i=0;i<n;i++){
          int s1 = checkpalin(s,i,i);
          int s2=0;
          if(i+1<n){
              s2= checkpalin(s,i,i+1);
          }
          if(s1>s2 && s1>max){
              max=s1;
              ldist=i-s1/2;
              rdist=i+s1/2;
          }else if(s2>s1 && s2>max){
              max=s2;
              ldist=i-(s2/2) +1;
              rdist=i+(s2/2);
          }
      }
      return s.substring(ldist,rdist+1);
  }

  private int checkpalin(String in, int l, int h){
      while(l>=0 && h<in.length() && in.charAt(l)==in.charAt(h) ){
          l--;
          h++;
      }        
      return h-l-1;        
  }
}
*/

/*
//DP
class Solution {
  public String longestPalindrome(String s) {
      int n=s.length();
      int lidx=0;
      int ridx=0;
      boolean[][] dp=new boolean[n][n];
      int max=1;
      for (int i = 0; i < n; i++) {
          dp[i][i] = true;
      }
      for (int i = n-1; i>0; i--) {
          if (s.charAt(i) == s.charAt(i-1)) {
              dp[i-1][i] = true;
              lidx = i-1;
              ridx = i;
              max=2;
          }
      }
      for(int i=n-2;i>=0 ;i--){
          for(int j=n-1;j>i ;j--){
              if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                  dp[i][j]=true;
                  if(j-i+1>max){
                      lidx=i;
                      ridx=j;
                      max=j-i+1;
                  }
              }
          }
      }
      return s.substring(lidx,ridx+1);
  }
}
*/
/*
//DP
class Solution {
  public String longestPalindrome(String s) {
      int n=s.length();
      int start=0;
      int end=0;
      boolean[][] dp=new boolean[n][n];
      for(int j=1;j<n;j++){
          for(int i=j;i>=0;i--){
              if(s.charAt(i)!=s.charAt(j)){
                  dp[i][j]=false;
              }else{
                  if(j-i<=2 || dp[i+1][j-1]){
                      dp[i][j]=true;
                      if(j-i>end-start){
                          end=j;
                          start=i;
                      }
                  }
              }
          }
      }
      return s.substring(start,end+1);

  }
}*/

//1D DP
//TC: O(n*n)
//SC: O(n)
class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
      int n=s.length();
      int start=0;
      int end=0;
      boolean[] dp=new boolean[n];
      for(int i=n-1;i>=0 ;i--){
          for(int j=n-1;j>=i ;j--){
              if(s.charAt(i)!=s.charAt(j)){
                  dp[j]=false;
              }else{
                  if(j-i<=2 || dp[j-1]){
                      dp[j]=true;
                      if(j-i>end-start){
                          end=j;
                          start=i;
                      }
                  }else{
                      dp[j]=false;
                  }
              }
          }
      }
      return s.substring(start,end+1);

  }
}