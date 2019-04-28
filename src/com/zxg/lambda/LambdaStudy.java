package com.zxg.lambda;

import java.util.function.Function;

public class LambdaStudy {

    public void action(OnActionListener listener){
        listener.onAction("123");
    }

    public static void main(String[] args) {

    }

    private void simpleLambda(){
        LambdaStudy study = new LambdaStudy();
        study.action(new OnActionListener() {
            @Override
            public void onAction(String action) {

            }
        });
        study.action(action->
            System.out.println(action)
        );

        OnActionListener listener = action -> {
            System.out.println(action);
        };
    }

    interface OnActionListener{
        void onAction(String action);
    }
}
