clear;
dataY_ = textread('D:\My_File\�ҵı��\�˹�������\BP�㷨\BP-IdentificationOfNonlinearSystem\\NonlinearFunc.txt');
dataY = textread('D:\\My_File\\�ҵı��\\�˹�������\\BP�㷨\\BP-IdentificationOfNonlinearSystem\\NN_study_layer_5.txt');

X1 = dataY_(:, 1);
Y1 = dataY_(:, 2);

X2 = dataY(:, 1);
Y2 = dataY(:, 2);

plot(X1, Y1, 'g');
hold on;
plot(X2, Y2, 'r');

legend('������ϵͳ���','���������');