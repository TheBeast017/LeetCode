class Solution {
    public int robotSim(int[]commands, int[][]obstacles) {
        int[][]dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int dir = 0;

        int x = 0, y = 0;
        int maxDist = 0;

        Set<Long>obstacleSet = new HashSet<>();
        for(int[]obs : obstacles){
            long key = encode(obs[0], obs[1]);
            obstacleSet.add(key);
        }

        for(int cmd : commands){
            if(cmd == -1){
                dir = (dir + 1) % 4;
            } else if(cmd == -2) {
                dir = (dir + 3) % 4;
            } else {
                for(int i = 0; i < cmd; i++) {
                    int nx = x + dirs[dir][0];
                    int ny = y + dirs[dir][1];

                    if(obstacleSet.contains(encode(nx, ny))) {
                        break;
                    }

                    x = nx;
                    y = ny;

                    maxDist = Math.max(maxDist, x * x + y * y);
                }
            }
        }

        return maxDist;
    }

    private long encode(int x, int y){
        return ((long)x << 32) | (y & 0xffffffffL);
    }
}
