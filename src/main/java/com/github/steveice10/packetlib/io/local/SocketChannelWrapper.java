package com.github.steveice10.packetlib.io.local;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Pretends to be a SocketChannel.
 */
//TODO if ever
public class SocketChannelWrapper extends ChannelWrapper implements SocketChannel {
    private volatile InetSocketAddress localAddress = new InetSocketAddress(InetAddress.getLoopbackAddress(), 0);

    public SocketChannelWrapper(Channel channel) {
        super(channel);
    }

    @Override
    public InetSocketAddress localAddress() {
        return localAddress;
    }

    @Override
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Override
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    @Override
    public SocketChannelConfig config() {
        return (SocketChannelConfig) super.config();
    }

    @Override
    public boolean isInputShutdown() {
        return false;
    }

    @Override
    public ChannelFuture shutdownInput() {
        return null;
    }

    @Override
    public ChannelFuture shutdownInput(ChannelPromise channelPromise) {
        return null;
    }

    @Override
    public boolean isOutputShutdown() {
        return false;
    }

    @Override
    public ChannelFuture shutdownOutput() {
        return newPromise();
    }

    @Override
    public ChannelFuture shutdownOutput(ChannelPromise channelPromise) {
        return newPromise();
    }

    @Override
    public boolean isShutdown() {
        return false;
    }

    @Override
    public ChannelFuture shutdown() {
        return newPromise();
    }

    @Override
    public ChannelFuture shutdown(ChannelPromise channelPromise) {
        return newPromise();
    }
}
