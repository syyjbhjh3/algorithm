# 숫자야구 (#2503)

cnt = int(input())


hint = [list(map(int, input().split())) for _ in range(cnt)]
result = 0
for a in range(1, 10):
    for b in range(1, 10):
        for c in range(1, 10):
            if a == b or b == c or a == c:
                continue
            
            answer = 0
            for arr in hint:
                number = arr[0]
                strike = arr[1]
                ball = arr[2]

                strike_cnt = 0
                ball_cnt = 0
        
                if a == number // 100:
                    strike_cnt += 1
                if b == number // 10 % 10:
                    strike_cnt += 1
                if c == number % 10:
                    strike_cnt += 1
                    
                if a == number // 10 % 10 or a == number % 10:
                    ball_cnt += 1
                if b == number // 100 or b == number % 10:
                    ball_cnt += 1
                if c == number // 100 or c == number // 10 % 10:
                    ball_cnt += 1

                

                number_str = str(number)
                if ball == ball_cnt and strike == strike_cnt:
                    answer += 1
            
            if answer == cnt:
                result += 1

print(result)