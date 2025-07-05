package Structural.DecoratorDesign.Java;



interface Text {
    String render();
}

class PlainText implements Text {

    String text;
    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
} 


abstract class TextDecorator implements Text {
    Text text;

    TextDecorator(Text text) {
        this.text = text;
    }
}

class BoldText extends TextDecorator {

    public BoldText(Text text) {
        super(text);
    }

    @Override
    public String render() {
        return "Bold" + text.render();
    }

}

class ItalicText extends TextDecorator {

    public ItalicText(Text text) {
        super(text);
    }

    @Override
    public String render() {
        // here the text is the previous text obj embeded
        return "Italic" + text.render();
    }

}

public class Main {

    public static void main(String[] args) {
        PlainText text = new PlainText("text");
        BoldText boldtext = new BoldText(text);
        ItalicText italicBoldText = new ItalicText(boldtext);
        System.out.println(italicBoldText.render());
    }
}