package clean.code.meaningfulname;

import java.util.Date;

import static java.lang.System.out;


public class MeaningfulName {

    int d; // 경과 시간(단위 : 날짜)

    int elapsedTimeInDays;
    int daysSinceCreation;
    int daysSinceModification;
    int fileAgeInDays;

    private Date genymdhms;
    private Date modymdhms;
    private final String pszqint = "102";

    private Date generationTimestamp;
    private Date modificationTimestamp;
    private final String recordId = "102";

    public static void copyChars(char[] source, char[] destination){
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    private String number;
    private String verb;
    private String pluralModifier;

    private void make(char candidate, int count){
        createPluralDependentMessageParts(count);
        String guessMessage = String.format(
                "There %s %s %s%s", verb, number, candidate, pluralModifier
        );
        out.print(guessMessage);
    }

    private void createPluralDependentMessageParts(int count) {
        if (count == 0) {
            thereAreNoLetters();
        } else if (count == 1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreNoLetters() {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreManyLetters(int count) {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }

}
