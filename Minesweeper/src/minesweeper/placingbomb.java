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
public class placingbomb 
{
    public static void main(String []args)
    {
        int [][] Buttonvalue=new int[10][10];
        int i,j,k;
        int x=7,y=0;
        for(k=0;k<10;k++)
        {
        i=(int)(10*Math.random());
        j=(int)(10*Math.random());
        while((i==x&&j==y) || Buttonvalue[i][j]==-1)
        {
             i=(int)(10*Math.random());
             j=(int)(10*Math.random());
        }
        Buttonvalue[i][j]=-1;
        }
        for(i=0;i<10;i++)
        {
            for(j=0;j<10;j++)
            {
                System.out.print(Buttonvalue[i][j]);
            }
            System.out.println();
        }
    }
}
