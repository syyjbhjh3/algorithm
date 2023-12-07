class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int time = attacks[attacks.length-1][0];
        int combo = 0;
        
        //bandage
        int skillTime = bandage[0];
        int recovery = bandage[1];
        int plus = bandage[2];
              
        //attack index
        int index = 0;
        int maxHealth = health;
        
        for(int i=0; i<=time; i++){
            if(i == attacks[index][0]){
                health -= attacks[index][1];
                if(health <= 0){
                    health = -1;
                    break;
                }else{
                    index++;   
                }
                combo = 0;
            }else{
                combo++;
                if(combo == skillTime){
                    health = health + recovery + plus;
                    combo = 0;
                }else{
                    health += recovery;    
                }
                
                if(health > maxHealth){
                    health = maxHealth;
                }
                System.out.println(i + " " + health);
            }
        }
            
        answer = health;    
        return answer;
    }
}