class Robot {
    int w, h, x, y, dir, perimeter;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    String[] d = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        w = width;
        h = height;
        x = 0;
        y = 0;
        dir = 0;
        perimeter = 2 * (w + h) - 4;
    }
    
    public void step(int num) {
        num %= perimeter;
        if (num == 0 && x == 0 && y == 0) dir = 3;
        while (num > 0){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || nx >= w || ny < 0 || ny >= h){
                dir = (dir + 1) % 4;
            }else{
                x = nx;
                y = ny;
                num--;
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return d[dir];
    }
}
