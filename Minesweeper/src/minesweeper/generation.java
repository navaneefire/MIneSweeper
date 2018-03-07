/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

/**
 *
 * @author Navaneethakrishnan S
 */
public class generation {
    public static void add(String []args)
    {
        int [][]a=new int[10][10];
        int i,j;
        int x=3,y=4;
        for(int k=0;k<10;k++)
        {
            do
            {
              i=(int)(10*Math.random());
               j=(int)(10*Math.random());
            }
            while((i==x&&j==y) || a[i][j]==-1);
            a[i][j]=-1;
        }
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
                if(a[i][j]==-1)
                System.out.print(1+" ");
            else
                    System.out.print(0+" ");
            System.out.println();
        }
        System.out.println('\n');
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
            {
                int k,l,count=0;
                char c=' ';
                if(a[i][j]==-1)
                {
                    System.out.print('b'+" ");
                    continue;
                }
                for(k=i-1;k<i+2;k++)
                {
                    for(l=j-1;l<j+2;l++)
                    {    if(k>=0&&k<10&&l>=0&&l<10)
                            if(a[k][l]==-1)
                                count+=1;
                    }
                }
                if(count!=0)
                System.out.print(count+" ");
                else
                    System.out.print(0+" ");
            }
            System.out.println();
        }
    }
    
}
