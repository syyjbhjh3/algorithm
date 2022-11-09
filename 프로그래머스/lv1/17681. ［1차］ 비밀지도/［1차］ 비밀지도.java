class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] strArr1 = new String[n];
        String[] strArr2 = new String[n];
        
        for(int i=0; i<arr1.length;i++){
            strArr1[i] = Integer.toBinaryString(arr1[i]);
            strArr2[i] = Integer.toBinaryString(arr2[i]);
            
            while(strArr1[i].length() < n){
                strArr1[i] = "0" + strArr1[i];
            }
            
            while(strArr2[i].length() < n){
                strArr2[i] = "0" + strArr2[i];
            }
            
            String temp = "";
            
            for(int j=0; j<strArr1[i].length(); j++){
                 char tempChar1 = strArr1[i].charAt(j);
                 char tempChar2 = strArr2[i].charAt(j);
              
                 if(tempChar1 == '0' && tempChar2 == '0' ){
                     temp += " ";
                 }else{
                     temp += "#";
                 }
             }
            answer[i] = temp;
        }
        return answer;
    }
}