package com.github.steveice10.packetlib.io.local;

import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalServerChannel;

import java.net.InetSocketAddress;

public class LocalChannelWrapper extends LocalChannel {
    private final ChannelWrapper wrapper;
    /**
     * {@link #newChannelPipeline()} is called during super, so this exists until the wrapper can be initialized.
     */
    private volatile ChannelWrapper tempWrapper;

    public LocalChannelWrapper() {
        wrapper = new ChannelWrapper(this);
    }

    public LocalChannelWrapper(LocalServerChannel parent, LocalChannel peer) {
        super(parent, peer);
        if (tempWrapper == null) {
            this.wrapper = new ChannelWrapper(this);
        } else {
            this.wrapper = tempWrapper;
        }
        wrapper.remoteAddress(new InetSocketAddress(0));
    }

    public ChannelWrapper wrapper() {
        return wrapper;
    }

    @Override
    protected DefaultChannelPipeline newChannelPipeline() {
        if (wrapper != null) {
            return new DefaultChannelPipelinePublic(wrapper);
        } else if (tempWrapper != null) {
            return new DefaultChannelPipelinePublic(tempWrapper);
        } else {
            tempWrapper = new ChannelWrapper(this);
            return new DefaultChannelPipelinePublic(tempWrapper);
        }
    }
}
