package baseball.util;

import baseball.common.Constant;
import baseball.dto.BaseBallDto;
import nextstep.utils.Randoms;

import java.util.*;

public final class BaseBallUtil {

    public static int[] getInputStrToNums(String reqInput) {
        int inputSize = reqInput.length();
        int[] nums = new int[inputSize];
        for( int i = 0; i < inputSize; i++ ) {
            nums[i] = Character.getNumericValue(reqInput.charAt(i));
        }
        return nums;
    }

    public static int[] getRandomGenerateNum() {
        int size = Constant.INT_THREE;
        int[] num = new int[size];
        Set<Integer> numSet = new HashSet<>();
        while(numSet.size()<size){
            numSet.add(Randoms.pickNumberInRange(Constant.INT_ONE, Constant.INT_NINE));
        }
        Iterator<Integer> itInt = numSet.iterator();
        int i = Constant.INT_ZERO;
        while(itInt.hasNext()){
            num[i++] = itInt.next();
        }
        return num;
    }

    public static BaseBallDto checkNum(int[] randomNum, int[] inputNum) {
        int strike = Constant.INT_ZERO;
        int ball = Constant.INT_ZERO;
        for(int i = 0; i < Constant.INT_THREE; i++)
            strike += getCheckStrike(randomNum[i], inputNum[i]);
        for(int i = 0; i < Constant.INT_THREE; i++)
            ball += getCheckBall(randomNum, i, inputNum[i]);
        return new BaseBallDto(strike, ball);
    }

    public static int getCheckStrike(int random, int input) {
        int strike = Constant.INT_ZERO;
        if( random == input ) return strike+1;
        return strike;
    }

    public static int getCheckBall(int[] randomNum, int index, int input) {
        int ball = Constant.INT_ZERO;
        ArrayList<Integer> integerArray = new ArrayList<>(randomNum.length);
        for (int i : randomNum) {
            integerArray.add(i);
        }
        if ( randomNum[index] != input && integerArray.contains(input) ) ball++;
        return ball;
    }

    public static String updateMessage(int strike, int ball) {
        String message = Constant.STR_EMPTY;
        if( strike > Constant.INT_ZERO ) message = strike + Constant.STR_STRIKE;
        if( ball > Constant.INT_ZERO ) message = ball + Constant.STR_BALL;
        if( strike > Constant.INT_ZERO && ball > Constant.INT_ZERO )
            message = strike + Constant.STR_STRIKE + " " + ball + Constant.STR_BALL;
        if( strike == Constant.INT_ZERO && ball == Constant.INT_ZERO )
            message = Constant.STR_NOTHING;
        return message;
    }

    public static boolean charactersCheckNum(int[] nums) {
        boolean charactersCheck = true;
        for( int a : nums) {
            charactersCheck = charactersCheckNum(a);
        }
        return charactersCheck;
    }

    private static boolean charactersCheckNum(int num) {
        boolean result = true;
        if( num < Constant.INT_ZERO || num > Constant.INT_TEN ) {
            result = false;
        }
        return result;
    }

    public static boolean sizeCheckNum(int[] nums) {
        boolean sizeCheck = true;
        if( nums.length != Constant.INT_THREE ) {
            sizeCheck = false;
        }
        return sizeCheck;
    }

    public static boolean duplicateNum(int[] nums) {
        boolean duplicate = true;
        Set<Integer> list = new HashSet<>();
        for( int check : nums ) {
            list.add(check);
        }
        if( list.size() != nums.length ) {
            duplicate = false;
        }
        return duplicate;
    }

    private BaseBallUtil(){}
}
