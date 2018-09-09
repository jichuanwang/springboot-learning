package com.dolphin.base.akka;

import akka.actor.UntypedActor;
import org.junit.Test;

/**
 * Created by wangjichuan on 2018/8/19.
 */
public class AkkATest {

    @Test
    public void test(){

    }

    class Greeter extends UntypedActor{


        @Override
        public void onReceive(Object message) throws Exception {
            if(message == Msg.GREET){
                System.out.println("hello world!!!");
                getSender().tell(Msg.DONE,getSelf());
            }else unhandled(message);
        }
    }

    static enum Msg{
        GREET,DONE;
    }
}
