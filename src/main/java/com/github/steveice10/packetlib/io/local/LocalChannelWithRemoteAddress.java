package com.github.steveice10.packetlib.io.local;

import io.netty.channel.local.LocalChannel;

import java.net.InetSocketAddress;

/**
 * Client -> server storing the spoofed remote address.
 */
public class LocalChannelWithRemoteAddress extends LocalChannel {
    private InetSocketAddress spoofedAddress;

    public InetSocketAddress spoofedRemoteAddress() {
        return spoofedAddress;
    }

    public void spoofedRemoteAddress(InetSocketAddress socketAddress) {
        this.spoofedAddress = socketAddress;
    }
}
