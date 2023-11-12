package com.workmexh.common;

import java.util.Random;

public class ActSetNumber {
    public Integer setNumber(int length){
        Integer recNumber=0;
        Random random = new Random();
        for (int i = 0; i < length; i++) {

                recNumber += random.nextInt(99999);
            }


        return recNumber;


    }


}
