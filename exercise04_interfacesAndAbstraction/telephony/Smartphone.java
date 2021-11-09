package exercise04_interfacesAndAbstraction.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String url : urls) {
            if (url.matches("^[^0-9]+$")) {
                builder.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                builder.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }


    @Override
    public String call() {
        StringBuilder builder = new StringBuilder();
        for (String number : numbers) {
            if (number.matches("^[0-9]+$")) {
                builder.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                builder.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}


