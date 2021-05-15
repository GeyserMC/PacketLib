package com.github.steveice10.packetlib.tcp.io;

import io.netty.channel.local.LocalChannel;

import java.net.SocketAddress;

public class LocalChannelRemoteAddressWrapper extends ChannelWrapper {
    private volatile SocketAddress remoteAddress;

    public LocalChannelRemoteAddressWrapper(LocalChannel channel) {
        super(channel);
    }

    @Override
    public SocketAddress localAddress() {
        return source.localAddress();
    }

    @Override
    public SocketAddress remoteAddress() {
        if (remoteAddress == null) {
            return source.remoteAddress();
        }
        return remoteAddress;
    }

    public void remoteAddress(SocketAddress socketAddress) {
        remoteAddress = socketAddress;
    }
}
