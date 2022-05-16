import javax.swing.JLabel;
import java.awt.Color;

public class label extends JLabel{
    public label(String text){
        this.setText(text);
        this.setForeground(Color.LIGHT_GRAY);
        this.setVisible(true);
    }
}
