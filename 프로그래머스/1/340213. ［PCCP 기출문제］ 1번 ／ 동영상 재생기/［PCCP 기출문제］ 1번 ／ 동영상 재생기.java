class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 비디오 길이, 현재 재생 위치, 오프닝 시작 및 종료 시각을 초 단위로 변환
        int len = timeToSeconds(video_len);
        int current = timeToSeconds(pos);
        int start = timeToSeconds(op_start);
        int end = timeToSeconds(op_end);
        
        // 첫 번째 오프닝 구간 확인
        if (start <= current && current <= end) {
            current = end;
        }

        // 명령어 리스트 처리
        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                // 10초 전으로 이동
                current -= 10;
                if (current < 0) {
                    current = 0;
                }
            } else if (cmd.equals("next")) {
                // 10초 후로 이동
                current += 10;
                if (current > len) {
                    current = len;
                }
            }
            
            // 명령어 수행 후 오프닝 구간 확인
            if (start <= current && current <= end) {
                current = end;
            }
        }

        // 초 단위 시간을 "mm:ss" 형식으로 변환하여 반환
        return secondsToTime(current);
    }
    
    // "mm:ss" 형식을 초 단위로 변환하는 메서드
    public int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }
    
    // 초 단위를 "mm:ss" 형식으로 변환하는 메서드
    public String secondsToTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
