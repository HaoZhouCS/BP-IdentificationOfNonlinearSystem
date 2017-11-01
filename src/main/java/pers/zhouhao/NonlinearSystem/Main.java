package pers.zhouhao.NonlinearSystem;

import pers.zhouhao.bp.BackPropagation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/1.
 */
public class Main {

    private static double y[] = new double[NonlinearFunc.getStudyMaxNum()];
    private static double _y[] = NonlinearFunc.getY();

    public static void main(String[] args) {

        BackPropagation BP = new BackPropagation(3, 1, 3, 4, 0.1);

        int times = 0;
        int max_num = NonlinearFunc.getStudyMaxNum();

        boolean success = false;
        while(!success && times < 10000) {
            times ++;

            success = true;
            for(int k = 1;k < max_num - 1;k ++) {
                BP.study(Arrays.asList(_y[k], _y[k - 1], NonlinearFunc.u(k)), Arrays.asList(_y[k + 1]));
                double error = BP.getError();
                if(error > Math.pow(10, -2)) {
                    success = false;
                }
            }

            System.out.println("times = " + times);
        }

        y[0] = y[1] = 0;
        for(int k = 1;k < max_num - 1;k ++) {
            List<Double> predictList = BP.predict(Arrays.asList(_y[k], _y[k - 1], NonlinearFunc.u(k)));
            y[k + 1] = predictList.get(0);
        }

        OutputData.output("NonliearFunc.txt", _y, max_num);
        OutputData.output("NN.txt", y, max_num);
    }
}
