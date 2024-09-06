import java.awt.Font;

public class Function_Format {

    GUI gui;
    Font algerian, arial, cosmicSansMS, timesNewRoman, century, lucidaCalligraphy, scriptMTBold;
    String selectedFont;

    public Function_Format(GUI gui) {
        this.gui = gui;
    }

    public void wordWrap() {
        if (gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: On");
        } else if (gui.wordWrapOn == true) {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: Off");
        }
    }

    public void createFont(int fontSize) {
        algerian = new Font("Algerian", Font.PLAIN, fontSize);
        arial = new Font("Arial", Font.PLAIN, fontSize);
        cosmicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        century = new Font("Century", Font.PLAIN, fontSize);
        lucidaCalligraphy = new Font("Lucida Calligraphy", Font.PLAIN, fontSize);
        scriptMTBold = new Font("Script MT Bold", Font.PLAIN, fontSize);

        setFont(selectedFont);

    }

    public void setFont(String font) {
        selectedFont = font;

        switch (selectedFont) {
            case "Algerian":
                gui.textArea.setFont(algerian);
                break;
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(cosmicSansMS);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
            case "Century":
                gui.textArea.setFont(century);
                break;
            case "Lucida Calligraphy":
                gui.textArea.setFont(lucidaCalligraphy);
                break;
            case "Script MT Bold":
                gui.textArea.setFont(scriptMTBold);
                break;
        }
    }
}
