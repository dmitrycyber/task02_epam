package by.epamtc.homework.string;

import java.math.BigInteger;

public class Main {
    private static final String EXTRA_SPACES_REGEX = "\\s{2,}";
    private static final String WORDS_REGEX = "[^А-яA-z\\-]+";

    public static void main(String[] args) {
        String stringData = "Программное обеспечение MediaWiki используется десятками тысяч веб-сайтов";

        System.out.println(twoStringsWithOddEvenChars(stringData));

        System.out.println(upperCaseLoweCaseRatio(stringData));

        System.out.println(stringWithoutDuplicateChars(stringData));

        System.out.println(charCount(stringData, 'л'));

        System.out.println(reverseString(stringData));

        System.out.println(stringWithInsertString(stringData, "@@", 5));

        System.out.println(stringWithoutSubString(stringData, "ва"));

        System.out.println(subString(stringData, 0, 2));

        System.out.println(stringLength(stringData));

        System.out.println(subStringQuantity(stringData, "ва"));

        System.out.println(stringWithReversedWordOrder(stringData));

        System.out.println(stringWithReplacedSpaces(stringData));

        System.out.println(stringReplacedLettersInLongestWord(stringData, "и", "@"));

        System.out.println(shortestWordLength(stringData));

        System.out.println(wordQuantity(stringData));

        System.out.println(stringWithSwappedWords(stringData, 0, 1));

        System.out.println(stringWithoutLastWord(stringData));

        System.out.println(addSpacesToString(stringData, 10, 0));

        System.out.println(isPalindrome("qweewq"));

        System.out.println(stringWithReplacedSubString(stringData, "обеспечение", "123qwe"));

        System.out.println(sumOfLargeNumbers("10000000000111000000005", "20000000000011100000001"));

        System.out.println(deleteWordsFromString(stringData, 11));

        System.out.println(removeExtraSpaces(stringData));
    }

