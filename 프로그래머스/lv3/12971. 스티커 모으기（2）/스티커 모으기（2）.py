def solution(sticker):
    if len(sticker)==1: return sticker[0]
    
    d1, d2 = [0] * len(sticker), [0] * len(sticker)
    
    d1[0] = sticker[0]
    d1[1] = d1[0]
    for i in range(2, len(sticker)-1):
        d1[i] = max(d1[i-2]+sticker[i], d1[i-1])
    
    for i in range(1, len(sticker)):
        d2[i] = max(d2[i-2]+sticker[i], d2[i-1])

    return max(d1[-2], d2[-1])