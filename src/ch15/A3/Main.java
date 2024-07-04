package ch15.A3;

public class Main {
    public static void main(String[] args) {
        String title = "Welcome!";
        String message = "Hello, world!";
        String html =
        """
        <!DOCTYPE html>
        <html>
            <head>
                <title>%s</title>
            </head>
            <body>
                <h1 style="text-align: center">%s</h1>
            </body>
        </html>
        """.formatted(title, message);
        System.out.print(html);

        String name = "csh";
        String x =
        """
        Duksung
        Wonmen's
        Univ
        My name is %s
        """.formatted(name);   
        System.out.print(x);
    }
}
