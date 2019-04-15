package com.expleo;

public class utils {
    public static String getTagValue(String xml, String tagName){
        return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];
        }
}
