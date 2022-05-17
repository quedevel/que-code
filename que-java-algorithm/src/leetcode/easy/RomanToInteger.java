package leetcode.easy;

public class RomanToInteger {

    enum SymbolValue {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        private int value;

        SymbolValue(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    public int romanToInt(String s) {
        int result = 0;
        String[] sArr = s.split("");

        for (int i = 0; i < s.length(); i++) {
            if (i != s.length()-1){
                if (validation(sArr[i], sArr[i+1])){
                    result -= SymbolValue.valueOf(sArr[i]).getValue();
                } else {
                    result += SymbolValue.valueOf(sArr[i]).getValue();
                }
            } else {
                result += SymbolValue.valueOf(sArr[i]).getValue();
            }
        }

        return result;
    }

    //    V(5)와 X(10) 앞에 I를 놓아 4와 9를 만들 수 있습니다.
    //    X는 L(50)과 C(100) 앞에 위치하여 40과 90을 만들 수 있습니다.
    //    C는 D(500)와 M(1000) 앞에 위치하여 400과 900을 만들 수 있습니다.
    public boolean validation(String current, String next){
        boolean result = false;
        if (SymbolValue.C == SymbolValue.valueOf(current)
                && ( SymbolValue.D == SymbolValue.valueOf(next) || SymbolValue.M == SymbolValue.valueOf(next))){
            result = true;
        } else if (SymbolValue.X == SymbolValue.valueOf(current)
                && ( SymbolValue.L == SymbolValue.valueOf(next) || SymbolValue.C == SymbolValue.valueOf(next))) {
            result = true;
        } else if (SymbolValue.I == SymbolValue.valueOf(current)
                && ( SymbolValue.V == SymbolValue.valueOf(next) || SymbolValue.X == SymbolValue.valueOf(next))) {
            result = true;
        }
        return result;
    }
}
