

public class App {
   

    public static void main(String[] args) {
        AdEffect("Hello, World!", 20, 100);
    }


    public static void AdEffect(String str, int RepeatCount, int Waittime) {
        str = " " + str;

       
        for (int i = 0; i < RepeatCount; i++) {

        char ch1 = str.charAt(str.length() - 1);

        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }

        str = ch1 + str;

        System.out.println(str);
        try {
            Thread.sleep(Waittime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        }
    }


    public static void ColorExample() {
        System.out.println(ConsoleColors.BLUE_BACKGROUND + "Blue");
        System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + "Light Blue");
        System.out.println(ConsoleColors.CYAN_BACKGROUND + "Cyan");
        System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT + "Light Cyan" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BOLD + "Red Underlined");
        System.out.println(ConsoleColors.GREEN + "Red Underlined" + ConsoleColors.RESET);
    }

}
