import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // Map to store player's name and their current index
        Map<String, Integer> playerIndex = new HashMap<>();
        
        // Initialize the map with player's name and their initial index
        for (int i = 0; i < players.length; i++) {
            playerIndex.put(players[i], i);
        }

        // Iterate through the callings
        for (String calling : callings) {
            // Get the current index of the player being called
            int currentIndex = playerIndex.get(calling);
            
            // Swap the player with the player right in front of them (if not already at the front)
            if (currentIndex > 0) {
                String frontPlayer = players[currentIndex - 1];
                
                // Swap players in the array
                players[currentIndex] = frontPlayer;
                players[currentIndex - 1] = calling;
                
                // Update the indices in the map
                playerIndex.put(calling, currentIndex - 1);
                playerIndex.put(frontPlayer, currentIndex);
            }
        }
        
        return players;
    }
}
