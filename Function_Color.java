import java.awt.Color;

public class Function_Color {

    GUI gui;

    public Function_Color(GUI gui) {
        this.gui = gui;
    }

    public void changeColor(String color) {
        switch (color) {
            case "White":
                setColors(Color.white, Color.black);
                break;
            case "Black":
                setColors(Color.black, Color.white);
                break;
            case "Cyan":
                setColors(Color.cyan, Color.black);
                break;
            case "LightYellow":
                setColors(new Color(255, 255, 153), Color.black);
                break;
            case "Pink":
                setColors(Color.pink, Color.black);
                break;
            case "Grey":
                setColors(Color.gray, Color.black);
                break;
            case "LightGreen":
                setColors(new Color(144, 238, 144), Color.black);
                break;
            case "Peach":
                setColors(new Color(255, 218, 185), Color.black);
                break;
        }
    }

    private void setColors(Color backgroundColor, Color foregroundColor) {
        gui.window.getContentPane().setBackground(backgroundColor);
        gui.textArea.setBackground(backgroundColor);
        gui.textArea.setForeground(foregroundColor);
    }
}
