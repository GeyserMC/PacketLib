package com.github.steveice10.packetlib.io.local;

import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalServerChannel;

/**
 * If the incoming channel if an instance of LocalChannelWithRemoteAddress, this server creates a LocalChannelWrapper
 * for the other end and attaches the spoofed remote address
 */
public class LocalServerChannelWrapper extends LocalServerChannel {
    @Override
    protected LocalChannel newLocalChannel(LocalChannel peer) {
        // LocalChannel here should be an instance of LocalChannelWithRemoteAddress, which we can use to set the "remote address" on the other end
        if (peer instanceof LocalChannelWithRemoteAddress) {
            LocalChannelWrapper channel = new LocalChannelWrapper(this, peer);
            channel.wrapper().remoteAddress(((LocalChannelWithRemoteAddress) peer).spoofedRemoteAddress());
            return channel;
        }
        return super.newLocalChannel(peer);
    }
}
