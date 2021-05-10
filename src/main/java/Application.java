public class Application {
    public static void main(String[] args) {

        AnalyzeFile in = new AnalyzeFile();
        in.scanList();
        for (int i = 0; i < in.getLines().size(); i++) {
            System.out.println(in.getLines().get(i));
        }

        in.checkList();

    }

}
