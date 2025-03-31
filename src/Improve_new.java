import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Improve_new {

    static int[][] edgeArr;
    static int vLength;
    static int eLength;
    static int Num1;
    static int Num2;
    static long T1;
    static int tabulFlag = 0;
    static long stopTime = 500;
    static int endIter1 ;
    static int ITER;
    static int[][] tabulList3 ;
    static int localjump ;
      static   int[][] ValueArr ;
      static  int[][] SwapArr ;
  static int[][] swapArr_1;
   static List<Integer> L;
    static long objtime;
    static Random r = new Random();
    static int readType;
    static int[] vEdgeCount;
    static int fbest;
    static int zeroCount;
    static int totalBest;
    static int bestCounter;

    static int[][] bestArr;
    static int iter;
    static double T0 ;


    static double AveragrDev;
    static boolean flag ;
    static double gamma;
    static double gamma1;

    static double updateO = 0.3;
    static String f = "anna.txt";
    static int[][] tabulist2 ;
    static List<Cicque> CliqueList = new ArrayList<Cicque>();
    static List<Cicque> bestCliqueList = new ArrayList<Cicque>();
    static double upTnum = 0.95;

    static int[] vEdgelength;
    static int[] cliqueVectexnum;
    static int[][] adjacentPoint;
    static int totalIter;
    static int maxtotalIter = 50000000;
    static int[] tabulist;
    static int[] tabulist4;
    static int Tabul ;
    static double totalGamma ;
    //
    static int[] cList11 ;
    static int turbon_result_flag;
    //
    static double[] turbonList;
    //
    static double[] sdList;
    //
    static double[] UdList;

    static boolean flag1 ;
    static long MoveT;
    static long improve1T;
    static long improve6_7T;
    static int IterNum2;
    static int IterNum1;
    static long SwapT ;
    static long stime;
    static long etime;


//----------------------------------------------------------------------------------
public static void instailial() throws IOException {
    improve1T = 0;
    IterNum1 =0;
    IterNum2 =0;
    improve6_7T = 0;
    MoveT =0;
    ITER =0;
    turbonList = new double[]{1, 1, 1, 1};
    sdList = new double[]{1, 1, 1, 1};
    UdList = new double[]{0, 0, 0, 0};
    T1 = 0;
    iter = 0;
    T0 = 10000;
    eLength = 0;
    flag = false;
    flag1 = true;
    bestCounter = 0;
    Num1 = 0;
    Num2 = 0;
    L = new ArrayList<>();
//        int zeroCount = 0;
    gamma1 = 0;
    totalIter = 0;
    flag = false;

    CliqueList = new ArrayList<Cicque>();
    List<String> lines = new ArrayList<String>();


    String fliename2 = f;
//    System.out.println("" + fliename2);
    BufferedReader br = new BufferedReader(new FileReader(fliename2));
    String line = null;
    int ik = -1;
    while (((line = br.readLine()) != null)) {

        if(readType==0){
            String[] param = line.trim().split("\\s");
            readmax(param);
        } else if (readType==1) {
            String[] param = line.trim().split("\\s");
            readmin(param);
        } else if (readType==2) {
            String[] param = line.trim().split("\\s+");
            readmax(param);
        } else if (readType ==3) {
            String[] param = line.trim().split("\\s+");
            readprison(param,ik);
            ik++;
        }
//


    }
//        String line = null;
    if(L.size()!=vLength){
        int[][] edgeArr1=edgeArr;
        int vLength1=vLength;
        int  edgeArrCount = 0;
        for( int[] k :edgeArr){
            edgeArrCount++;
        }
        edgeArr = new int[vLength][vLength];

        vLength=L.size();

        vEdgeCount = new int[vLength];
        edgeArr = new int[vLength][vLength];
        edgeArrCount = 0;
        for( int k :edgeArr[0]){
            edgeArrCount++;
        }

        vEdgelength = new int[vLength];
        adjacentPoint = new int[vLength][vLength];
        tabulist = new int[vLength];
        cliqueVectexnum = new int[vLength];
        for(int x = 0;x<vLength1;x++){
            for(int y = 0;y<vLength1;y++){
                if(edgeArr1[x][y] == 1){
                    int  index_X = L.indexOf(x);
                    int  index_Y = L.indexOf(y);
                    edgeArr[index_X][index_Y] = 1;
                    edgeArr[index_Y][index_X] = 1;

                }

            }
        }

    }
    tabulist2 = new int[vLength][vLength];
    cList11 = new int[vLength];


    br.close();

    for (int i = 0; i < vLength; i++) {
        for (int j = 0; j < vLength; j++) {
            if (i == j){
                edgeArr[i][j]=0;
            }else if(edgeArr[i][j] == 1) {
                vEdgelength[i]++;
                vEdgeCount[i] ++;
                adjacentPoint[i][vEdgelength[i]] = j;
                eLength ++;
            }
        }
    }

    eLength /= 2;

    totalGamma = Gamma(vLength,eLength);
}

    public static void readmin(String[] param) {

        if (param[0].equals("p")) {
            int y = Integer.parseInt(param[2]);
            vLength = y;

            vEdgeCount = new int[vLength];

            edgeArr = new int[vLength][vLength];
            vEdgelength = new int[vLength];
            adjacentPoint = new int[vLength][vLength];
            tabulist = new int[vLength];
            cliqueVectexnum = new int[vLength];


        } else if (param[0].equals("e")) {
            int x = Integer.parseInt(param[1]);
            int y = Integer.parseInt(param[2]);

            edgeArr[x - 1][y - 1] = 1;
            edgeArr[y - 1][x - 1] = 1;
            if(!L.contains(x-1)){
                L.add(x-1);
            }
            if(!L.contains(y-1)){
                L.add(y-1);
            }
        }



    }

public static void readprison(String[] param,int k) {
    if (param[0].equals("p")) {
        int y = Integer.parseInt(param[2]);
        vLength = y;
        vEdgeCount = new int[vLength];
        edgeArr = new int[vLength][vLength];
        vEdgelength = new int[vLength];
        adjacentPoint = new int[vLength][vLength];
        tabulist = new int[vLength];
        cliqueVectexnum = new int[vLength];
    } else {
        for(int i =0; i<vLength;i++){
            int x = Integer.parseInt(param[i]);

            if(x == 1){
                edgeArr[k][i] = 1;
                edgeArr[i][k] = 1;
                if(!L.contains(x)){
                    L.add(x);
                }
            }
        }
        if(!L.contains(k)){
            L.add(k);
        }

    }
}

public static void readmax(String[] param) {
        if (param[0].equals("p")) {
            int y = Integer.parseInt(param[2]);
            vLength = y;
            vEdgeCount = new int[vLength];
            edgeArr = new int[vLength][vLength];
            vEdgelength = new int[vLength];
            adjacentPoint = new int[vLength][vLength];
            tabulist = new int[vLength];
            cliqueVectexnum = new int[vLength];

        } else {
            int x = Integer.parseInt(param[0]);
            int y = Integer.parseInt(param[1]);
            edgeArr[x - 1][y - 1] = 1;
            edgeArr[y - 1][x - 1] = 1;
            if(!L.contains(x-1)){
                L.add(x-1);
            }
            if(!L.contains(y-1)){
                L.add(y-1);
            }

        }
    }

//get initial solution
    public static int firstWay(double n1n1) {

        gamma = n1n1;

        insert1(sort_max(vLength));
        fbest = objCount();
        objtime = System.currentTimeMillis();
        AveragrDev = averageDev();

        return CliqueList.size();
    }

    public static int[] sort_max(int n){
//
        List<AdEcount> countList = new ArrayList<>();
        for(int i = 0;i < n;i++){
            AdEcount a= new AdEcount(i,vEdgelength[i]);
            countList.add(a);
        }
        Collections.sort(countList, (a,b)->{
            return a.ecount - b.ecount;
        });
        Collections.reverse(countList);
        int[] serverList = new int[n];

        int l=0;
        for(AdEcount b :countList ){
            serverList[l] = b.index;
            l++;
        }
        return serverList;
    }


    public static boolean checkAddClique() {
        long t1 = System.currentTimeMillis();

        boolean fg=false;
        while (check_two()) {
            fg = true;
            checkAdd_1(CliqueList);
            updateIndex();

        }

        return fg;
    }




    public static void makeSingleElement(int i){

        int[] list1 = {i};
        int num = CliqueList.size();
        Cicque Ci = new Cicque(num,1,0,1,list1);
        CliqueList.add(Ci);

    }



    public static void insert1(int[] vList){
        for(int v :sort_max(vList)){
            insertone1(v);
        }


    }


    public static void insertone(int v){
            makeSingleElement(v);

    }


    public static void insertone1(int v){


        if(CliqueList.size()<3| (CliqueList == null)) {
            makeSingleElement(v);
        }

        else if (checkadd1(v)&&(CliqueList.size()>2)) {
            addOne(v);
        }else{
        makeSingleElement(v);
          }
        checkAddClique();
    }

    public static int[] sort_max(int[] n){
//
        List<AdEcount> countList = new ArrayList<>();
        for(int i = 0;i < n.length;i++){
            AdEcount a= new AdEcount(n[i],vEdgelength[n[i]]);
            countList.add(a);
        }
        Collections.sort(countList, (a,b)->{
            return a.ecount - b.ecount;
        });
        Collections.reverse(countList);
        int[] serverList = new int[n.length];

        int l=0;
        for(AdEcount b :countList ){
            serverList[l] = b.index;
            l++;
        }
        return serverList;
    }


    public static boolean checkadd1(int i) {

        boolean f = false;
        for (int j = 0; j < CliqueList.size(); j++) {
            if (countEV(CliqueList.get(j), i) >= gamma) {
                f = true;
                break;
            }
        }
        return f;
    }
    public static void addOne(int i) {
        int n = 0;
        int[] beixuan = new int[CliqueList.size()];
        double[] devList = new double[CliqueList.size()];
         double maxvalue = -1000;
        int maxindex=1000000;
        for (int j = 0; j < CliqueList.size(); j++) {
            double dev = countEV(CliqueList.get(j), i);
            if (dev >= gamma) {
                devList[n] = dev;
                beixuan[n] = j;
                 if(maxvalue < devList[n]){
                     maxvalue = devList[n];
                 }
                 n += 1;
            }
        }
       List<Integer> maxIndexList =new ArrayList<Integer>();
        for(int k =0 ;k< n;k++){
            if(devList[k] == maxvalue){
                maxIndexList.add(beixuan[k]);
            }
        }
        maxindex =maxIndexList.get( r.nextInt(maxIndexList.size()));
            addVectex(CliqueList.get(maxindex), i);

    }

    public static void checkAdd_1(List<Cicque> CliqueList) {
        int size = CliqueList.size();
        int count =size*(size-1)/2;
        int m = 0;
        int[][] valueCheck = new int[count][2];
        double[] devList = new double[count];
        int[] ecountList = new int[count];
        double maxDev = -100000;
        for (int i = 0; i < CliqueList.size(); i++) {
            for (int j = 0; j < CliqueList.size(); j++) {
                if (i < j) {
                    Cicque[] cicquelist = {CliqueList.get(i), CliqueList.get(j)};
                    double tempDev = countDev(cicquelist);
                    if (tempDev >= gamma) {
                        ecountList[m] = countE(cicquelist)-CliqueList.get(i).edgeCount-CliqueList.get(j).edgeCount;
                        devList[m] = tempDev;
                        valueCheck[m][0] = i;
                        valueCheck[m][1] = j;
                        m++;
                        if(tempDev>maxDev){
                            maxDev = tempDev;
                        }
                    }
                }
            }
        }

        List<Integer> LL = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (devList[i] == maxDev) {
                LL.add(i);
            }
        }

        int CliqueIndex = 100000;

        CliqueIndex = LL.get(r.nextInt(LL.size()));
        Cicque[] cicquelist1 = {CliqueList.get(valueCheck[CliqueIndex][0]), CliqueList.get(valueCheck[CliqueIndex][1])};


        addCicque(cicquelist1);


    }


    public static int countee1(Cicque[] cliquelist) {
        int count = 0;
        for(int v :cliquelist[0].vectexList){
            count+=swapArr_1[v][cliquelist[1].index];
        }
        count += (cliquelist[0].edgeCount+cliquelist[1].edgeCount);
        return count;
    }



    public static int getAdd_count() {
        int count = 0;
        for (int i = 0; i < CliqueList.size(); i++) {
            for (int j = 0; j < CliqueList.size(); j++) {
                if (i < j) {
                    Cicque[] cicquelist = {CliqueList.get(i), CliqueList.get(j)};
                    double tempDev = countDev(cicquelist);
                    if (tempDev >= gamma) {
                        count += 1;
                    }
                }
            }
        }

        return count;
    }
    public static boolean check_two() {
        boolean flag = false;
        for (int i = 0; i < CliqueList.size(); i++) {
            for (int j = 0; j < CliqueList.size(); j++) {
                if (i < j) {
                    Cicque[] cicquelist = {CliqueList.get(i), CliqueList.get(j)};
                    double tempDev = countDev(cicquelist);
                    if (tempDev >= gamma) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public static void updateTabul(){
        if(tabulFlag ==0){

                Tabul = (int)( (r.nextInt(2)+1)*0.1*vLength);

        }else{
            Tabul = (int)( (r.nextInt(tabulFlag)+1)*0.1*vLength);
        }
        }

//----------------------------------------------------------------------------
public static void localSearch(int endIter7){

    int S0 = CliqueList.size();

    int k  = 0;
    int Kmax = 2;
    int non_improvement = 0;

    while(k<Kmax){
        if(checkEnd()){
            break;
        }

        if(k==0){
            improve_7(endIter7);

        } else if(k==1){
            for(int i =0;i<vLength;i++){
                tabulist[i] = 0;
            }
            long t1 = System.currentTimeMillis();
            improve_1();
            improve1T+=System.currentTimeMillis()-t1;
        }

        k++;
        int S = CliqueList.size();
        if(S < S0){
            S0 = S;
            k = 0;
        }else{
            non_improvement ++;

        }

    }

}





    public static double countDev(Cicque[] cicque) {
        int vCount = 0;
        int eCount = 0;

        int[] L = new int[cicque[0].vectexCount + cicque[1].vectexCount];
        int k = 0;
        for (Cicque c : cicque) {
            vCount += c.vectexCount;
            for (int v : c.vectexList) {
                L[k] = v;
                k++;
            }
        }
        eCount = countE(cicque);
        double dev = Gamma(vCount, eCount);
        return dev;
    }

    public static boolean checkEnd(){
        boolean flag3 =false;
        etime =System.currentTimeMillis();
        if(etime-stime > 1000*stopTime){

            flag3 = true;
        }
        return flag3;
    }


    public static void improve_1(){
        if(checkEnd()){
            return;
        }
        int innerCount = 0;

        Countedge();

        while(true) {

            if (objCount() < fbest) {
                printTime();
                bestCliqueList = CloneCList(CliqueList);
                fbest = objCount();
                objtime = System.currentTimeMillis();
                bestCounter = totalIter;
                innerCount = 0;
            }
            if (checkEnd()) {
                break;
            }
            ITER++;
            IterNum2++;

            Countedge();
            totalIter += 1;
            innerCount++;
            if (innerCount > localjump) {
                break;
            }

            int[] moveList;
            int maxvalue = -100000;
            moveList = findfirstVectex();
            if (moveList.length < 1) {
                continue;
            }
            int chooseVectex = 10000;
            int chooseClique = 100000;

            chooseVectex = findVectexIndex3(moveList);
            int originC = cList11[chooseVectex];

            chooseClique = chooseClique1(chooseVectex);
            int tempCount = CliqueList.get(cList11[chooseVectex]).vectexCount;
            move(chooseVectex, chooseClique);
            Cicque[] tempCList = new Cicque[0];
            if (tempCount == 1) {
                Countedge();
//
            } else {

                for (int k = 0; k < vLength; k++) {
                    swapArr_1[k][cList11[chooseVectex]] -= edgeArr[chooseVectex][k];
                    swapArr_1[k][chooseClique] += edgeArr[chooseVectex][k];
                }
                updateCliqueIndex();
            }

            boolean km = false;
            km = checkAddClique();
            updateIndex();
            if (km) {
                Countedge();
            }
            updateTabul();
            tabulist[chooseVectex] = totalIter + Tabul;
            if (objCount() < fbest) {
                printTime();
                bestCliqueList = CloneCList(CliqueList);
                fbest = objCount();
                objtime = System.currentTimeMillis();
                bestCounter = totalIter;
                innerCount = 0;
            }
        }
    }


public static void printTime(){
//
}


    public static int findVectexIndex3(int[] moveList){

        int chooseIndex =1000000;


        double[] valueList = new double[moveList.length];

        for (int i = 0; i < moveList.length; i++) {
//
            int CIndex = cList11[moveList[i]];
//
            valueList[i] =swapArr_1[moveList[i]][CIndex];
        }

        double minv = 100000;
        List<Integer> LL= new ArrayList<>();
        for (int i = 0; i < moveList.length; i++) {
            if (valueList[i] <= minv) {
                minv = valueList[i];
            }
        }
        for(int i =0;i<moveList.length;i++){
            if(( valueList[i] == minv)){
                LL.add(moveList[i]);
            }
        }

        chooseIndex= LL.get(r.nextInt(LL.size()));
        return chooseIndex;

    }

    public static void improve_7(int endIter){

        long t1 = System.currentTimeMillis();

        boolean testFlag =true;
        while(testFlag){
            if(checkEnd()){
                break;
            }
            List<Cicque> CliqueList1 = CloneCList(CliqueList);
            int t = testBreakOne(CliqueList1,endIter);

            if(t>=endIter){
                testFlag =false ;
            }
            improve6_7T+=System.currentTimeMillis()-t1;
        }


    }
//--------------------------------------------------------------------

    public static double countEV(Cicque cicque,int vectex){

        int vCount1 = 0;
        vCount1 = cicque.vectexCount+1;
        int eCount=countE(cicque,vectex);
        double dev = Gamma(vCount1,eCount);
        return dev;
    }

    public static void addVectex(Cicque cicque,int vectex){
        int vCount = 0;
        int eCount = 0;
        vCount = cicque.vectexCount+1;
        int[] ListV= new int[vCount];
        if (cicque.vectexCount >= 0) System.arraycopy(cicque.vectexList, 0, ListV, 0, cicque.vectexCount);
        ListV[cicque.vectexCount] = vectex;
        eCount = countE(cicque,vectex);
        double dev = Gamma(vCount,eCount);
        CliqueList.get(cicque.index).vectexCount = vCount;
        CliqueList.get(cicque.index).edgeCount = eCount;
        CliqueList.get(cicque.index).gamma = dev;
        CliqueList.get(cicque.index).vectexList = ListV;
//        cList1[vectex]= cicque.index;

    }

    public static void addCicque(Cicque[] cicque){
        int vCount=0;
        int v=0;
        int eCount;
        int[] vList= new  int[cicque[0].vectexCount+cicque[1].vectexCount];
        for(Cicque c : cicque){
            if (c.vectexCount + vCount - vCount >= 0)
                System.arraycopy(c.vectexList, vCount - vCount, vList, vCount, c.vectexCount + vCount - vCount);
            vCount += c.vectexCount;
        }
        eCount = countE(cicque);
        double dev = Gamma(vCount,eCount);

        CliqueList.remove((cicque[1].index));
        CliqueList.get(cicque[0].index).vectexCount = vCount;
        CliqueList.get(cicque[0].index).edgeCount = eCount;
        CliqueList.get(cicque[0].index).gamma = dev;
        CliqueList.get(cicque[0].index) .vectexList = vList;
        updateIndex();

    }


//
    public static void updateIndex(){
        for(Cicque c : CliqueList){
            c.setIndex(CliqueList.indexOf(c));
        }
    }

    public static int objCount(){

        return CliqueList.size();
    }
    public static void improve(){

        totalIter = 0;
        tabulist = new int[vLength];
        while(totalIter < maxtotalIter) {
           if(checkEnd()){
               break;
           }
            turbon1();
        }

    }




    public static int[][] Countedge(){
        long t1 =System.currentTimeMillis();
        swapArr_1 = new int[vLength][CliqueList.size()];
        updateCliqueIndex();
        for(int v =0;v<vLength;v++){
            for(int j =0;j<vLength;j++){
                if((v<j)&&(edgeArr[v][j]==1)){
                    swapArr_1[v][cList11[j]]++;
                    swapArr_1[j][cList11[v]]++;
                }
            }
        }
        long t2 = System.currentTimeMillis()-t1;
        SwapT +=t2;
        return swapArr_1;
    }
    public static int[][] Countedge(List<Integer> tempList){
        long t1 =System.currentTimeMillis();
        swapArr_1 = new int[vLength][CliqueList.size()];
        updateCliqueIndex();
        for(int v =0;v<vLength;v++){
            for(int j =0;j<vLength;j++){
                if((v<j)&&(edgeArr[v][j]==1)){
                    if(!tempList.contains(v)){
                        swapArr_1[j][cList11[v]]++;
                    }
                    if(!tempList.contains(j)){
                    swapArr_1[v][cList11[j]]++;
                    }
                }
            }
        }
        long t2 = System.currentTimeMillis()-t1;
        SwapT +=t2;
        return swapArr_1;
    }
//-----------------------------------------------------------------

    public static int[] getList2(Cicque[] Cicque, int vectex) {

        int[] VL = new int[Cicque[0].vectexCount + Cicque[1].vectexCount +1];
        if (Cicque[0].vectexCount >= 0) System.arraycopy(Cicque[0].vectexList, 0, VL, 0, Cicque[0].vectexCount);

        if (Cicque[1].vectexCount >= 0)
            System.arraycopy(Cicque[1].vectexList, 0, VL, 0 + Cicque[0].vectexCount, Cicque[1].vectexCount);
        VL[Cicque[0].vectexCount + Cicque[1].vectexCount] = vectex;
        return VL;
    }

    public static int[] getList3(Cicque[] Cicque) {
        int totalVlength = 0;
        for(Cicque c: Cicque){
            totalVlength+=c.vectexCount;
        }
        int[] VL = new int[totalVlength];
        int counter = 0;
        for(Cicque c: Cicque){
            if (counter + c.vectexCount - counter >= 0)
                System.arraycopy(c.vectexList, counter - counter, VL, counter, counter + c.vectexCount - counter);
            counter += c.vectexCount;

        }

        return VL;
    }

    public static int countEdge1(int[] vectexL) {
        int eCount = 0;
        for(int i = 0;i<vectexL.length;i++){
            for(int j = 0;j<vectexL.length;j++){
                if((edgeArr[vectexL[i]][vectexL[j]]==1)&&(i<j)){
                    eCount++;
                }
            }
        }
        return eCount;
    }
    public static int countEdge2(List<Integer> vectexL) {
        int eCount = 0;
        for(int i = 0;i<vectexL.size();i++){
            for(int j = 0;j<vectexL.size();j++){
                if((edgeArr[vectexL.get(i)][vectexL.get(j)]==1)&&(i<j)){
                    eCount++;
                }
            }
        }
        return eCount;
    }

    public static boolean  checkINList(int[] vectexList,int v){
        boolean flag =false;
        for(int v1 : vectexList){
            if(v1 == v){
                flag =true;
                break;
            }
        }
        return flag;
    }

    public static int countE(Cicque[] cicque,int j){
        int size = cicque[0].vectexCount+cicque[1].vectexCount+1;
        int[] vList = new int[size];
        int[] vList0 = getList3(cicque);
        if (size - 1 >= 0) System.arraycopy(vList0, 0, vList, 0, size - 1);
        vList[size-1]=j;
//        int eCount = countEdge1(vList);

        int eCount =countE(cicque);
        for(Cicque c:cicque){
            for(int i :c.vectexList){
                if(edgeArr[j][i]==1){
                    eCount++;
                }
            }
        }
        return eCount;
    }


    public static int countE(Cicque c,int j){


        int eCount1 = 0;
//        int addvalue = 0;
        eCount1 += c.edgeCount;
        for(int i = 0;i<c.vectexList.length;i++){
            if(edgeArr[j][c.vectexList[i]]==1){
                eCount1++;
//                addvalue++;
            }
        }

        return eCount1;

    }

    public static int countE(Cicque cicque,List<Integer> vList){

        int eCount = cicque.edgeCount;
        int[] vList1 = new int[vList.size()];
        for(int i = 0;i< vList.size();i++){
            vList1[i] = vList.get(i);
            for(int j :cicque.vectexList){
                if( edgeArr[vList.get(i)][j] == 1){
                    eCount ++;
                }
            }

        }
        eCount += countEdge1(vList1);

        return eCount;
    }

    public static int countE(Cicque[] cicque){
        int eCount = cicque[0].edgeCount+cicque[1].edgeCount;
        for(int i :cicque[0].vectexList){
            for(int j :cicque[1].vectexList){
                if( edgeArr[i][j] == 1){
                    eCount ++;
                }
            }
        }

        return eCount;
    }

    public static int countsubE(int j){
        List<Integer> vList = new ArrayList<>();
        Cicque c = CliqueList.get(getCliqueIndex(j));
        for(int i = 0 ;i<c.vectexCount;i++){
            if(c.vectexList[i] != j){
                vList.add(c.vectexList[i]);}
        }
//       int eCount = countEdge2(vList);
        int eCount = c.edgeCount;
        for(int i :vList){
            if(edgeArr[j][i] == 1){
                eCount--;
            }
        }
        return eCount;
    }


    public static double averageDev(){
        double totalDev = 0;
        for(Cicque v :CliqueList){
            totalDev+=v.gamma;

        }
        return totalDev/CliqueList.size();
    }



    public static void move(int chooseVectex,int chooseClique){
        int subClique = cList11[chooseVectex];

        int[] VList = getRemoveVList(chooseVectex);
        if(VList.length > 0){
            CliqueList.get(subClique).edgeCount = countsubE(chooseVectex);
            CliqueList.get(subClique).vectexList = VList;
            CliqueList.get(subClique).vectexCount = VList.length;
            int eCount1 = CliqueList.get(subClique).edgeCount;
            int vCount1 = CliqueList.get(subClique).vectexCount;
            double dev1 = Gamma(vCount1,eCount1);
//
            CliqueList.get(subClique).gamma=dev1;
            addVectex(CliqueList.get(chooseClique), chooseVectex);
        }else{
//
            addVectex(CliqueList.get(chooseClique), chooseVectex);
            CliqueList.remove(subClique);
            updateIndex();
        }

    }

    public static int[] findfirstVectex(){

        List<Integer> result = new ArrayList<>() ;
        for (Cicque clique : CliqueList) {
            for (int vectex : clique.vectexList) {
                if(tabulist[vectex] > totalIter){
                    continue;
                }
                double checkDev = removeGamma(vectex);
                if ((checkDev >= gamma)&&(ifVCanMove(vectex))){
                    result.add(vectex);
                }
            }
        }

        int[] moveList = new int[result.size()];
        int m = 0;
        for (int v : result) {

            moveList[m] = v;
            m += 1;
        }
        return moveList;

    }



    public static int[] findfirstVectex1(){

        List<Integer> result = new ArrayList<>() ;
        for (Cicque clique : CliqueList) {
            for (int vectex : clique.vectexList) {

                double checkDev = removeGamma(vectex);
                if ((checkDev >= gamma)&&(ifVCanMove(vectex))){
                    result.add(vectex);
                }
            }
        }

        int[] moveList = new int[result.size()];
        int m = 0;
        for (int v : result) {

            moveList[m] = v;
            m += 1;
        }
        return moveList;

    }

    public static int getCliqueIndex(int v){

        int subClique = 10000000;
        for (Cicque c : CliqueList) {
            for (int vectex : c.vectexList) {
                if (vectex == v) {
                    subClique = c.index;
                    break;
                }
            }
        }


        return subClique;
    }
    public static void updateCliqueIndex(){
//
        for(Cicque c :CliqueList){
            for(int v :c.vectexList){
                cList11[v] = c.index;
//
            }
        }

    }

    public static int chooseClique1(int v){
        int getCliqueIndex = 1000000;
        Cicque[] canMoveClique = canRemoveCList(v);
        double[] changevalue1 = new double[canMoveClique.length];
//

        double MAXvalue = -10000;
        int mk =0;
        for(Cicque clique :canMoveClique){
            double changevalue = clique.edgeCount- swapArr_1[v][clique.index];
//            double dev = Gamma(clique.vectexCount+1,eCount1);
            changevalue1[mk] = changevalue;
//            devList[mk] = dev;
            if(changevalue >  MAXvalue){
                MAXvalue = changevalue;
            }
            mk++;
        }
        List<Integer> LL = new ArrayList<>();
        double maxDev = -100000;
        int devIndex = 100000;

        for(int i =0; i < canMoveClique.length;i++ ){
            if((changevalue1[i] ==  MAXvalue)){
                LL.add(canMoveClique[i].index);
            }
        }

        getCliqueIndex = LL.get(r.nextInt(LL.size()));

        return getCliqueIndex;
    }

    public static double removeGamma(int v){
//        int[] TestList = getRemoveVList(v);
        int Cindex = getCliqueIndex(v);
        int eCount =CliqueList.get(Cindex).edgeCount- swapArr_1[v][Cindex];
//        int eCount = countsubE(v);
//        int vCount = TestList.length;
        int vCount = CliqueList.get(Cindex).vectexCount - 1;
        if(vCount==0){
            return 1;
        }else {
            return Gamma(vCount,eCount);
        }

    }

    public static int[] getRemoveVList(int v){
        int cliqueIndex = getCliqueIndex(v);
        int[] TestList;
        Cicque clique =  CliqueList.get(cliqueIndex);
        if(clique.vectexList.length==1){
          TestList =new int[]{};
        }else{
            TestList = new int[clique.vectexList.length-1];
        int k=0;
        for (int vectex2 : clique.vectexList) {
            if ( vectex2 != v ) {
                TestList[k] = vectex2;
                k += 1;
            }
        }
    }
        return TestList;
    }

    public static Cicque[] canRemoveCList(int v){
//            long t1 = System.currentTimeMillis();
        List<Cicque> canMoveClique =new ArrayList<>();
        int nkn = 0;

        for (Cicque clique : CliqueList) {
            double dev =Gamma(clique.vectexCount+1,swapArr_1[v][clique.index]+clique.edgeCount);
            if ((dev >= gamma)&&(cList11[v]!=clique.index)){
                canMoveClique.add(clique) ;
                nkn += 1;
            }
        }
//            long t2 = System.currentTimeMillis();
        Cicque[] resultList =new Cicque[canMoveClique.size()];
        int k =0;
        for(Cicque C:canMoveClique){
            resultList[k]=C;
            k++;
        }

        return   resultList;
    }

    public static double Gamma(int vCount,int eCount){
        double a = (2 * eCount);
        double b = (vCount * (vCount - 1));
        double dev;
        if((b==0)){
            dev=1.0;
        } else{
            dev= a/b;
        }
        return dev;
    }

    public static int CountIntersect(Cicque c1,Cicque c2){
        int Count =0;
        for(int v1 :c1.vectexList){
            Count = Count +swapArr_1[v1][c2.index];
        }
        return Count;
    }
    public static List<Cicque> CloneCList(List<Cicque> list1){
        List<Cicque> list2 = new ArrayList<>();
        list1.forEach(user->{
                    try {
                        list2.add(user.clone());
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }

                });
                return list2;
                }

    public static boolean checkGamma(){
         boolean flag1 = true;
         for(Cicque cicque:CliqueList){
             if(cicque.gamma < gamma){
                 flag1 = false;
                 break;
             }
         }
            return flag1;
     }

    public static Cicque[] resultList(){
        turbon_result_flag = 0;
        int size = CliqueList.size();
        int[][] valueArr = new int[size][size];
        int maxvalue = -100000;
        int[] indexList = new int[2];
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(i<j){
                   Cicque[] clist = {CliqueList.get(i),CliqueList.get(j)};
                   int ecount = countE(clist);
                    valueArr[i][j] = valueArr[j][i]= ecount - clist[0].edgeCount-clist[1].edgeCount;
                    if(ecount > maxvalue){
                        maxvalue = ecount;
                        indexList[0] = i;
                        indexList[1] = j;
                    }
                }
            }
        }

        return new Cicque[]{CliqueList.get(indexList[0]),CliqueList.get(indexList[1])};
    }

    public static void turbon1(){
        if(checkEnd()){
            return;
        }

        localSearch(endIter1);

        Cicque[] clist= resultList();
        int[] vList = getList3(clist);
        for(Cicque c : clist){
            CliqueList.remove(c);
            updateIndex();
        }

        insert1(sort_max(vList));
        if(objCount() < fbest){
            printTime();
            bestCliqueList = CloneCList(CliqueList);
            fbest = objCount();
            objtime = System.currentTimeMillis();
            bestCounter = totalIter;
        }

    }

    public static void turbon(Cicque[] clist){
        if(checkEnd()){
            return;
        }
        List<Cicque> CliqueList1 = CloneCList(CliqueList);
        int originObj = CliqueList1.size();
        int[] vList = getList3(clist);
        double averageDev0 = averageDev();
        for(Cicque c : clist){
          CliqueList.remove(c);
            updateIndex();
        }
        insert1(sort_max(vList));
        if(objCount() < fbest){
            printTime();
            bestCliqueList = CloneCList(CliqueList);
            fbest = objCount();
            objtime = System.currentTimeMillis();
            bestCounter = totalIter;

        }
        localSearch(endIter1);


   }
    //






//-------------------------------------------------------------------
public static Cicque nonMoveVClique(){

    int minValue = 10000;
    Cicque C = null;
    int[] valueList = new int[CliqueList.size()];
    int k = 0;
    for(Cicque c:CliqueList){
        int value = 0;
        for(int v:c.vectexList){
            if(ifVCanMove(v)){
                value++;
            }
        }
        int nonvalue = c.vectexCount - value;
        valueList[k] = nonvalue;
        if(nonvalue < minValue){
            minValue = nonvalue;
            C = c;
        }
        k++;
    }
    List<Integer> LL = new ArrayList<>();
    for(int j =0; j < k;j++){
        if(valueList[j] == minValue){
            LL.add(j);
        }
    }
    C = CliqueList.get(LL.get(r.nextInt(LL.size())));
    return C;
}
    //
    public static Cicque nonMoveVClique2(){
        //
        int minValue = 10000;
        Cicque C = null;
        for(Cicque c:CliqueList){
            int value = 0;
            for(int v:c.vectexList){
                if(ifVCanMove(v)){
                    value++;
                }
            }
            int nonvalue = c.vectexCount - value;
            if(nonvalue < minValue){
                minValue = nonvalue;
                C = c;
            }
        }
        return C;
    }

    //
    public static Cicque nonMoveVClique1(){
        //

        return   CliqueList.get(r.nextInt(CliqueList.size()));
    }



    //
    public static List<Integer> getnonVList(){
        List<Integer> VList = new ArrayList<>();
        for(Cicque c:CliqueList){
            if(c.gamma < gamma){
                for(int v : c.vectexList){
                    VList.add(v);
                }
            }
        }
        return VList;
    }
    //
    public static boolean ifVCanMove(int v){
        boolean fff = false;
        for (Cicque clique : CliqueList) {
            double dev = Gamma(clique.vectexCount+1,clique.edgeCount+swapArr_1[v][clique.index]);
            if ((countEV(clique, v) >= gamma)&&(cList11[v]!=clique.index)) {
                fff = true;
                break;
            }
        }
        return fff;
    }

    public static Cicque testV(int v){

        int maxvalue1 = -1111000;
        int maxvalue2 = -1111000;
        int[] valueList = new int[CliqueList.size()];
        int bigIndex = 100000;
        boolean moveFlag = false;
//
        List<Cicque> CList1 = new ArrayList<>();
//
        List<Cicque> CList2 = new ArrayList<>();
        Cicque result1 = null;
        Cicque result2 = null;
        int Cindex = cList11[v];
        int k =0;
        for( Cicque c:CliqueList){
            if((c.index!=Cindex)){

                valueList[k] = swapArr_1[v][c.index];
                    //
                if(Gamma(c.vectexCount+1,countE(c,v))>=gamma){
                    moveFlag = true;
                    if(maxvalue1 < valueList[k]){
                        maxvalue1 = valueList[k];
                        result1 = c;
                    }
                }else{
                    if(maxvalue2 < valueList[k]){
                        maxvalue2 = valueList[k];
                        result2 = c;
                    }
                }
            }
            k++;
        }
        if(moveFlag){
            return result1;
        }else{
           return result2;
        }

    }



    public static int testBreakOne(List<Cicque> CliqueList1,int endIter){

        Countedge();
        tabulList3 = new int[vLength][CliqueList.size()];
        tabulist4 = new int[vLength];
        Cicque moveC = nonMoveVClique();
        CliqueList.remove(moveC);
        updateIndex();
        List<Integer> tempVList = new ArrayList<>();
        for(int v : moveC.vectexList){
            tempVList.add(v);
        }
        int testIter =0;
        int maxIter = endIter;
        tempVList =testaddOne(tempVList);
        Countedge(tempVList);
        while ((tempVList.size()>0)&&(testIter<maxIter)){
            if(checkEnd()){
                break;
            }
            testIter++;
            ITER++;
            IterNum1++;

            updateCliqueIndex();
            int Count =0;
            int maxvalue =-10000;
            int VIndex =100000;
            int moveCIndex =100000;
            //
            int[] moveList = findfirstVectex1();
            for(int v :moveList){
                if(tabulist4[v] > testIter){
                    continue;
                }
                Cicque C = CliqueList.get(cList11[v]);
                int unCount =0;
                unCount =C.vectexCount -swapArr_1[v][C.index];
                for(Cicque c3 : canRemoveCList(v)){

                    if(c3.index==C.index){
                        continue;
                    }
                    int uncount1 =0;
                    uncount1 = c3.vectexCount-swapArr_1[v][c3.index];

                    int value = (-C.vectexCount+1 + unCount) + c3.vectexCount-uncount1;
                    if(value > maxvalue){
                        Count ++;
                        maxvalue = value;
                        VIndex =v;
                        moveCIndex = c3.index;
                    }
                }
            }

            if(Count>0){
                int tempCount = CliqueList.get(cList11[VIndex]).vectexCount;
                List<Cicque> ChangeCList =new ArrayList<>();
                if(tempCount==1){
//
                    ChangeCList.add(CliqueList.get(moveCIndex));
                }else{

                    ChangeCList.add(CliqueList.get(cList11[VIndex]));
                    ChangeCList.add(CliqueList.get(moveCIndex));
                }
                updateTabul();
                tabulist4[VIndex] = testIter + Tabul;
                move(VIndex,moveCIndex);
                if(tempCount==1){
                    Countedge(tempVList);
                }else{

                    for(int k =0;k<vLength;k++){
                        swapArr_1[k][cList11[VIndex]] -= edgeArr[VIndex][k];
                        swapArr_1[k][moveCIndex] += edgeArr[VIndex][k];
                    }
                    updateCliqueIndex();
                }
                tempVList =testaddOne1(tempVList,ChangeCList);

            }
        }
        if((tempVList.size() == 0)){
//

            if(objCount() < fbest){
                printTime();
//
                bestCliqueList = CloneCList(CliqueList);
                fbest = objCount();
                objtime = System.currentTimeMillis();
                bestCounter = totalIter;

            }
        }else{
            if(tempVList.size()+CliqueList.size()<CliqueList1.size()){
//
                for(int v8 :tempVList){
                    makeSingleElement(v8);
                }
                if(objCount() < fbest){
//
                    printTime();
                    bestCliqueList = CloneCList(CliqueList);
                    fbest = objCount();
                    objtime = System.currentTimeMillis();
                    bestCounter = totalIter;

                }
                testIter = endIter + 1;
            }else{
                CliqueList = CloneCList(CliqueList1);
                if(objCount() < fbest){
                    printTime();
                    bestCliqueList = CloneCList(CliqueList);
                    fbest = objCount();
                    objtime = System.currentTimeMillis();
                    bestCounter = totalIter;

                }
            }
        }

        return testIter;
    }

    public static List<Integer> testaddOne(List<Integer> VL){
        boolean Vflag = true;
        while(Vflag){
            int count =0;
            for(int v =0;v< VL.size();v++){
                int index1 = ifVCanMove1(VL.get(v));
                if(index1>-1){
                    count ++;
                    Cicque c = CliqueList.get(index1);

                    addVectex(c,VL.get(v));
                    VL.remove(VL.get(v));
                }
            }
            if(count==0){
                Vflag =false;
            }
        }     return VL;
    }
    public static List<Integer> testaddOne1(List<Integer> VL,List<Cicque> CList){
        boolean Vflag = true;
        while(Vflag){
            int count =0;
            for(int v =0;v< VL.size();v++){
                int index1 = ifVCanMove2(VL.get(v),CList);
                if(index1>-1){
                    count ++;
                    Cicque c = CliqueList.get(index1);
                    for(int k =0;k<vLength;k++){
                        swapArr_1[k][index1] += edgeArr[VL.get(v)][k];
                    }
                    addVectex(c,VL.get(v));
                    updateCliqueIndex();
                    VL.remove(VL.get(v));
                }
            }
            if(count==0){
                Vflag =false;
            }
        }     return VL;
    }



    public static int ifVCanMove1(int v){
        boolean fff = false;
        int index = 100000;
        int maxValue = -10000;
        for (Cicque clique : CliqueList) {
            if ((countEV(clique, v) >= gamma)) {
                if(clique.vectexCount>maxValue){
                    maxValue = clique.vectexCount;
                    index = clique.index;
                }
                fff = true;
//                break;
            }
        }
        if(fff){
            return index;
        }else {
            return -100;
        }

    }


    public static int ifVCanMove2(int v,List<Cicque> Clist){
        boolean fff = false;
        int index = 100000;
        int maxValue = -10000;
        for (Cicque clique : Clist) {
            if ((countEV(clique, v) >= gamma)&&(cList11[v]!=clique.index)) {
                if(clique.vectexCount > maxValue){
                    maxValue = clique.vectexCount;
                    index = clique.index;
                }
                fff = true;
//                break;
            }
        }
        if(fff){
            return index;
        }else {
            return -100;
        }

    }



    public static void main(String[] args) throws IOException {
    try {
        List<String> testList = List.of(new String[]{"p-hat500-1.mtx", "san1000.mtx",
                "polblogs.mtx", "494_bus.mtx", "662_bus.mtx", "bcsstk13.mtx", "soc-hamsterster.edges",
                "email.edges", "email-dnc-corecipient.edges", "data.mtx"
        });
//------------------------------------------------------------------------
        // trim 0.999-0.3
        List<String> newtrim = List.of(new String[]{"Attiro.paj", "mexican.paj", "SanJuanSur.paj", "Sawmill.net", "Memento.txt"
                ,"the_x_files.txt","Alien_3.txt","Batman_Returns.txt",});
        // prison 0.999-0.3
        List<String> read_prison = List.of(new String[]{"prison.txt",});
        // min 0.999-0.3
        List<String> minList_small = List.of(new String[]{"myciel6.txt","david.txt", "anna.txt", "4-FullIns_3.txt", "3-FullIns_3.txt", "jean.txt",});
        // max 0.999-0.3
        List<String> maxList_small = List.of(new String[]{"high-tech.txt", "soc-dolphins.mtx", "chesapeake.mtx", "karate.mtx"});
//------------------------------------------------------------------------------------------
        // max 0.999-0.3
        List<String> maxList_Spare = List.of(new String[]{"494_bus.mtx", "polblogs.mtx", "bcsstk13.mtx", "soc-hamsterster.edges", "662_bus.mtx",
                "email.edges", "email-dnc-corecipient.edges", "data.mtx",});
        //  max  0.999-0.3
        List<String> maxList_dense_9 = List.of(new String[]{
                "p-hat500-1.mtx", "p-hat1000-1.mtx", "p-hat1500-1.mtx",});
        //  max  0.999-0.6
        List<String> maxList_dense_6 = List.of(new String[]{
                "san1000.mtx", "p-hat500-2.mtx", "p-hat1000-2.mtx", "p-hat1500-2.mtx", "C2000-5.mtx"});
        //  max  0.999-0.7
        List<String> maxList_dense_5 = List.of(new String[]{"brock800-3.mtx"});
        //  max  0.999-0.8
        List<String> maxList_dense_4 = List.of(new String[]{"p-hat500-3.mtx", "p-hat1000-3.mtx", "p-hat1500-3.mtx", "keller5.mtx"});
        int gammaCount = 0;
        readType =0;
        String ss = args[0];
        String[] testParam = ss.split("/");

        String t = testParam[2];
        //new
//        String t= ss;

        if(maxList_dense_4.contains(t)){
            gammaCount = 3 ;
        } else if (maxList_dense_5.contains(t)) {
            gammaCount = 2;
        } else if (maxList_dense_6.contains(t)) {
            gammaCount = 1;
        } else if (maxList_Spare.contains(t)) {
            endIter1 = 1500;
            localjump = 1500;
            stopTime =500;
        } else if (minList_small.contains(t)) {
            readType =1;
        } else if (newtrim.contains(t)) {
            readType=2;
        } else if (read_prison.contains(t)) {
            readType=3;
        }

        String outputFile =args[1];
        File file = new File(outputFile);
        if (!file.exists()) {
            file.createNewFile();
        }


        BufferedWriter fileWritter = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (file), StandardCharsets.UTF_8));

        fileWritter.flush();
        fileWritter.write("");
        String data = "     Tabul     fliename          i    gamma    improve_Obj    ttb          totalIters       totalTime            " + "\r\n";
        fileWritter.append(data);
//        System.out.println(data);
        fileWritter.flush();
//        double outerGamma = Double.parseDouble(args[2]);



        double[] test = {0.999,0.95,0.9,0.8,0.7,0.60,0.5,0.4,0.3};
        int[] gammaList = {9, 6, 5,4};
        for(int g = 0;g<1;g++){
            f = ss;
            for (int i = 0; i < gammaList[gammaCount]; i++) {
//                for (int i = 0; i < 1; i++) {
                for (int in=0;in<10;in++){
                    stime = System.currentTimeMillis();
                    instailial();
                    if(vLength<200){
                        stopTime=300;
                        endIter1 = 1500;
                        localjump = 1500;
                        maxtotalIter=1000000000;
                    }
                    String flagType = args[2];
                    tabulFlag =2;
                    endIter1 =  10000;
                    localjump = 5000;
                    if(flagType=="0"){
                        tabulFlag = Integer.parseInt(args[3]);
                    } else if (flagType=="1") {
                        endIter1 =  Integer.parseInt(args[3]);
                    } else if (flagType == "2") {
                        localjump =  Integer.parseInt(args[3]);
                    }else {

                    }
                    SwapT=0;
                    firstWay(test[i]);
                    String data0 = String.valueOf(test[i]);
                    improve();

                    etime = System.currentTimeMillis();
                    String data7 = String.valueOf(0.001*( etime - stime));
                    String data2 = String.valueOf(fbest);
                    String data4 = String.valueOf( (objtime - stime) * 0.001);
                    String data5 = String.valueOf(Tabul);
                    String data6 = String.valueOf(ITER);
                    String data3 = "      " + data5 + "     " + t.split("[.]")[0] + "     " + (in + 1) + "     " + data0 + "       " + data2 + "         " + data4 + "            " + data6 + "       "+data7+"    " + "\r\n";
//                    System.out.println(data3);
                    fileWritter.write(data3);
                    fileWritter.flush();
                }
            }}
            fileWritter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

























