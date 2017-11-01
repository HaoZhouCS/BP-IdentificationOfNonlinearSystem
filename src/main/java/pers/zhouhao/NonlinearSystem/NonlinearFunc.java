package pers.zhouhao.NonlinearSystem;

/**
 * Created by lenovo on 2017/11/1.
 */
public class NonlinearFunc {

    private final static int MAX_NUM = 2000;

    private static double _y[] = new double[MAX_NUM];

    static {
        _y[0] = _y[1] = 0;
        for(int k = 1;k < MAX_NUM - 1;k ++) {
            _y[k + 1] = 0.3 * _y[k] + 0.6 * _y[k - 1] + 0.1 * f(u(k));
        }
    }

    public static int getStudyMaxNum() {
        return MAX_NUM;
    }

    public static double u(double k) {
        return Math.sin(2 * Math.PI * k / 150);
    }

    public static double f(double x) {
        return 0.6 * Math.sin(Math.PI * x) + 0.3 * Math.sin(3 * Math.PI * x) + 0.1 * Math.sin(5 * Math.PI * x);
    }

    public static double y(int k) {
        return _y[k];
    }

    public static double[] getY() {
        return _y;
    }
}
