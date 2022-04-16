import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt. FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.Font;




public class Imageoperation {
    public static void operate(int key){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();//file will get selected which user wants
        //read the data from file
        
       
       
       
        try {
            FileInputStream fis=new FileInputStream(file);
            byte[] data=new byte[fis.available()];//image will get read & is converted in byte(number)
            fis.read(data);
            int i=0;
            for(byte b:data){
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }//encrytp every value using xor;
        



        
            FileOutputStream fos =new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close(); 
        
            JOptionPane.showMessageDialog(null,"Done" );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    


    public static void main(String[] args) {
        System.out.println("Symmetric Encryption : ");
        JFrame f=new JFrame();
        f.setTitle("image operation");
    
        f.setSize(400,400);
    
        f.setLocationRelativeTo(null);
    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        f.setVisible(true);
    
        
        
        //creating button
        Font font=new Font("Roboto",Font.BOLD,25);
    
        JButton button=new JButton();
        button.setText("Open Image");
        button.setFont (font);
        

        //creating text field
      
      
        JTextField textField=new JTextField(10);
        textField.setFont(font);
    
        button.addActionListener(e->{
            System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp); 
        });//(function called succesfully )
    
    
       
       
        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.setVisible(true);
    }//after making gui there should be function call(1)
    
}
