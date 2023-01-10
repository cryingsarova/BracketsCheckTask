public class App {
    public static void main(String[] args) {
        System.out.println(BracketsCheckService.getValidBracketsString("(()"));
        System.out.println(BracketsCheckService.getValidBracketsString(")()())"));
        System.out.println(BracketsCheckService.getValidBracketsString(")(()())"));
        System.out.println(BracketsCheckService.getValidBracketsString(")("));
        System.out.println(BracketsCheckService.getValidBracketsString(""));
        System.out.println(BracketsCheckService.getValidBracketsString("))))()(())()"));
    }
}
