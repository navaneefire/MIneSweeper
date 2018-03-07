/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Navaneethakrishnan S
 */
public class Sweeperframe extends JFrame 
{
    int count1=0;
     JToggleButton[][] Button=new JToggleButton[10][10];
     int height;
     int width;
     boolean first;
     int[][] Buttonvalue =  new int[10][10]; 
     int[][] matrix=new int[10][10];
     ActionListener Listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                int i,j;
                int x=-1,y=-1;
              for(i=0;i<height;i++)
              {
                  for(j=0;j<width;j++)
                {
                    if(Button[i][j]==e.getSource())
                    {
                       x=9-i;
                       y=j;   
                    }
                }
              }
            if(first==true)
            {
                placebomb(x,y);
                first=false;
            }
            if(Buttonvalue[x][y]==-1)
            {
                count1++;
                Button[9-x][y].setSelected(true);
                Button[9-x][y].setText("bomb");
                setVisible(false);
                dispose();
                JOptionPane.showMessageDialog(null,"you lost","game over",JOptionPane.INFORMATION_MESSAGE);
            }
            else
              open(x,y);
            }
        };
    
    /**
     * Creates new form Sweeperframe
     */
    public Sweeperframe() 
    {
        int i,j;
        height=10;
        width=10;
        first=true;
        initComponents();
        for(i=0;i<height;i++)
        {
            for(j=0;j<width;j++)
            {
                Buttonvalue[i][j]=0;
                Button[i][j]=new JToggleButton();
                jPanel1.add(Button[i][j]);
                Button[i][j].setSize(jPanel1.getWidth()/width,jPanel1.getHeight()/height);
                Button[i][j].setLocation(j*jPanel1.getWidth()/width,i*jPanel1.getHeight()/height);
                Button[i][j].addActionListener(Listener);
            }
        } 
    }
    public void open(int x,int y)
    {
        int i,j;
        Button[9-x][y].setSelected(true);
        count1++;
        if(matrix[x][y]==0)
        {
           for(i=x-1;i<x+2;i++)
        {
            for(j=y-1;j<y+2;j++)
            {
                if(i>=0&&i<10&&j>=0&&j<10)
                    if(i!=x || j!=y)
                    if(!Button[9-i][j].isSelected())
                    open(i,j);
            }
        } 
        }
        else
        {
            Button[9-x][y].setText(""+matrix[x][y]);
        }
        if(count1==90)
        {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(false);
            dispose();
            JOptionPane.showMessageDialog(null,"you won","game over",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void placebomb(int x,int y)
    {
        int i,j,k;
        
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
                int l,count=0;
                if(Buttonvalue[i][j]==-1)
                {
                    matrix[i][j]=10;
                    continue;
                }
                for(k=i-1;k<i+2;k++)
                {
                    for(l=j-1;l<j+2;l++)
                    {    if(k>=0&&k<10&&l>=0&&l<10)
                            if(Buttonvalue[k][l]==-1)
                                count+=1;
                    }
                }
                matrix[i][j]=count;        
            }
        }
    }    
    private void resizing()
    {
        int i,j;
        for(i=0;i<height;i++)
        {
            for(j=0;j<width;j++)
            {
               Button[i][j].setSize(jPanel1.getWidth()/width,jPanel1.getHeight()/height);
                Button[i][j].setLocation(j*jPanel1.getWidth()/width,i*jPanel1.getHeight()/height);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
            resizing();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentResized

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sweeperframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sweeperframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sweeperframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sweeperframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sweeperframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
