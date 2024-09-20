package org.knit.lab1;


import java.util.Objects;

public class Task2 {
    public void execute() {
        String urlValue = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
        SimpleUrl url = new SimpleUrl("https", "dom.ru");
        url.setPage("1072");
        url.setIntParam(1234);
        url.setDoubleParam(3.14);
        url.setTextParam("someText");
        System.out.println(url);
    }

    static class SimpleUrl {
        private String protocol;
        private String domen;
        private String page;
        private int intParam = 0;
        private double doubleParam = 3.14;
        private String textParam = "a";
        private String fullUrl;

        public SimpleUrl(String protocol, String domen) {
            this.protocol = protocol;
            this.domen = domen;
            constructUrl();
        }

        private void constructUrl() {
            if (!Objects.equals(page, "")) {
                fullUrl = protocol + "://" + domen + "/" + page + "?" + "intParam=" + intParam +
                        "&" + "doubleParam=" + doubleParam + "&" + "textParam=" + textParam;
            }
            else {
                fullUrl = protocol + "://" + domen + "?" + intParam + "=" + intParam +
                        "&" + doubleParam + "=" + doubleParam + "&" + textParam + "=" + textParam;
            }
        }

        public void setProtocol(String protocol) {
            this.protocol = protocol;
            constructUrl();
        }

        public void setDomen(String domen) {
            this.domen = domen;
            constructUrl();
        }

        public void setPage(String page) {
            this.page = page;
            constructUrl();
        }

        public void setIntParam(int intParam) {
            this.intParam = intParam;
            constructUrl();
        }

        public void setDoubleParam(double doubleParam) {
            this.doubleParam = doubleParam;
            constructUrl();
        }

        public void setTextParam (String textParam) {
            this.textParam = textParam;
            constructUrl();
        }

        public void getFullUrl() {
            System.out.println(fullUrl);
        }

        public String toString() {
            String output = "fullUrl = " + fullUrl + "\n" +
                    "protocol = " + protocol + "\n" +
                    "domen = " + domen + "\n" +
                    "page = " + page + "\n" +
                    "intParam = " + intParam + "\n" +
                    "doubleParam = " + doubleParam + "\n" +
                    "textParam = " + textParam;
            return output;
        }
    }
}
