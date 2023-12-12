package Service;

public class AppRun {
    public AppRun() {
    }

    public void appRun() {
        InputString inStr = new InputString();
        String s = inStr.inputString();
        String path = "src/Output/";
//        String s, s1, s2, s3;
//        s = "Petrov Sergei Ivanovich 1985.12.15 375294567891 f";
//        s1 = "Sidorov Ivan Petrovich 1946.01.09 375443652418 m";
//        s2 = "Shpak Semen Alekseevich 1996.05.01 375259576252 m";
//        s3 = "Shpak Ekaterina Semenovna 1973.02.23 375339568475 f";
        Launcher run = new Launcher();
        run.launcher(s, path);
//        run.launcher(s1, path);
//        run.launcher(s2, path);
//        run.launcher(s3, path);
    }
}
