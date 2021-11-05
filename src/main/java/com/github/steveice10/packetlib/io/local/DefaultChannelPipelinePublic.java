package com.github.steveice10.packetlib.io.local;

import io.netty.channel.Channel;
import io.netty.channel.DefaultChannelPipeline;

/**
 * Exists solely to make DefaultChannelPipeline's protected constructor public
 */
public class DefaultChannelPipelinePublic extends DefaultChannelPipeline {
    public DefaultChannelPipelinePublic(Channel channel) {
        super(channel);
    }
}
