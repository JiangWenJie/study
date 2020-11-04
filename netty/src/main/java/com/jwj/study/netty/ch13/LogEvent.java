package com.jwj.study.netty.ch13;

import java.net.InetSocketAddress;

/**
 * @Author: jwj
 * @Date: 2020/7/20 16:18
 * @Description: TODO
 */
public class LogEvent {
    public static final byte SEPARATOR=(byte)':';

    private final InetSocketAddress source;

    private final String logfile;

    private final String msg;

    private final long received;

    public LogEvent(String logfile,String msg){
        this(null,-1,logfile,msg);
    }

    public LogEvent(InetSocketAddress source, long received, String logfile, String msg) {
        this.source = source;
        this.logfile = logfile;
        this.msg = msg;
        this.received = received;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getLogfile() {
        return logfile;
    }

    public String getMsg() {
        return msg;
    }

    public long getReceived() {
        return received;
    }
}
