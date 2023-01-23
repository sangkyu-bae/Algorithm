class Solution
{
    public int solution(int n, int a, int b)
    {
        
        int round=n/2;
        int aRound =0;
        int bRound =0;
        
        if(a%2==0){
            aRound=a/2;   
        }else{
            aRound=a/2+1;
        }
        
        if(b%2==0){
            bRound=b/2;   
        }else{
            bRound=b/2+1;
        }
        
        
        int answer = 0;
        
        
        for(int i=0;;i++){
            answer++;
            if(aRound==bRound){
                break;
            }
            
            if(aRound%2==0){
                aRound=aRound/2;   
            }else{
                aRound=aRound/2+1;
            }
            if(bRound%2==0){
                bRound=bRound/2;   
            }else{
                bRound=bRound/2+1;
            }
        } 
        
    

        return answer;
    }
}