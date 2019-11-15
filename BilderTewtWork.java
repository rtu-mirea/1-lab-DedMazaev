package com.company;

public class BilderTewtWork {
    private StringBuilder text;
    private int indOfPar = 0;

    public void inputText(StringBuilder Text) {
        text = Text.append('\n');
    }

    public StringBuilder getText() {
        return text;
    }

    public void paragraphSegmentation() {
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!') {
                text.setCharAt(i + 1, '\n');
                i++;
                indOfPar++;
            }
        }
    }

    private StringBuilder toUpperParagraph(int a, int b){
        StringBuilder str = new StringBuilder(text.substring(a, b));
        String buf = "";
        int start = 0, end;
        end = str.indexOf(" ");
        start = str.lastIndexOf(" ");
        buf += str.substring(0, end).toUpperCase()+ str.substring(end, start) + str.substring(start).toUpperCase();

        return new StringBuilder(buf);
    }

    public void toUpperWords(){
        StringBuilder buf = new StringBuilder();
        int parArr[] = new int[indOfPar + 1];
        parArr[0] = 0;
        for (int i = 0, n = 1; i < text.length() && n < parArr.length; i++){
            if (text.charAt(i) == '\n'){
                parArr[n] = i;
                n++;
            }
        }
        for (int i = 0; i < parArr.length - 1; i++){
             buf.append(toUpperParagraph(parArr[i], parArr[i+1]));
        }
        //text = buf + '\n';
        text = buf.append('\n');
    }

    public void paragraphNum(){
        text.append("Количество предложений в тексте = " + indOfPar + ".\n");
        indOfPar++;
    }
}
