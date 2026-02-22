class Solution:
    def countPoints(self, points, queries):
        result = []
        
        for cx, cy, r in queries:
            count = 0
            r_squared = r * r
            
            for px, py in points:
                dx = px - cx
                dy = py - cy
                
                if dx * dx + dy * dy <= r_squared:
                    count += 1
            
            result.append(count)
        
        return result
