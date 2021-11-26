package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int COUNT = 3;

    private Numbers numbers;

   public void generateNumber() {
       numbers = new Numbers(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT));
   }
}
