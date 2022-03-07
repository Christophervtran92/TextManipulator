import java.util.*;
public class TextFormatter {
    Vector<String> exceptions;

    public TextFormatter(){}
    public TextFormatter(Vector<String> input)
    {
        exceptions = input;
    }

    public String format(String input, int type) {
        String output = "";
        switch (type) {
            case 0:
                output = capitalizeA(input);
                break;
            case 1:
                output = capitalizeB(input);
                break;
            case 2:
                output = capitalizeC(input);
                break;
            case 3:
                output = lowerCaseA(input);
                break;
            case 4:
                output = lowerCaseB(input);
                break;
            default:
        }
        return output;
    }

    //Capitalizes first letter in a sentence
    private String capitalizeA(String input)
    {
        char previous = ' ';
        char current;
        String output ="";

        current = input.charAt(0);
        current = Character.toUpperCase(current);
        output += current;
        for(int i = 1; i < input.length(); i++)
        {
            if(input.charAt(i) == ' ')
            {
                output += input.charAt(i);
            }
            else {
                if (previous == '.' || previous == '?' || previous == '!') {
                    current = Character.toUpperCase(input.charAt(i));
                    output += current;
                }
                else
                {
                    current = input.charAt(i);
                    output += current;
                }
            }
            previous = current;
        }
        return output;
    }

    private String capitalizeB(String input)
    {
        String output ="";

        for(int i = 0; i < input.length(); i++)
        {
            output += Character.toUpperCase(input.charAt(i));
        }
        return output;
    }

    private String capitalizeC(String input)
    {
        String output ="";
        char previous;

        output += Character.toUpperCase(input.charAt(0));
        previous = input.charAt(0);
        for(int i = 1; i < input.length(); i++)
        {
            if(previous == ' ')
                output += Character.toUpperCase(input.charAt(i));
            else
                output += input.charAt(i);
            previous = input.charAt(i);
        }
        return output;
    }

    private String lowerCaseA(String input)
    {
        char previous = ' ';
        char current;
        String output ="";

        current = input.charAt(0);
        current = Character.toLowerCase(current);
        output += current;
        for(int i = 1; i < input.length(); i++)
        {
            if(input.charAt(i) == ' ')
            {
                output += input.charAt(i);
            }
            else {
                if (previous == '.' || previous == '?' || previous == '!') {
                    current = Character.toLowerCase(input.charAt(i));
                    output += current;
                }
                else
                {
                    current = input.charAt(i);
                    output += current;
                }
            }
            //output += input.charAt(i);
            previous = current;
        }
        return output;
    }

    private String lowerCaseB(String input)
    {
        //char current;
        String output ="";

        for(int i = 0; i < input.length(); i++)
        {
            output += Character.toLowerCase(input.charAt(i));
        }
        return output;
    }
}
