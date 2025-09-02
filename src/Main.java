import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

		 // 确保至少前两个参数存在
        if (args == null || args.length < 2) {
            System.out.println("providing the first two parameters at least！");
            return;
        }

        // 构建完整参数数组
        String[] fullArgs = new String[4];
        fullArgs[0] = args[0]; // 第1个参数来自命令行
        fullArgs[1] = args[1]; // 第2个参数来自命令行

        // 后两个参数使用默认值，如果命令行提供就覆盖
        fullArgs[2] = (args.length >= 3) ? args[2] : "0";   // 默认值 0
        fullArgs[3] = (args.length >= 4) ? args[3] : "12";  // 默认值 12


      Improve_new max9Test = new Improve_new();
//      args = new String[]{"p-hat500-1.mtx", "r1.txt","0","12"};
      max9Test.main(fullArgs);

//        System.out.println("test");
    }


}
