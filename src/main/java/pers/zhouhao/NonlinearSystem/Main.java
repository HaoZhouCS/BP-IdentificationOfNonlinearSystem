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
        int errorNum = 0;
        int maxNum = NonlinearFunc.getStudyMaxNum();

        boolean success = false;
        while(!success && times < 10000) {
            times ++;

            errorNum = 0;
            for(int k = 1;k < maxNum - 1;k ++) {
                BP.study(Arrays.asList(_y[k], _y[k - 1], NonlinearFunc.u(k)), Arrays.asList(_y[k + 1]));
                double error = BP.getError();
                if(error > Math.pow(10, -4)) {
                    errorNum ++;
                }
            }

            if((double)errorNum/maxNum > 0.01) {
                success = false;
            } else {
                success = true;
            }

            System.out.println("times = " + times);
        }

        y[0] = y[1] = 0;
        for(int k = 1;k < maxNum - 1;k ++) {
            List<Double> predictList = BP.predict(Arrays.asList(_y[k], _y[k - 1], NonlinearFunc.u(k)));
            y[k + 1] = predictList.get(0);
        }

        OutputData.output("NonlinearFunc.txt", _y, maxNum);
        OutputData.output("NN_study_layer_3.txt", y, maxNum);
    }
}
