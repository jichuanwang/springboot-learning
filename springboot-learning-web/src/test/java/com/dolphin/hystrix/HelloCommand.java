package com.dolphin.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author jichuan.wang
 * @since 2018/12/4 15:18
 * <p>
 * </p>
 */
public class HelloCommand extends HystrixCommand<String> {

    public HelloCommand(String name){
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HelloWorldGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationThreadTimeoutInMilliseconds(5020)));
        this.name = name;
    }
    private final String name;

    @Override
    protected String getFallback() {
        return "exeucute Falled";
    }

    @Override
    protected String run() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1000);
        return "Hello " + name +" thread:" + Thread.currentThread().getName();
    }

    //调用实例
    public static void main(String[] args) throws Exception{
        //每个Command对象只能调用一次,不可以重复调用,
        //重复调用对应异常信息:This instance can only be executed once. Please instantiate a new instance.
        HelloCommand helloWorldCommand = new HelloCommand("Synchronous-hystrix");
        //使用execute()同步调用代码,效果等同于:helloWorldCommand.queue().get();
        String result = helloWorldCommand.execute();
        System.out.println("result=" + result);

        helloWorldCommand = new HelloCommand("Asynchronous-hystrix");
        //异步调用,可自由控制获取结果时机,
        Future<String> future = helloWorldCommand.queue();
        //get操作不能超过command定义的超时时间,默认:1秒
        result = future.get(100, TimeUnit.MILLISECONDS);
        System.out.println("result=" + result);
        System.out.println("mainThread=" + Thread.currentThread().getName());
    }

//运行结果: run()方法在不同的线程下执行
// result=Hello Synchronous-hystrix thread:hystrix-HelloWorldGroup-1
// result=Hello Asynchronous-hystrix thread:hystrix-HelloWorldGroup-2
// mainThread=main
}
