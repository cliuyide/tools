package test.codingtest;

import java.io.UnsupportedEncodingException;

import main.coding.codingconvent.CodingConvent;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "唐代";
        String str = CodingConvent.encode(a, "UTF-8");
        System.out.println(CodingConvent.decode(str, "UTF-8"));
    }
}
