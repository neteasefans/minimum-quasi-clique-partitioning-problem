import java.util.ArrayList;
import java.util.List;
//define a quasi-clique
public class Cicque implements Cloneable {
    int index;
    int vectexCount;
    int edgeCount;
    double gamma;
    int[] vectexList;
    boolean ExistcanMove;
    int[] canMoveList;

    public Cicque(int index,int vectexCount,    int edgeCount,    double gamma,    int[] vectexList){
        this.edgeCount=edgeCount;
        this.index = index;
        this.vectexCount=vectexCount;
        this.gamma= gamma;
        this.vectexList= vectexList;
    }
    public void getcanMove(double gamma,int[][] edgeArr){

        int count=0;
        List<Integer> tempList = new ArrayList<Integer>();
        for(int i :vectexList){
            for(int j :vectexList){
                if((i!=j)&&(edgeArr[i][j])==1){
                    count++;
                    tempList.add(i);
                }
            }
        }
        if(count==0){
            this.ExistcanMove = false;
            this.vectexList = new int[]{};
        }else{
            this.ExistcanMove = true;
            this.canMoveList = new int[count];
            for(int k = 0;k<count;k++){
                this.canMoveList[k]= tempList.get(k);
            }
        }

    }
    public void setIndex(int index){
        this.index = index;
    }
    protected Cicque clone() throws CloneNotSupportedException {
        return (Cicque) super.clone();
    }

}
