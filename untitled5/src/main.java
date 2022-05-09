import java.util.*;
import java.util.Stack;

public class main {
    public static Queue<String> q = new LinkedList<>();
    public static int c =0;
    Scanner sc=new Scanner(System.in);
    public static Stack<String> stack = new Stack<>();
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    static HashMap<String, String> map = new HashMap<>();
    static HashMap<String, Integer> map2 = new HashMap<>();
    static List<String> list=new ArrayList<String>();
    static HashMap<String,Integer> map3 = new HashMap<>();
    static List<String> l = new ArrayList<String>();
    static List<String> vn = new ArrayList<String>();
    static Set<String> ll = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        System.out.print("for eucliden A* Enter number 2 ");
        System.out.print("for manshter A* Enter number 3 ");
        System.out.print("for dfs Enter numberb 1 ");
        System.out.print("for bfs Enter numberb 0 ");
        int a= sc.nextInt();
        String s = "312045678";
        q.add(s);
        stack.push(s);
        ll.add(s);
       //
        int h=0,m;
        map2.put(s,0);
        minHeap.add(0);
        map3.put(s,0);
    if(a==2 ||a==3)   {
        long startTime = System.nanoTime();
        while (!minHeap.isEmpty())
        {  m=minHeap.remove();
            String current=getKey(map3,m);
           map3.remove(current,m);
           vn.add(current);
       //    System.out.println(m+"iam out "+current);
            if(current.equals("012345678")) {
               list.add("012345678");
                while (map.containsKey(current)) {
                   list.add(map.get(current));
                    current= map.get(current);  }

                for(int i=list.size()-1;i>=0;i--)
                    System.out.println(list.get(i));
                System.out.println("visted nodes :");
                for(int i=0;i<=vn.size()-1;i++)
                    System.out.println(vn.get(i));
                System.out.println("depth is "+(list.size()-1));
                System.out.print("cost is "+(list.size()-1));
              break;
            }
            int index=current.indexOf('0');
            addtoheap(current,index,a);
         //  System.out.println(map3);


        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("runing time is "+totalTime);}

      if(a==0){long startTime = System.nanoTime();
          while (!q.isEmpty())
        {
            String current = q.remove();
            vn.add(current);
            if(current.equals("012345678"))
            {
                list.add("012345678");
                while (map.containsKey(current)) {
                    list.add(map.get(current));
                    current= map.get(current);  }
                for(int i=list.size()-1;i>=0;i--)
                    System.out.println(list.get(i));
                System.out.println("visted nodes :");
                for(int i=0;i<=vn.size()-1;i++)
                    System.out.println(vn.get(i));
                System.out.println("depth is "+(list.size()-1));
                System.out.print("cost is "+(list.size()-1));
                break;
            }
            int index=current.indexOf('0');
            addtoq(current,index);
        }
          long endTime   = System.nanoTime();
          long totalTime = endTime - startTime;
          System.out.println("runing time is "+totalTime);
      }
    if(a==1){long startTime = System.nanoTime();
        while (!stack.isEmpty())
        {
            String current=stack.pop();
            vn.add(current);
            if(current.equals("012345678"))
            {

                list.add("012345678");
                while (map.containsKey(current)) {
                    list.add(map.get(current));
                    current= map.get(current);  }

                for(int i=list.size()-1;i>=0;i--)
                    System.out.println(list.get(i));
                System.out.println("visted nodes :");
                for(int i=0;i<=vn.size()-1;i++)
                    System.out.println(vn.get(i));
                System.out.println("depth is "+(list.size()-1));
                System.out.print("cost is "+(list.size()-1));
                break;
            }
            int index=current.indexOf('0');
            addtostack(current,index);

        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("runing time is "+totalTime);}



    }
   public static <K, V> K getKey(Map<K, V> map, V value)
    {
        for (Map.Entry<K, V> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    private static void addtoheap(String current, int index,int a) {
        int h;
        //move up
        if(index!=0&&index!=1&&index!=2)
        {

            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index-3));
            current1.setCharAt(index-3,'0');

            if(!ll.contains(String.valueOf(current1)))
            {
                c++;
                ll.add(String.valueOf(current1));
                if(a==2)
                 h=clac2(current1);
                else
                     h=clac(current1);
                map.put(String.valueOf(current1),current);
                map2.put(String.valueOf(current1),map2.get(current)+1);
                int g=map2.get(current)+1;
                map3.put(String.valueOf(current1),g+h);
              // System.out.println((g+h)+"       "+String.valueOf(current1));
                minHeap.add(g+h);
              //  System.out.println(map3);
            }
        }
        //move down
        if(index!=6&&index!=7&&index!=8)
        {
            c++;
            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index+3));
            current1.setCharAt(index+3,'0');

            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                if(a==2)
                    h=clac2(current1);
                else
                    h=clac(current1);
                map2.put(String.valueOf(current1),map2.get(current)+1);
                int g=map2.get(current)+1;
                map.put(String.valueOf(current1),current);
                map3.put(String.valueOf(current1),g+h);
               // System.out.println((g+h)+"       "+String.valueOf(current1));
                minHeap.add(g+h);
          //  System.out.println(map3);
            }
        }
        //move left
        if(index!=0&&index!=6&&index!=3)
        {
            c++;
            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index-1));
            current1.setCharAt(index-1,'0');

            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                if(a==2)
                    h=clac2(current1);
                else
                    h=clac(current1);
                map2.put(String.valueOf(current1),map2.get(current)+1);
                int g=map2.get(current)+1;
                map.put(String.valueOf(current1),current);
                map3.put(String.valueOf(current1),g+h);
                //System.out.println((g+h)+"       "+String.valueOf(current1));
                minHeap.add(g+h);
               // System.out.println(map3);
            }
        }
        //move right
        if(index!=2&&index!=5&&index!=8)
        {

            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index+1));
            current1.setCharAt(index+1,'0');

            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                if(a==2)
                    h=clac2(current1);
                else
                    h=clac(current1);
                map2.put(String.valueOf(current1),map2.get(current)+1);
                int g=map2.get(current)+1;
                map.put(String.valueOf(current1),current);
                map3.put(String.valueOf(current1),g+h);
               // System.out.println((g+h)+"       "+String.valueOf(current1));
                minHeap.add(g+h);

            }
        }

    }

    private static int clac(StringBuilder s) {
        int h=0;
        for (int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)-'0'!=i)
            {
                int z=gettherealindx(s.charAt(i)-'0');
                int y=z/10;
                z=z/10;
                int x=z/10;
                if(i<=2)
                {
                    h=h+Math.abs(x)+Math.abs(i-y);
                }
                else if(i==3)
                {
                    h=h+Math.abs(1-x)+Math.abs(0-y);
                }

                else if(i==4)
                {
                    h=h+Math.abs(1-x)+Math.abs(1-y);
                }

                else if(i==5)
                {
                    h=h+Math.abs(1-x)+Math.abs(2-y);
                }

                else if(i==6)
                {
                    h=h+Math.abs(2-x)+Math.abs(0-y);
                }

                else if(i==7)
                {
                    h=h+Math.abs(2-x)+Math.abs(1-y);
                }

                else if(i==8)
                {
                    h=h+Math.abs(2-x)+Math.abs(2-y);
                }
            }
        }
        return h;
    }
    private static int clac2(StringBuilder s) {
        int h=0;
        for (int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i)-'0'!=i)
            {
                int z=gettherealindx(s.charAt(i)-'0');
                int y=z/10;
                z=z/10;
                int x=z/10;
                if(i<=2)
                {
                    h= (int) (h+Math.sqrt(Math.pow(x,2)+Math.pow(i-y,2)));
                }
                else if(i==3)
                {
                    h= (int) (h+Math.sqrt(Math.pow(1-x,2)+Math.pow(0-y,2)));
                }

                else if(i==4)
                {
                    h=(int) (h+Math.sqrt(Math.pow(1-x,2)+Math.pow(1-y,2)));
                }

                else if(i==5)
                {
                    h=(int) (h+Math.sqrt(Math.pow(1-x,2)+Math.pow(2-y,2)));
                }

                else if(i==6)
                {
                    h=(int) (h+Math.sqrt(Math.pow(2-x,2)+Math.pow(0-y,2)));
                }

                else if(i==7)
                {
                    h=(int) (h+Math.sqrt(Math.pow(2-x,2)+Math.pow(1-y,2)));
                }

                else if(i==8)
                {
                    h=(int) (h+Math.sqrt(Math.pow(2-x,2)+Math.pow(2-y,2)));
                }
            }
        }
        return h;
    }
    private static int gettherealindx(int i) {
        if(i==0)
            return 00;
        else if(i==1)
            return 01;
        else if(i==2)
            return 02;
        else if(i==3)
            return 10;
        else if(i==4)
            return 11;
        else if(i==5)
            return 12;
        else if(i==6)
            return 20;
        else if(i==7)
            return 21;
        else if(i==8)
            return 22;
        return 1;

    }

    private static void addtostack(String current, int index) {
        //move up
        if(index!=0&&index!=1&&index!=2)
        {

            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index-3));
            current1.setCharAt(index-3,'0');
            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                stack.push(String.valueOf(current1));
                map.put(String.valueOf(current1),current);
            }
        }
        //move down
        if(index!=6&&index!=7&&index!=8)
        {

            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index+3));
            current1.setCharAt(index+3,'0');
            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                stack.push(String.valueOf(current1));
                map.put(String.valueOf(current1),current);
            }
        }
        //move left
        if(index!=0&&index!=6&&index!=3)
        {
            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index-1));
            current1.setCharAt(index-1,'0');

            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                stack.push(String.valueOf(current1));
                map.put(String.valueOf(current1),current);
                //   System.out.println("hi"+String.valueOf(current1));
            }
        }
        //move right
        if(index!=2&&index!=5&&index!=8)
        {

            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index+1));
            current1.setCharAt(index+1,'0');
            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                stack.push(String.valueOf(current1));
                map.put(String.valueOf(current1),current);
            }
        }


    }

    private static void addtoq(String current, int index) {
       //move up
        if(index!=0&&index!=1&&index!=2)
        {

            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index-3));
            current1.setCharAt(index-3,'0');
            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                q.add(String.valueOf(current1));
                map.put(String.valueOf(current1),current);
            }
        }
        //move down
        if(index!=6&&index!=7&&index!=8)
        {

            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index+3));
            current1.setCharAt(index+3,'0');
            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                q.add(String.valueOf(current1));
                map.put(String.valueOf(current1),current);
            }
        }
        //move left
        if(index!=0&&index!=6&&index!=3)
        {
            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index-1));
            current1.setCharAt(index-1,'0');

            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                q.add(String.valueOf(current1));
                map.put(String.valueOf(current1),current);
             //   System.out.println("hi"+String.valueOf(current1));
            }
        }
        //move right
        if(index!=2&&index!=5&&index!=8)
        {

            StringBuilder current1 = new StringBuilder(current);
            current1.setCharAt(index,current.charAt(index+1));
            current1.setCharAt(index+1,'0');
            if(!ll.contains(String.valueOf(current1)))
            {
                ll.add(String.valueOf(current1));
                q.add(String.valueOf(current1));
                map.put(String.valueOf(current1),current);
            }
        }
    }
}
