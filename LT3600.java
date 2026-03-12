class Solution{
    class DSU{
        int[] p,r;
        DSU(int n){
            p=new int[n];
            r=new int[n];
            for(int i=0;i<n;i++)p[i]=i;
        }
        int f(int x){
            if(p[x]!=x)p[x]=f(p[x]);
            return p[x];
        }
        boolean u(int a,int b){
            int pa=f(a),pb=f(b);
            if(pa==pb)return false;
            if(r[pa]<r[pb])p[pa]=pb;
            else if(r[pb]<r[pa])p[pb]=pa;
            else{
                p[pb]=pa;
                r[pa]++;
            }
            return true;
        }
    }

    public int maxStability(int n,int[][] edges,int k){
        long l=0,r=200000,ans=-1;
        while(l<=r){
            long m=(l+r)/2;
            if(ok(n,edges,k,m)){
                ans=m;
                l=m+1;
            }else r=m-1;
        }
        return (int)ans;
    }

    boolean ok(int n,int[][] edges,int k,long x){
        DSU d=new DSU(n);
        int c=0;
        for(int[]e:edges){
            if(e[3]==1){
                if(e[2]<x)return false;
                if(!d.u(e[0],e[1]))return false;
                c++;
            }
        }
        List<int[]> list=new ArrayList<>();
        for(int[]e:edges)if(e[3]==0)list.add(e);
        list.sort((a,b)->b[2]-a[2]);
        int up=0;
        for(int[]e:list){
            if(c==n-1)break;
            int u=e[0],v=e[1],s=e[2];
            if(d.f(u)==d.f(v))continue;
            if(s>=x){
                d.u(u,v);
                c++;
            }else if((long)s*2>=x&&up<k){
                up++;
                d.u(u,v);
                c++;
            }
        }
        return c==n-1;
    }
}
