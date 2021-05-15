package com.github.steveice10.packetlib.tcp.io;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.local.LocalChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public abstract class ChannelWrapper implements Channel {
    protected final Channel source;

    public ChannelWrapper(Channel channel) {
        this.source = channel;
    }

    @Override
    public ChannelId id() {
        return source.id();
    }

    @Override
    public EventLoop eventLoop() {
        return source.eventLoop();
    }

    @Override
    public Channel parent() {
        return source.parent();
    }

    @Override
    public ChannelConfig config() {
        return source.config();
    }

    @Override
    public boolean isOpen() {
        return source.isOpen();
    }

    @Override
    public boolean isRegistered() {
        return source.isRegistered();
    }

    @Override
    public boolean isActive() {
        return source.isActive();
    }

    @Override
    public ChannelMetadata metadata() {
        return source.metadata();
    }

    @Override
    public ChannelFuture closeFuture() {
        return source.closeFuture();
    }

    @Override
    public boolean isWritable() {
        return source.isWritable();
    }

    @Override
    public long bytesBeforeUnwritable() {
        return source.bytesBeforeUnwritable();
    }

    @Override
    public long bytesBeforeWritable() {
        return source.bytesBeforeWritable();
    }

    @Override
    public Unsafe unsafe() {
        return source.unsafe();
    }

    @Override
    public ChannelPipeline pipeline() {
        return source.pipeline();
    }

    @Override
    public ByteBufAllocator alloc() {
        return source.alloc();
    }

    @Override
    public ChannelFuture bind(SocketAddress socketAddress) {
        return source.bind(socketAddress);
    }

    @Override
    public ChannelFuture connect(SocketAddress socketAddress) {
        return source.connect(socketAddress);
    }

    @Override
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress1) {
        return source.connect(socketAddress, socketAddress1);
    }

    @Override
    public ChannelFuture disconnect() {
        return source.disconnect();
    }

    @Override
    public ChannelFuture close() {
        return source.disconnect();
    }

    @Override
    public ChannelFuture deregister() {
        return source.deregister();
    }

    @Override
    public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return source.bind(socketAddress, channelPromise);
    }

    @Override
    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return source.connect(socketAddress, channelPromise);
    }

    @Override
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress1, ChannelPromise channelPromise) {
        return source.connect(socketAddress, socketAddress1, channelPromise);
    }

    @Override
    public ChannelFuture disconnect(ChannelPromise channelPromise) {
        return source.disconnect(channelPromise);
    }

    @Override
    public ChannelFuture close(ChannelPromise channelPromise) {
        return source.close(channelPromise);
    }

    @Override
    public ChannelFuture deregister(ChannelPromise channelPromise) {
        return source.deregister(channelPromise);
    }

    @Override
    public Channel read() {
        return source.read();
    }

    @Override
    public ChannelFuture write(Object o) {
        return source.write(o);
    }

    @Override
    public ChannelFuture write(Object o, ChannelPromise channelPromise) {
        return source.write(o, channelPromise);
    }

    @Override
    public Channel flush() {
        return source.flush();
    }

    @Override
    public ChannelFuture writeAndFlush(Object o, ChannelPromise channelPromise) {
        return source.writeAndFlush(o, channelPromise);
    }

    @Override
    public ChannelFuture writeAndFlush(Object o) {
        return source.writeAndFlush(o);
    }

    @Override
    public ChannelPromise newPromise() {
        return source.newPromise();
    }

    @Override
    public ChannelProgressivePromise newProgressivePromise() {
        return source.newProgressivePromise();
    }

    @Override
    public ChannelFuture newSucceededFuture() {
        return source.newSucceededFuture();
    }

    @Override
    public ChannelFuture newFailedFuture(Throwable throwable) {
        return source.newFailedFuture(throwable);
    }

    @Override
    public ChannelPromise voidPromise() {
        return source.voidPromise();
    }

    @Override
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        return source.attr(attributeKey);
    }

    @Override
    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        return source.hasAttr(attributeKey);
    }

    @Override
    public int compareTo(Channel o) {
        return source.compareTo(o);
    }
}