    private static TwoStringModel twoStringsWithOddEvenChars(String stringData) {
        char[] charArray = stringData.toCharArray();

        StringBuilder firstString = new StringBuilder();

        StringBuilder secondString = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 == 0) {
                firstString.append(charArray[i]);
                continue;
            }
            secondString.append(charArray[i]);
        }

        return new TwoStringModel(firstString.toString(), secondString.toString());
    }

    private static double upperCaseLoweCaseRatio(String stringData) {
        String upperCaseString = stringData.replaceAll("[a-zа-я]", "");
        String lowerCaseString = stringData.replaceAll("[A-ZА-Я]", "");

        double lowerCaseSymbolsCount = stringData.length() - upperCaseString.length();
        double upperCaseSymbolsCount = stringData.length() - lowerCaseString.length();

        return (upperCaseSymbolsCount / lowerCaseSymbolsCount) * 100;
    }


    private static String stringWithoutDuplicateChars(String stringData) {
        StringBuilder stringWithoutDuplicates = new StringBuilder();

        for (int i = 0; i < stringData.length(); i++) {
            if (!stringWithoutDuplicates.toString().contains(stringData.substring(i, i + 1))) {
                stringWithoutDuplicates.append(stringData.charAt(i));
            }
        }

        return stringWithoutDuplicates.toString();
    }

    private static int charCount(String stringData, char symbol) {
        String stringWithoutChar = stringData.replaceAll(String.valueOf(symbol), "");

        return stringData.length() - stringWithoutChar.length();
    }


    private static String reverseString(String stringData) {
        StringBuilder sb = new StringBuilder(stringData);

        return sb.reverse().toString();
    }


    private static String stringWithInsertString(String stringData, String appendString, int index) {
        StringBuilder sb = new StringBuilder(stringData);
        return sb.insert(index, appendString).toString();
    }

    private static String stringWithoutSubString(String stringData, String subString) {
        return stringData.replaceAll(subString, "");
    }


    private static String subString(String stringData, int firstIndex, int secondIndex) {
        return stringData.substring(firstIndex, secondIndex);
    }

    private static int stringLength(String stringData) {
        return stringData.length();
    }

    private static int subStringQuantity(String stringData, String subString) {
        int lengthWithoutSubString = stringData.replaceAll(subString, "").length();

        return (stringData.length() - lengthWithoutSubString) / subString.length();
    }

    private static String stringWithReversedWordOrder(String stringData) {
        String[] words = stringData.split(" ");

        StringBuilder stringWithReverserWordOrder = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            stringWithReverserWordOrder.append(words[i]).append(" ");
        }

        return stringWithReverserWordOrder.toString();
    }

    private static String stringWithReplacedSpaces(String stringData) {
        return stringData.replaceAll(" ", "*");
    }

    private static String stringReplacedLettersInLongestWord(String stringData, String from, String to) {
        String[] words = wordsFromString(stringData);

        String tempLongestWord = words[0];

        int indexOfLongestWord = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > tempLongestWord.length()) {
                tempLongestWord = words[i];
                indexOfLongestWord = i;
            }
        }
        String longestWordWithReplacedLetters = tempLongestWord.replaceAll(from, to);

        StringBuilder stringWithReplacedLettersInLongestWord = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i == indexOfLongestWord) {
                stringWithReplacedLettersInLongestWord.append(longestWordWithReplacedLetters).append(" ");
                continue;
            }
            stringWithReplacedLettersInLongestWord.append(words[i]).append(" ");
        }

        return stringWithReplacedLettersInLongestWord.toString();
    }


    private static int shortestWordLength(String stringData) {
        String[] words = wordsFromString(stringData);

        String tempShortestWord = words[0];

        for (String word : words) {
            if (word.length() < tempShortestWord.length()) {
                tempShortestWord = word;
            }
        }
        return tempShortestWord.length();
    }

    private static int wordQuantity(String stringData) {
        return wordsFromString(stringData).length;
    }


    private static String stringWithSwappedWords(String stringData, int firstWord, int secondWord) {
        String[] words = wordsFromString(stringData);
        StringBuilder stringWithReplacedWords = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i == firstWord) {
                stringWithReplacedWords.append(words[secondWord]).append(" ");
                continue;
            } else if (i == secondWord) {
                stringWithReplacedWords.append(words[firstWord]).append(" ");
                continue;
            }
            stringWithReplacedWords.append(words[i]).append(" ");
        }

        return stringWithReplacedWords.toString();
    }

    private static String stringWithoutLastWord(String stringData) {
        String[] words = wordsFromString(stringData);

        StringBuilder stringWithoutLastWord = new StringBuilder();

        for (int i = 0; i < words.length - 1; i++) {
            stringWithoutLastWord.append(words[i]).append(" ");
        }
        return stringWithoutLastWord.toString();
    }

    private static String addSpacesToString(String stringData, int countOfSpaces, int index) {
        StringBuilder sb = new StringBuilder(stringData);

        return sb.insert(index, " ".repeat(countOfSpaces)).toString();
    }

    private static boolean isPalindrome(String stringData) {
        StringBuilder sb = new StringBuilder(stringData);

        return sb.toString().equals(sb.reverse().toString());
    }

    private static String stringWithReplacedSubString(String stringData, String from, String to) {
        return stringData.replaceAll(from, to);
    }

    private static String sumOfLargeNumbers(String firstNumber, String secondNumber) {
        return new BigInteger(firstNumber).add(new BigInteger(secondNumber)).toString();
    }

    private static String deleteWordsFromString(String stringData, int wordLength) {
        String[] words = wordsFromString(stringData);

        StringBuilder stringWithDeletedWords = new StringBuilder();

        for (String word : words) {
            if (word.length() != wordLength) {
                stringWithDeletedWords.append(word).append(" ");
            }
        }
        return stringWithDeletedWords.toString();
    }

    private static String removeExtraSpaces(String stringData) {
        return stringData.trim().replaceAll(EXTRA_SPACES_REGEX, " ");
    }

    private static String[] wordsFromString(String stringData) {
        return stringData.split(WORDS_REGEX);
    }
}
