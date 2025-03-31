//sort the vertex acccording the connected edge number
public class AdEcount implements Comparable<AdEcount>{
        public int index;
        public int ecount;
       public AdEcount(int index, int ecount){
            this.ecount=ecount;
            this.index = index;
        }
    @Override
    public int compareTo(AdEcount o) {
        return (int)(this.ecount - o.ecount);
    }
}
