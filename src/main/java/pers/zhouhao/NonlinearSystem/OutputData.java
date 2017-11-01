package pers.zhouhao.NonlinearSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by lenovo on 2017/11/1.
 */
public class OutputData {

    public static void output(String filename, double[] data, int dataLen) {

        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);

            for(int i = 0;i < dataLen;i ++) {
                bw.write(i + " " + data[i] + "\n");
            }

            bw.close();
            fw.close();

        } catch (Exception e) {

        }
    }
}
