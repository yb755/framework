package com.linzoe.common.utils;

import java.util.ArrayList;
import java.util.List;

public class DeviceTypeUtil {

    /**
     * @param uid2
     * @return java.lang.Integer  -1未知设备  0单相 1单相直流,2三相三线,3三相四线 4 网关 5 电力载波插座 6红外开关
     * @author zhongsheng
     * @remarks
     * @date  2019/12/31/031 11:36
     */
    public static Integer distinguishType(String uid2){
//        -2设备三相转单相
        int type=-1;
        if(uid2.startsWith("A0")){
            //单相
            type=0;
            if(uid2.startsWith("A060")){
                type=1;
            }
        }else if(uid2.startsWith("A2")){
            type=2;
        }else if(uid2.startsWith("00")||uid2.startsWith("A1")){
            type=3;
        }else if(uid2.startsWith("F0")){
            type=4;
        }else if(uid2.startsWith("C0")){
            type=5;
        }else if(uid2.startsWith("C2")){
            type=6;
        }
        return type;
    }

    public static List<String> getDeviceMappingData(int type){
        List <String> mappingData = new ArrayList<>();

        switch (type){
            case 0:
            case 1:
                mappingData.add("voltageA");
                mappingData.add("electricA");
                mappingData.add("temperatureA");
                mappingData.add("temperatureN");
                mappingData.add("energyCal");
                mappingData.add("powerA");
                mappingData.add("voltageALevel");
                mappingData.add("electricALevel");
                mappingData.add("temperatureALevel");
                mappingData.add("temperatureNLevel");
                break;
            case 2:
                mappingData.add("voltageA");
                mappingData.add("electricA");
                mappingData.add("temperatureA");

                mappingData.add("voltageB");
                mappingData.add("electricB");
                mappingData.add("temperatureB");

                mappingData.add("voltageC");
                mappingData.add("electricC");
                mappingData.add("temperatureC");

                mappingData.add("voltageBLevel");
                mappingData.add("electricBLevel");
                mappingData.add("temperatureBLevel");


                mappingData.add("voltageCLevel");
                mappingData.add("electricCLevel");
                mappingData.add("temperatureCLevel");

                mappingData.add("voltageALevel");
                mappingData.add("electricALevel");
                mappingData.add("temperatureALevel");

                mappingData.add("leakCurrentLevel");
                //mappingData.add("temperatureN");
                mappingData.add("leakCurrent");
                mappingData.add("energyCal");
                mappingData.add("powerA");
                mappingData.add("electricALevel");
                mappingData.add("temperatureALevel");
                mappingData.add("voltageALevel");
                mappingData.add("temperatureNLevel");
                break;
            case 3:
                mappingData.add("voltageA");
                mappingData.add("electricA");
                mappingData.add("temperatureA");

                mappingData.add("voltageB");
                mappingData.add("electricB");
                mappingData.add("temperatureB");

                mappingData.add("voltageC");
                mappingData.add("electricC");
                mappingData.add("temperatureC");

                mappingData.add("leakCurrent");
                mappingData.add("temperatureN");
                mappingData.add("energyCal");
                mappingData.add("powerA");

                mappingData.add("voltageBLevel");
                mappingData.add("electricBLevel");
                mappingData.add("temperatureBLevel");


                mappingData.add("voltageCLevel");
                mappingData.add("electricCLevel");
                mappingData.add("temperatureCLevel");

                mappingData.add("voltageALevel");
                mappingData.add("electricALevel");
                mappingData.add("temperatureALevel");

                mappingData.add("temperatureNLevel");
                mappingData.add("leakCurrentLevel");


                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
        return mappingData;
    }
}
