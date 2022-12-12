class Solution {
    boolean solution(String s) {
        String start = "(";
        String end = ")";
        if(!s.startsWith(start)){
            return false;
        }
        if(!s.endsWith(end)){
            return false;
        }
        int open = 0 ; 
        int close = 0 ;
      for (int i = 0 ; i<s.length(); i++) {
          if (s.charAt(i) == '(') {
              open++;
          }else{
              close++;
          }  
      }  
       if ((open+close)%2!=0){
           return false ;   
       }
        if (open != close){
            return false; 
        }
         int st = 0;
        int ed = 0 ; 
         for (int i = 0 ; i<s.length(); i++) {
            if (ed > st) {return false;} 
            if (s.charAt(i) == '(') {
              st++;
          }else{
              ed++;
          }  
      }  


        return true;
    }
}