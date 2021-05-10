public class Application {
    public static void main(String[] args) {

        Input in = new Input();
        in.scanList();
        for (int i = 0; i < in.getLines().size(); i++) {
            System.out.print(in.getLines().get(i));
        }

        in.checkColumns();

    }

}
