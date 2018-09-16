package com.dolphin.encode;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjichuan on 2018/9/13.
 */
public class MsgPackTest {

    public static void main(String[] args) throws Exception{
        List<String> src = new ArrayList<>();
        src.add("msgpack");
        src.add("viver");
        MessagePack messagePack = new MessagePack();
        byte[] raw = messagePack.write(src);
        List<String> dst1 = messagePack.read(raw, Templates.tList(Templates.TString));
        System.out.println(dst1.get(0));
        System.out.println(dst1.get(1));
    }
}
