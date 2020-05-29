package day10.SeasobA;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        // int seasonA=SeasonA.SUMMER;
        // System.out.println(f(SeasonA.SUMMER));
        // f(-6);
        //
        // SeasonB seasonB=SeasonB.SUMMER;
        // f(SeasonB.SUMMER);

        SeasonC seasonC = SeasonC.SPRING;
        f(SeasonC.SUMMER);
    }
    // public static String f(int season){
    //     switch (season){
    //         case SeasonA.SPRING:return "春天";
    //         case SeasonA.SUMMER:return "夏天";
    //         case SeasonA.AUTUMN:return "秋天";
    //         case SeasonA.WINTER:return "冬天";
    //
    //     }
    //     return null;
    // }

    // public static String f(SeasonB season){
    //     switch (season){
    //         case SeasonA.SPRING:return "春天";
    //         case SeasonA.SUMMER:return "夏天";
    //         case SeasonA.AUTUMN:return "秋天";
    //         case SeasonA.WINTER:return "冬天";
    //
    //     }
    //     return null;
    // }

    public static String f(SeasonC seasonC) {
        switch (seasonC) {
            case SPRING:
                return "春天";
            case SUMMER:
                return "夏天";
            case AUTUMN:
                return "秋天";
            case WINTER:
                return "冬天";
        }
        return null;
    }


}
