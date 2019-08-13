package com.laifeng.sopcastsdk.stream.packer;

import android.media.MediaCodec;

import java.nio.ByteBuffer;

/**
 * @Title: Packer
 * @Package com.laifeng.sopcastsdk.stream.packer.flv
 * @Description:
 * @Author Jim
 * @Date 16/9/14
 * @Time 上午11:19
 * @Version
 */
public interface Packer {
    interface OnPacketListener {
        // The first parameter is the packaged data, the second is the custom packaged type
        void onPacket(byte[] data, int packetType);
    }

    // Set the package listener
    void setPacketListener(OnPacketListener listener);

    // Process the data output by the video hard encoder
    void onVideoData(ByteBuffer bb, MediaCodec.BufferInfo bi);

    // Processing the audio hard encoder output data
    void onAudioData(ByteBuffer bb, MediaCodec.BufferInfo bi);

    // Start packaging, generally pre-packaging
    void start();

    // End the packaging, generally the status of the packager recovery
    void stop();
}